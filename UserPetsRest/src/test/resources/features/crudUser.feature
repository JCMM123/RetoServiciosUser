@CRUDUser
Feature: CRUD User

  @PostUser
  Scenario: Create User successfully
    When the user consumes the service to create a new user in the system
    Then the server responds with a status code of 200

  @ReadUser
  Scenario: View user Successfully
    When the user sends a request by ID
    Then the server responds with a status code of 200

  @UpdateUser
  Scenario: User update successfully
    When the user consumes the service to update a user in the system
    Then the server responds with a status code of 200

  @DeletedUser
  Scenario: Deleted User Successfully
    When the user sends a request by ID to delete a User
    Then the server responds with a status code of 200

