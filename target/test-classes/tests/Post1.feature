Feature:  Post with read request body & response body from file

  Background:
    * url 'https://reqres.in/api'
    * header Accept = 'application/json'
    * def expectedOutput = read("response1.json")

  Scenario: Post with read request body & response body from file
    Given path  '/users'
    And def projectPath = karate.properties['user.dir']
    And print projectPath
    And def filePath = projectPath+'src/test/java/data/request1.json'
    And print filePath
    And json requestBody1 =  read('request1.json')
    And request requestBody1
    And print requestBody1
    When method POST
    Then status 201
    And match response == expectedOutput
    And match $ == expectedOutput
    And match $ contains { name:'murphy'}
    And print response