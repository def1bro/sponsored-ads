# Getting Started

### LOADING DB
Re-name the file .import.sql to import.sql
Spring Boot should load the .import.sql under the resources file.
If you are running a different DB than H2 or the queries didn't get executed you can 
copy and paste the SQL queries and execute them in the DB. 


### Creating Campaign API - use .http files on intellij or through Postman 
### Example post request:
POST http://localhost:8080/api/v1/campaign
Content-Type: application/json

{
"name": "campaign1",
"bid": 531.5,
"startDate": "2022-12-29",
"productIds": [1, 3, 5]

}

