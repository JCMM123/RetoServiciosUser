Feature: Upodate user By Id
  @CRUDUser
  @UpdateUser
  Scenario: User update successfully
    When the user consumes the service to update a user in the system
    Then the server responds with a status code of 200
