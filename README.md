# Simple Student Registration Crud Operations
This project has following capabilities :
* registering new student
* updating existing student
* removing student
* listing all student 

## Technologies
* HSQLDB
* Hibernate
* Maven
* Java
* Spring Framework
* JSF
* Primefaces

## Prerequisites
* HSQLDB
* Java8
* To create related tables and insert data them create-data.sql and insert-data.sql script files. 

## Downloading HSQLDB
* HSQLDB - [download HSQLDB](https://sourceforge.net/projects/hsqldb/files/latest/download) and unzip it to a folder. 
Launch a command prompt and navigate to the HSQLDB data folder
within the data folder, we'll run the following command:
```
java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file.testdb --dbname0.testdb
```
The above command will start the HSQLDB server and create our database whose source files will be stored in the data folder
Once the database has been set up, we need to create a connection to it.

To do this on Windows, let's go to the database bin folder and run the runManagerSwing.bat file. This will open HSQLDB Database Manager's initial screen, where we can enter the connection credentials:

* **Type**: HSQL Database Engine
* **URL**: jdbc:hsqldb:hsql://localhost/testdb
* **User**: "SA" (System Administrator)
* **Password**: leave the field empty


