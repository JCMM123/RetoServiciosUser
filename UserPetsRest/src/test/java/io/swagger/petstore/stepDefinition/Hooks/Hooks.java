package io.swagger.petstore.stepDefinition.Hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static io.swagger.petstore.constants.Constants.URL_BASE;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hooks {

    @Before
    public void setUp(){
        setTheStage(new OnlineCast());
        theActorCalled("Juan")
                .whoCan(CallAnApi.at(URL_BASE));
    }
}
