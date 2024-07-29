package io.swagger.petstore.task.user;

import io.restassured.http.ContentType;
import io.swagger.petstore.models.User;
import io.swagger.petstore.utils.CallData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Put.to("/user/"+ CallData.extractTo().get(0).get("username")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(User.builder()
                                        .id(Integer.parseInt(CallData.extractTo().get(0).get("id")))
                                        .username(CallData.extractTo().get(0).get("username"))
                                        .firstName(CallData.extractTo().get(1).get("firstName"))
                                        .lastName(CallData.extractTo().get(1).get("lastName"))
                                        .email(CallData.extractTo().get(1).get("email"))
                                        .password(CallData.extractTo().get(0).get("password"))
                                        .phone(CallData.extractTo().get(0).get("phone"))
                                        .userStatus( Integer.parseInt(CallData.extractTo().get(0).get("userStatus")))
                                        .build())
                )
        );
    }
    public static PutUserTask putUser(){
        return instrumented(PutUserTask.class);
    }

}
