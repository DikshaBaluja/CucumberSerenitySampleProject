package moduleTesting.steps.serenity;




import moduleTesting.utilities.WebActions;
import net.thucydides.core.annotations.Step;

public class EndUserSteps {

    WebActions actions;
    
    @Step
    public void enterKeyword(String keyword) {
        actions._setValue(WebActions.elementLocators.get("SearchBox"),keyword);
    }
    
    @Step
    public void looksUpDefinition()
    {
    	actions._javascriptClick(WebActions.elementLocators.get("SearchButton"));
    	System.out.println();
    }
 

    @Step
    public void HomePage() {
        actions.open();
    }
    
    @Step
    public void checkLastRecord()
    {
    	
    	
    }
    
}