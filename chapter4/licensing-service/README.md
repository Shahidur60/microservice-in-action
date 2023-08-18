1. First we need to create the jar for that in the terminal run: mvn clean package
2. To run the docker file:  mvn package dockerfile:build
3. Now for the running the docker compose file:  docker-compose up --build
4. After the application successfully running in the specified port
   1. we need to go to the postman and execute the api calls one by one