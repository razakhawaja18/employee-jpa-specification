Employee - Spring Boot - JPA Specification Application
====================================


#### Requirements
1. Java 8
2. Tomcat 8

> apache-maven-3.6.1


#### Intellij IDE Tips
1. Install Lombok Plugin
2. Enable Lombok Annotation Processing
    - File-> Settings
    - Expand `Build, Execution, Deployment`
    - Expand `Compiler`
    - In `Annotation Processors` check **Enable annotation processing**
    - _You may need to re-open the project to get the settings to take effect_.

#### Run it!
```
mvn clean install
```
```
mvn spring-boot:run
```

## Accessing Application
Based on the properties specified to start application, employee can be accessed at:
```
http://localhost:8183/api/v1/employee
```
## Swagger - Rest Api Documentation
Rest services can be tested directly through Swagger UI.
[http://localhost:8181/swagger-ui.html](http://localhost:8181/swagger-ui.html)


## Following are payload

##POST company

POST - http://localhost:8181/api/v1/company

     {
           "companyName": "NISUM",
           "companyPhoneNum": "0056971489699",
           "companyAddress": "San Fransisco",
           "companyCountry": "USA"
        }
       

##Get branch

GET - http://localhost:8181/api/v1/branch

    {
          "branchName": "Nisum Chile",
              "branchPhoneNum": "0056971489699",
              "branchAddress": "Santiago",
              "branchCountry": "Chile",
              "companyDto": {
                  "companyId": "1"
              }
        }
        

##POST employee

POST - http://localhost:8183/api/v1/employee

    {
           "employeeName": "Ghulam",
             "employeeLastName": "Raza",
             "employeeAddress": "Santiago Chile",
             "employeePhoneNum": "008613051429005",
             "employeeHairColor": "BLACK",
             "branchDto": {
                 "branchId": "1"
             }
     }
        

##Get employee with specification
Get -  http://localhost:8183/api/v1/employee 

    {
           "employeeDto": {},
           "branchDto": {},
           "companyDto": {
               "companyName": "Nisum"
           },
           "firstResult": 1,
           "maxResults": 2,
           "sortColumn": "employeeName"
    }
        
##Delete employee By employee Id
Delete - http://localhost:8183/api/v1/employee/1


