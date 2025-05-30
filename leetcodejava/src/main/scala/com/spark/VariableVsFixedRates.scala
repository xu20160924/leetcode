package com.spark

import org.apache.spark.sql.{SparkSession, functions => F}
import org.apache.spark.sql.types._
import scala.util.{Try, Success, Failure}

/**
 * Analyzes and compares variable vs fixed interest rates across different states and quarters.
 * This application processes loan data to identify trends and differences in interest rates.
 */
object VariableVsFixedRates {
  // Configuration parameters
  private val INPUT_FILE = "src/main/scala/com/spark/loan_data.csv"
  private val TARGET_YEAR = 2018
  private val DECIMAL_PLACES = 2



  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Variable vs Fixed Rates Analysis")
      .master("local[*]")
      .getOrCreate()

    try { 
      // Read and validate input data
      val df = readAndValidateData(spark)
      
      // Process the data
      val resultDF = processData(df)
      
      // Format and display results
      displayResults(resultDF)
      
    } catch {
      case e: Exception =>
        println(s"Error processing data: ${e.getMessage}")
        e.printStackTrace()
    } finally {
      spark.stop()
    }
  }

  /**
   * Reads and validates the input data
   */
  private def readAndValidateData(spark: SparkSession) = {
    Try {
      val df = spark.read
        .option("header", "true")
        .option("inferSchema", "true")
        .csv(INPUT_FILE)

      // Validate required columns exist
      val requiredColumns: Seq[String] = Seq("state", "loan_year", "loan_quarter", "rate_type", "interest_rate")
      val missingColumns = requiredColumns.filter(col => !df.columns.contains(col))
      
      if (missingColumns.nonEmpty) {
        throw new IllegalArgumentException(s"Missing required columns: ${missingColumns.mkString(", ")}")
      }

      // Validate data types and ranges
      df.filter(
        F.col("interest_rate").isNull ||
        F.col("interest_rate") < 0 ||
        F.col("loan_year") < 2000 ||
        F.col("loan_year") > 2100
      ).count() match {
        case 0 => df
        case count => throw new IllegalArgumentException(s"Found $count rows with invalid data")
      }
    } match {
      case Success(df) => df
      case Failure(e) => throw new RuntimeException(s"Failed to read input data: ${e.getMessage}")
    }
  }

  /**
   * Processes the data to count fixed and variable loans
   */
  private def processData(df: org.apache.spark.sql.DataFrame) = {
    // Filter for target year
    val filteredDF = df.filter(F.col("loan_year") === TARGET_YEAR)

    // Add indicator columns for counting
    val withIndicators = filteredDF
      .withColumn("Fixed", F.when(F.col("rate_type") === "Fixed", 1).otherwise(0))
      .withColumn("Variable", F.when(F.col("rate_type") === "Variable", 1).otherwise(0))

    // Group by state and loan_quarter, sum the indicators
    withIndicators.groupBy(
      F.col("state"),
      F.col("loan_quarter")
    ).agg(
      F.sum("Fixed").alias("Fixed"),
      F.sum("Variable").alias("Variable")
    ).orderBy(F.col("state"), F.col("loan_quarter"))
  }

  /**
   * Displays the results in a formatted manner
   */
  private def displayResults(df: org.apache.spark.sql.DataFrame): Unit = {
    println("\n=== Variable vs Fixed Rates Analysis ===")
    println(s"Year: $TARGET_YEAR")
    println("\nCounts by State and Quarter:")
    df.show(false)
  }
}