/* Write your T-SQL query statement below */
select email
from Person
group by email
having count(1) > 1;

--Runtime: 777 ms, faster than 96.58% of MS SQL Server online submissions for Duplicate Emails.
--Memory Usage: 0B, less than 100.00% of MS SQL Server online submissions for Duplicate Emails.
