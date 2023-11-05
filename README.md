# deal-service

https://github.com/jeetu86044/deal-service/tree/main/demo/src/main/java/com/demo/dealService
Deal service directory start from here.
It is a spring boot project with tomcat server, rest api and Database as Mysql. Database configuration is in application.properties
It has an entity directory that contains all the tables related to deal service.
Deal resource which is an entry point for rest api
Repository is the layer which integrates with Java code to database.
Impl has DealServiceImpl 

```
Create deal API:
curl --location 'http://localhost:8080/deal' \
--header 'Content-Type: application/json' \
--data '{
    "productId": "28738",
    "startDate": "2023-11-05T10:47:23.926457",
    "endDate": "2023-11-05T10:47:23.926457",
    "price": 232.00
}'
```

```
Create deal Response:
{
    "id": 152,
    "productId": "28738",
    "startTime": "2023-11-05T10:47:23.926457",
    "endTime": "2023-11-05T10:47:23.926457",
    "price": 232.0,
    "maxQty": 0,
    "soldQty": 0,
    "singleUserMaxQty": 1,
    "dealStarted": true,
    "dealId": "6b486038-44d4-4039-bca3-783f603d6fec"
}
```

```
update deal:
curl --location --request PUT 'http://localhost:8080/deal/5415893c-7017-46ad-9e83-c645ffc929f0' \
--header 'Content-Type: application/json' \
--data '{
    "endDate": "2023-11-06T10:47:23.926457",
    "maxQty": 100
}'
```

```
START OR END a deal
curl --location --request PUT 'http://localhost:8080/deal/5415893c-7017-46ad-9e83-c645ffc929f0' \
--header 'Content-Type: application/json' \
--data '{
    "endDate": "2023-11-06T10:47:23.926457",
    "maxQty": 100
}'
```

```
claim a deal
http://localhost:8080/deal/<dealId>/claim/<userId>
curl --location --request POST 'http://localhost:8080/deal/6b486038-44d4-4039-bca3-783f603d6fec/claim/1' \
--data ''
```

