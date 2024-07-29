package io.swagger.petstore.stepDefinition;

import io.cucumber.java.en.Then;
import io.swagger.petstore.questions.ValidateResponseQuestion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class VerificationCRUD {

    @Then("the server responds with a status code of {int}")
    public void theServerRespondsWithAStatusCodeOf(Integer int1) {
        theActorInTheSpotlight().should(
                seeThat("The response code is ",
                        ValidateResponseQuestion.was(),
                        equalTo(int1)
                )
        );
    }

}
