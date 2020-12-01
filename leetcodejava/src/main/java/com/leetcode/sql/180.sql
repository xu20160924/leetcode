SELECT distinct l1.Num as ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num

select distinct Salary
from (select Salary,
             case
                 when @record := Salary then @count := @count + 1
                 when @record <> @record := Salary then @count := 1 end as n
      from Employee,
           (select @count := 0, @record := (select Salary from Employee limit 0, 1)) r
     ) a
where a.n >= 3

