/* Write your T-SQL query statement below */
select FirstName, LastName, City, State
from Person ps
left join Address ad
on ps.PersonId = ad.PersonId;

--Runtime: 819 ms, faster than 90.98% of MS SQL Server online submissions for Combine Two Tables.
--Memory Usage: 0B, less than 100.00% of MS SQL Server online submissions for Combine Two Tables.
