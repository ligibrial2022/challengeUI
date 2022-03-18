package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelsPageObject.LoginFailed;
import utils.PageGenerator;

public class LoginFail  {

    protected WebDriver driver = Hook.getDriver();

    @When("the user enters invalid credentials {string}{string}")
    public void theUserEntersInvalidCredentials(String username, String password) throws Exception {
        PageGenerator.getInstance(LoginFailed.class,driver).ingresarIncorrectas(username,password);

    }
    @Then("the user should be able to see error {string}")
    public void theUserShouldBeAbleToSeeError(String message) throws Exception {
        PageGenerator.getInstance(LoginFailed.class,driver).validateErrorMessage(message);


    }

}
