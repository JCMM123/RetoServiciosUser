Feature: Deleted User By Id
  @CRUDUser
  @DeletedUser
  Scenario: Deleted User Successfully
    When the user sends a request by ID to delete a User
    Then the server responds with a status code of 200
