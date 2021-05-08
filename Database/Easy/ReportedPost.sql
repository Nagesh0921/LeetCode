-- SQL Server

/* Write your T-SQL query statement below */
select extra as report_reason, count(distinct post_id) as report_count
from Actions
where action_date='2019-07-04'
and extra is not null
and action='report'
group by action_date,extra;

--Runtime: 2690 ms, faster than 65.99% of MS SQL Server online submissions for Reported Posts.
--Memory Usage: 0B, less than 100.00% of MS SQL Server online submissions for Reported Posts.


-- MySql
# Write your MySQL query statement below
select extra as report_reason, count(distinct post_id) as report_count
from Actions
where action_date = CONVERT('2019-07-05', DATE) - 1
and extra is not null
and action = 'report'
group by action_date,extra;

--Runtime: 496 ms, faster than 72.82% of MySQL online submissions for Reported Posts.
--Memory Usage: 0B, less than 100.00% of MySQL online submissions for Reported Posts.

