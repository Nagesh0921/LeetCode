/* Write your T-SQL query statement below */
select session_id
from Playback
where session_id not in 
            (select distinct pb.session_id
            from Playback pb
            Left Join Ads ad
            on pb.customer_id = ad.customer_id
            where ad.timestamp >= pb.start_time and ad.timestamp <= pb.end_time)

--Runtime: 4659 ms, faster than 7.18% of MS SQL Server online submissions for Ad-Free Sessions.
--Memory Usage: 0B, less than 100.00% of MS SQL Server online submissions for Ad-Free Sessions.

select p.session_id as session_id
from playback p left outer join ads a 
on p.customer_id = a.customer_id
and a.timestamp between p.start_time and p.end_time
group by p.session_id
having count(a.ad_id) = 0; 

--Runtime: 3040 ms, faster than 38.57% of MS SQL Server online submissions for Ad-Free Sessions.
--Memory Usage: 0B, less than 100.00% of MS SQL Server online submissions for Ad-Free Sessions.
