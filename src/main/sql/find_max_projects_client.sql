SELECT NAME, count(*) AS PROJECT_COUNT
from worker
	join project_worker 
      on project_worker.WORKER_ID = worker.ID
   join project 
      on project_worker.PROJECT_ID=project.ID
group by NAME
order by count(*) DESC
FETCH FIRST 1 ROWS WITH TIES;