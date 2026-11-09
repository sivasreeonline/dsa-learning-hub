# Write your MySQL query statement below
SELECT
    dept.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
JOIN Department dept
    ON e.departmentId = dept.id
JOIN
(
    SELECT
        departmentId,
        MAX(salary) AS max_salary
    FROM Employee
    GROUP BY departmentId
) d
    ON e.departmentId = d.departmentId
    AND e.salary = d.max_salary;