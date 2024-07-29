package io.swagger.petstore.stepDefinition;

import io.cucumber.java.en.When;

import static io.swagger.petstore.task.user.PutUserTask.putUser;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutUserStepdefinition {

    @When("the user consumes the service to update a user in the system")
    public void theUserConsumesTheServiceToUpdateAUserInTheSystem() {
        theActorInTheSpotlight().attemptsTo(
                putUser()
        );
    }

}
