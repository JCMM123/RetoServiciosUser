package io.swagger.petstore.stepDefinition;

import io.cucumber.java.en.When;

import static io.swagger.petstore.task.user.DeleteUserTask.deleteUser;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserStepdefinition {

    @When("the user sends a request by ID to delete a User")
    public void theUserSendsARequestByIDToDeleteAUser() {
        theActorInTheSpotlight().attemptsTo(
                deleteUser()
        );
    }

}
