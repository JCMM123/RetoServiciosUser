package io.swagger.petstore.stepDefinition;

import io.cucumber.java.en.When;

import static io.swagger.petstore.task.user.GetUserTask.getUser;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetUserStepdefinition {

    @When("the user sends a request by ID")
    public void theUserSendsARequestByID() {
        theActorInTheSpotlight().attemptsTo(
                getUser()
        );
    }

}
