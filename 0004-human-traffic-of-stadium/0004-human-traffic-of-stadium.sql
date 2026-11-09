# Write your MySQL query statement below
WITH ConsecutiveGroups AS
(
    SELECT
        id,
        visit_date,
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS group_id
    FROM Stadium
    WHERE people >= 100
),
ValidGroups AS
(
    SELECT
        group_id
    FROM ConsecutiveGroups
    GROUP BY group_id
    HAVING COUNT(*) >= 3
)
SELECT
    c.id,
    c.visit_date,
    c.people
FROM ConsecutiveGroups c
JOIN ValidGroups v
    ON c.group_id = v.group_id
ORDER BY c.visit_date;