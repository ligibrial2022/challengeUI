package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelsPageObject.HomePage;
import modelsPageObject.LoginPage;
import utils.PageGenerator;

public class Login {

    protected WebDriver driver = Hook.getDriver();


    @Given("the user wants to login")
    public void theUserWantsToLogin() throws Exception {
        PageGenerator.getInstance(HomePage.class,driver).goToThePage();
        PageGenerator.getInstance(HomePage.class,driver).clickLogin();

    }
    @When("the user enters the credentials")
    public void theUserEntersTheCredentials() throws Exception {


        PageGenerator.getInstance(LoginPage.class,driver).ingresarCredenciales();

    }
    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() throws Exception {
        PageGenerator.getInstance(LoginPage.class,driver).message();



    }



}
