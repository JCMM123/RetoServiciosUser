Feature: Read user By Id
  @CRUDUser
  @ReadUser
  Scenario: View user Successfully
    When the user sends a request by ID
    Then the server responds with a status code of 200
