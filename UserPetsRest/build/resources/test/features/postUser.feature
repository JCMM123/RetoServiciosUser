Feature: Create User
  @CRUDUser
  @PostUser
  Scenario: Create User successfully
    When the user consumes the service to create a new user in the system
    Then the server responds with a status code of 200
