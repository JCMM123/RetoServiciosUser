package io.swagger.petstore.stepDefinition;

import io.cucumber.java.en.When;

import static io.swagger.petstore.task.user.PostUserTask.madeAUser;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostUserStepdefinition {

    @When("the user consumes the service to create a new user in the system")
    public void theUserConsumesTheServiceToCreateANewUserInTheSystem() {
        theActorInTheSpotlight().attemptsTo(
            madeAUser()
        );
    }


}
