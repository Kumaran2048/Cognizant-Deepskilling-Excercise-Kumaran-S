# Spring Data JPA Quick Example

This folder contains a written answer for the requested Spring Data JPA quick example based on the hands-on steps described in the original exercise.

## Steps

1. Create a Spring Boot project using Spring Initializr
   - Group: `com.cognizant`
   - Artifact: `orm-learn`
   - Description: `Demo project for Spring Data JPA and Hibernate`
   - Dependencies: `Spring Boot DevTools`, `Spring Data JPA`, `MySQL Driver`

2. Configure `application.properties`
   ```properties
   logging.level.org.springframework=info
   logging.level.com.cognizant=debug
   logging.level.org.hibernate.SQL=trace
   logging.level.org.hibernate.type.descriptor.sql=trace
   logging.pattern.console=%d{dd-MM-yy} %d{HH:mm:ss.SSS} %-20.20thread %5p %-25.25logger{25} %25M %4L %m%n

   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
   spring.datasource.username=root
   spring.datasource.password=root

   spring.jpa.hibernate.ddl-auto=validate
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
   ```

3. Create database schema and table
   ```sql
   create schema ormlearn;
   create table country(co_code varchar(2) primary key, co_name varchar(50));
   insert into country values ('IN', 'India');
   insert into country values ('US', 'United States of America');
   ```

4. Create `Country` entity class
   ```java
   package com.cognizant.ormlearn.model;

   import javax.persistence.Column;
   import javax.persistence.Entity;
   import javax.persistence.Id;
   import javax.persistence.Table;

   @Entity
   @Table(name = "country")
   public class Country {

       @Id
       @Column(name = "co_code")
       private String code;

       @Column(name = "co_name")
       private String name;

       public Country() {
       }

       public String getCode() {
           return code;
       }

       public void setCode(String code) {
           this.code = code;
       }

       public String getName() {
           return name;
       }

       public void setName(String name) {
           this.name = name;
       }

       @Override
       public String toString() {
           return "Country{" +
                   "code='" + code + '\'' +
                   ", name='" + name + '\'' +
                   '}';
       }
   }
   ```

5. Create `CountryRepository`
   ```java
   package com.cognizant.ormlearn.repository;

   import org.springframework.data.jpa.repository.JpaRepository;
   import org.springframework.stereotype.Repository;
   import com.cognizant.ormlearn.model.Country;

   @Repository
   public interface CountryRepository extends JpaRepository<Country, String> {
   }
   ```

6. Create `CountryService`
   ```java
   package com.cognizant.ormlearn.service;

   import java.util.List;

   import javax.transaction.Transactional;

   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;

   import com.cognizant.ormlearn.model.Country;
   import com.cognizant.ormlearn.repository.CountryRepository;

   @Service
   public class CountryService {

       @Autowired
       private CountryRepository countryRepository;

       @Transactional
       public List<Country> getAllCountries() {
           return countryRepository.findAll();
       }
   }
   ```

7. Test from `OrmLearnApplication`
   ```java
   package com.cognizant.ormlearn;

   import java.util.List;

   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.context.ApplicationContext;

   import com.cognizant.ormlearn.model.Country;
   import com.cognizant.ormlearn.service.CountryService;

   @SpringBootApplication
   public class OrmLearnApplication {

       private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
       private static CountryService countryService;

       public static void main(String[] args) {
           ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
           LOGGER.info("Inside main");
           countryService = context.getBean(CountryService.class);
           testGetAllCountries();
       }

       private static void testGetAllCountries() {
           LOGGER.info("Start");
           List<Country> countries = countryService.getAllCountries();
           LOGGER.debug("countries={}", countries);
           LOGGER.info("End");
       }
   }
   ```

8. Run `OrmLearnApplication` and confirm the console logs show `Inside main`, `Start`, and `End`, and that the `countries` list is loaded from the `ormlearn` database.

9. Optionally use the provided SQL files:
   - `src/main/resources/schema.sql` to create the `ormlearn` schema and `country` table
   - `src/main/resources/data.sql` to insert sample country rows

10. Run the test class:
   - `src/test/java/com/cognizant/ormlearn/CountryServiceTest.java`
   - This test verifies that `CountryService.getAllCountries()` returns at least one row

## Notes

- `@SpringBootApplication` enables component scanning, auto-configuration, and configuration properties.
- `@Entity` maps the class to the `country` table.
- `@Table` defines the database table name.
- `@Id` marks the primary key field.
- `@Transactional` ensures database operations run within a transaction.
