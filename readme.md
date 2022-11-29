# Getting Started

### LOADING DB
At startup data is loaded into the DB using the LoadDatabase.java file


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

