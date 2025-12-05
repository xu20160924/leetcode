import org.apache.spark.sql.{SparkSession, DataFrame}

object SparkJoinExecutionPlan {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("JoinExecutionPlanTest")
      .master("local[*]") // 使用所有本地线程，适合测试
      .config("spark.sql.autoBroadcastJoinThreshold", -1) // 禁用广播join，便于观察
      .getOrCreate()

    // 创建测试数据（扩大数据量以观察性能差异）
    val data1 = (1 to 100).map(i => (i, i % 20 + 20, if (i % 3 == 0) "本科" else "硕士"))
    val df1: DataFrame = spark.createDataFrame(data1).toDF("id", "age", "education")
    df1.createOrReplaceTempView("table1")

    val data2 = (1 to 100).map(i => (i + 50, i % 20 + 22, if (i % 4 == 0) "本科" else "博士"))
    val data2WithDuplicates = data2 ++ data2.map(t => (t._1, t._2, t._3)) // 增加重复数据
    val df2: DataFrame = spark.createDataFrame(data2WithDuplicates).toDF("id", "age", "education")
    df2.createOrReplaceTempView("table2")

    println("===== OR条件JOIN的执行计划 =====")
    val orJoin = spark.sql("""
      SELECT *
      FROM table1
      JOIN table2 ON table1.id = table2.id OR table1.age = table2.age OR table1.education = table2.education
    """)
    orJoin.explain(true) // 打印详细执行计划

    println("===== OR条件JOIN1的执行计划 =====")
    val orJoin1 = spark.sql("""
      SELECT *
      FROM table1
      JOIN table2 ON table1.id = table2.id OR table1.age = table2.age
    """)
    orJoin1.explain(true) // 打印详细执行计划

    println("\n===== 等值JOIN的执行计划（对比） =====")
    val equiJoin = spark.sql("""
      SELECT *
      FROM table1
      JOIN table2 ON table1.id = table2.id
    """)
    equiJoin.explain(true)
  }
}