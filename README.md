# ** Social activity tracker **

1. Short description

    This application is saving progress of any activity the user chooses. It connects user with other people with similar interests 
    and motivate user by proposing fun challenges. User can choose from existing activity and challenge options or create their own.

2. Technologies used in application

    - JDBC and H2 database
    - Maven
    - Unit tests with JUnit
    - Properties files

## Code description

1. Three layers of code

    - Controller layer, with models
    - Data access layer (DAO) that connects with H2 database
    - Service layer that operates on models

2. CRUD methods

3. Connection Manager and properties

    - I am using ConnectionManager class to manage access to H2 database in any place in the code
    - It is using property files to store connection credentials
    - Production and test databases use different property files

4. Tests

   - Tests are generated on par with writing code
   - Current coverage: ~60%

5. UniqueIdGenerator

      - Random from java util is being used to generate pseudo-random number 
      that is assigned as an id to save activity in database

6. Delegation, injection and dependency 

      - code is more versatile and it's not repeating itself

7. Loggers are used in every method

8. LocalDateTime and ChronoUnit are used to save time and to calculate activity duration

## To do list

1. Cover more code with tests to achieve at least ~80% coverage
2. Add business logic to service layer


      




