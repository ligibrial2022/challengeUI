package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelsPageObject.HomePage;
import modelsPageObject.SuccessfullySearch;
import utils.PageGenerator;

public class SearchSuccesfully {


    protected WebDriver driver = Hook.getDriver();

    @Given("the user wants to search for a movie")
    public void theUserWantsToSearchForAMovie() throws Exception {
        PageGenerator.getInstance(HomePage.class,driver).goToThePage();
        PageGenerator.getInstance(SuccessfullySearch.class,driver).enterSearcher();


    }
    @When("the user enters the title {string}")
    public void theUserEntersTheTitleFightClub(String nameMovie) throws Exception {
        PageGenerator.getInstance(SuccessfullySearch.class,driver).serchMovie(nameMovie);

    }
    @Then("the user should see the movie as the first result {string}")
    public void theUserShouldSeeTheMovieAsTheFirstResult(String nameMoviestoCompare) throws Exception {

        PageGenerator.getInstance(SuccessfullySearch.class,driver).findFirstElement();

        PageGenerator.getInstance(SuccessfullySearch.class,driver).compareFirstMovie(nameMoviestoCompare);
    }

}
