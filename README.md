### TEST - TEMPLATE

Template example usage of Selenide/Selenoid with Allure and JUnit5

---

### Command to run tests:
* For selenoid:
    * site-dev:
    
    `mvn clean test -DBVersion=87.0 -DBSize=1600x900 -DRunStart=selenoid -DSiteStand=site-dev`
    
    * site-test:
    
    `mvn clean test -DBVersion=87.0 -DBSize=1600x900 -DRunStart=selenoid -DSiteStand=site-test`

* For selenide:
    * site-dev:
    
    `mvn clean test -DBSize=1600x900 -DRunStart=selenide -DFicoStand=site-dev`
    
    * site-test:
    
    `mvn clean test -DBSize=1600x900 -DRunStart=selenide -DFicoStand=site-test`

---

### Generate the Allure report locally:

`allure generate target/allure-results --clean`
