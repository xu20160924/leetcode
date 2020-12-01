select Department.name as 'Department',
    Employee.name as 'Employee',
    Salary
from Employee join
    Department on Employee.DepartmentId = Department.id
where
    (Employee.DepartmentId, Salary) in
    (select DepartmentId, MAX(Salary)
    from Employee
    group by DepartmentId)

SELECT D.Name Department,A.Name Employee,A.Salary
FROM
	Employee A,
	Department D
WHERE A.DepartmentId = D.Id
  AND NOT EXISTS
  (SELECT 1 FROM Employee B WHERE B.Salary > A.Salary AND A.DepartmentId = B.DepartmentId)

