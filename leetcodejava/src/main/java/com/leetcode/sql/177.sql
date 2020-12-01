create function getNthHighestSalary(N INT) returns int
begin
declare m int;
set m = n - 1;
    return (
        select distinct Salary from Employee order by Salary desc limit M, 1
    );
end