/* Write your T-SQL query statement below */
select sp.name
from salesperson sp
where sp.sales_id not in 
    (select o.sales_id 
     from orders o
     left join company cp
     on o.com_id = cp.com_id
     where cp.name = 'RED');
     
--Runtime: 1036 ms, faster than 92.49% of MS SQL Server online submissions for Sales Person.
--Memory Usage: 0B, less than 100.00% of MS SQL Server online submissions for Sales Person.
