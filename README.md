## :name_badge: TELEKOM MICROSERVICE with ADMINISTRATION tool

### Prerequsites :heavy_exclamation_mark:

 1. `JDK 1.8` at least - for running the app
 2. `Maven 3+`            - for bulding a package
 3. `Docker Service` *(optional)* -  for dockerized start up
 4. `PostgreSQL latest version > 9.4` *(optional)* - without dockerized start up

### Get Started with Docker :star:
 1. Clone the repo   :arrow_down:
`git clone http://gogs-sol-portfolio-dev01.telitcaas1.t-internal.com/elvaliev/telekom-microservices.git`
 2.  Compile the project :1234: `mvn clean package`- this step should also build up an image for you 
 3. In the location of `docker-compose.yml` execute the following: 
`docker-compose up`
 4.  :arrow_forward: Application will start  on `localhost:8090/home` by default 

### Database initialization without Docker :electric_plug:
1. Open psql as command line and login as superuser `postgres`
2. Create database `create database admindb`
3. Create user `CREATE USER admindb WITH PASSWORD 'admindb'`
4. Grant all privileges to user `grant all privileges on database admindb to admindb`
5. Run at first `eureka`
6. Run as next step other services
7. Go to check eureka server `localhost:8761`
8. Go to main app `localhost:8090/home`
