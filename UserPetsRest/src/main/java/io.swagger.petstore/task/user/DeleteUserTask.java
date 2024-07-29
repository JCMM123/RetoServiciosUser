package io.swagger.petstore.task.user;

import io.restassured.http.ContentType;
import io.swagger.petstore.utils.CallData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/user/"+ CallData.extractTo().get(0).get("username")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                )
        );

    }
    public static DeleteUserTask deleteUser(){
        return instrumented(DeleteUserTask.class);
    }

}
