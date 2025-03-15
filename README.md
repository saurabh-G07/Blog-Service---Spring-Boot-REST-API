# Blog Service - Spring Boot REST API

## Project Overview
This project is a **Spring Boot** backend service that allows users to create, retrieve, and manage blogs.
It includes:
- **CRUD APIs** for blog management using **Spring Data JPA**.
- **AI-powered text summarization** via OpenAI API.
- **Authentication** using JWT (Optional).
- **Docker & AWS deployment support**.

## Features
✅ **Create, Read, Update, Delete (CRUD) APIs**  
✅ **AI-powered text summarization** using OpenAI API  
✅ **PostgreSQL as the database**  
✅ **Spring Boot & Spring Data JPA for seamless backend development**  
✅ **Docker support for easy deployment**  
✅ **JWT authentication for secure access (Optional)**  
✅ **AWS-ready deployment setup**  

---

## 1. Prerequisites
Before running the project, ensure you have the following installed:

- **Java 17+** ([Download Java](https://adoptopenjdk.net/))
- **Maven** ([Download Maven](https://maven.apache.org/download.cgi))
- **PostgreSQL** ([Download PostgreSQL](https://www.postgresql.org/download/))
- **Docker** *(for containerized deployment)* ([Download Docker](https://www.docker.com/get-started))

---

## 2. Setting Up the Database

### Option 1: Run PostgreSQL Locally
1. Open **pgAdmin** or the **PostgreSQL shell** and run:
```sql
CREATE DATABASE blogdb;
CREATE USER admin WITH PASSWORD 'password';
ALTER ROLE admin SET client_encoding TO 'utf8';
ALTER ROLE admin SET default_transaction_isolation TO 'read committed';
ALTER ROLE admin SET timezone TO 'UTC';
GRANT ALL PRIVILEGES ON DATABASE blogdb TO admin;
```

2. Update **`src/main/resources/application.properties`**:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/blogdb
spring.datasource.username=admin
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

### Option 2: Use Docker for PostgreSQL
Run:
```sh
docker-compose up -d
```

---

## 3. Running the Project

### Option 1: Run with Maven (Recommended)
```sh
mvn clean install
mvn spring-boot:run
```

### Option 2: Run with Java
1. **Build the project**
```sh
mvn clean package
```
2. **Run the JAR file**
```sh
java -jar target/blog-service.jar
```

### Option 3: Run with Docker *(for Deployment)*
1. **Build the Docker image**
```sh
docker build -t blog-service .
```
2. **Run the container**
```sh
docker run -p 8080:8080 blog-service
```

---

## 4. API Endpoints

### Create a Blog
```sh
curl -X POST "http://localhost:8080/api/blogs" -H "Content-Type: application/json" -d '{
  "title": "My First Blog",
  "content": "This is a sample blog content.",
  "author": "John Doe"
}'
```

### Get All Blogs
```sh
curl -X GET "http://localhost:8080/api/blogs"
```

### Get a Blog by ID
```sh
curl -X GET "http://localhost:8080/api/blogs/1"
```

### Update a Blog
```sh
curl -X PUT "http://localhost:8080/api/blogs/1" -H "Content-Type: application/json" -d '{
  "title": "Updated Title",
  "content": "Updated content."
}'
```

### Delete a Blog
```sh
curl -X DELETE "http://localhost:8080/api/blogs/1"
```

---

## 5. Deploying on AWS

### Option 1: Deploy on EC2
1. Upload the JAR file to **EC2**
2. Run:
```sh
java -jar blog-service.jar
```

### Option 2: Deploy on AWS Lambda
1. Package the application  
```sh
mvn clean package
```
2. Upload to **AWS Lambda** with an API Gateway.

### Option 3: Deploy with AWS Elastic Beanstalk
```sh
eb init -p java-17 blog-service
eb create blog-service-env
```

---

## 6. Summary

✅ **Run Locally** → `mvn spring-boot:run`  
✅ **Run with Docker** → `docker-compose up --build`  
✅ **Deploy to AWS** → `EC2 / Lambda / Beanstalk`  

---

## Author
This project was developed for educational purposes.  
Feel free to contribute or modify as needed! 🚀
