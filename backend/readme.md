# swe306-backend

Backend is a Maven project, tech stack used in the backend:

SpringBoot Framework + MyBatis

## Setup

1. Import `Mysql` Database with mock data

   ```bash
   database/db.sql
   ```

2. Modify the configuration file in the following path

   ```bash
   backend/src/main/resources/application.properties
   ```

   Change the {Username} and {Password} to your MySQL Username and Password

   ```
   #MySQL username
   spring.datasource.username = {Username}
   
   #MySQL password
   spring.datasource.password = {Password}
   ```

3. Run the Maven Project to start the backend at `:8080`