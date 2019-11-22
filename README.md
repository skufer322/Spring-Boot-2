# Spring Boot 2

* docker run --rm -d -p 27017-27019:27017-27019 --name mongodb mongo:latest 
* winpty docker exec -it mongodb ./bin/bash
* mongod --version (mongod startet mongodb server)
* mongo -> verbindet zur MongoDB (mongo = enter mongo shell)
* db.help() -> zeigt Hilfe an
* weitere Befehle:
    * show dbs
    * show collections
    * db.<collection-name\>.find().pretty()
    
 * MongoRepository vs. MongoTemplate: https://stackoverflow.com/questions/17008947/whats-the-difference-between-spring-datas-mongotemplate-and-mongorepository
