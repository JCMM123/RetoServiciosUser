package io.swagger.petstore.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "io/swagger/petstore/stepDefinition",
        tags = "@CRUDUser",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
