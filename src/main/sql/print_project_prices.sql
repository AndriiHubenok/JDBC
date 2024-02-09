SELECT project.ID,
       SUM(worker.salary * ((EXTRACT(YEAR FROM project.FINISH_DATE) - EXTRACT(YEAR FROM project.START_DATE)) * 12 +
                           (EXTRACT(MONTH FROM project.FINISH_DATE) - EXTRACT(MONTH FROM project.START_DATE)))) AS PRICE
FROM project
JOIN project_worker ON project.id = project_worker.project_id
JOIN worker ON project_worker.worker_id = worker.id
GROUP BY project.id
ORDER BY PRICE DESC;
