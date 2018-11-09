## :name_badge: TELEKOM MICROSERVICE with ADMINISTRATION tool

### Prerequsites :heavy_exclamation_mark:

 1. `JDK 1.8` at least - for running the app
 2. `Maven 3+`            - for bulding a package
 3. `Docker Service` *(optional)* -  for dockerized start up
 4. `PostgreSQL latest version > 9.4` *(optional)* - without dockerized start up

### Get Started with Docker :star:
 **1. Clone the repository**
 
`git clone https://github.com/ElinaValieva/admin-tool-with-docker.git`

 **2. In the location of `docker-compose.yml` execute the following**
 
`docker-compose up`

 **3.  Application will start `localhost:8090/home` and eureka server `localhost:8761`**

### Get start without Docker :electric_plug:
**1. Database initialization**

* Download database `postgreSQL` from [postgresql](https://www.postgresql.org/download/)
* Open `psql` command line and login as superuser *(as a default `postgres`)*

* Create database `admindb` and user with this scripts

```
postgres=# CREATE DATABASE admindb;
postgres=# CREATE USER admindb WITH PASSWORD 'admindb';
postgres=# GRANT ALL PRIVILEGES ON DATABASE admindb TO admindb;
```

**2. Clone repository**

`git clone https://github.com/ElinaValieva/admin-tool-with-docker.git`

**3. Compile all projects with command**

`mvn clean install`

**4. Run**

As first step run`eureka` and then other services. Application will start `localhost:8090/home` and eureka server `localhost:8761`

### Initial user creadentials

* user with `admin` privileges

```
login: admin
password: pass
```
* user with `user` privileges

```
login: user
password: pass
```
