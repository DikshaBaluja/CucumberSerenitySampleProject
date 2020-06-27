package moduleTesting.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import moduleTesting.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps steps;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
       steps.HomePage();
    }
    
    @When("the user looks up the definition of the word '(.*)'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        steps.enterKeyword(word);
        steps.looksUpDefinition();
    }

}
