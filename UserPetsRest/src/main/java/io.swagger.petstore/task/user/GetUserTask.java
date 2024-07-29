package io.swagger.petstore.task.user;

import io.restassured.http.ContentType;
import io.swagger.petstore.utils.CallData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUserTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/user/"+ CallData.extractTo().get(0).get("username")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                )
        );
    }
    public static GetUserTask getUser(){
        return instrumented(GetUserTask.class);
    }

}
