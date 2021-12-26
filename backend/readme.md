# swe301-backend

### Set Up

1. Execute the file in the following path in MySQL:

   ```bash
   database/db.sql
   ```

   

2. Modify the configuration file in the following path:

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



3. Run