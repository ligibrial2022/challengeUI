package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelsPageObject.HomePage;
import modelsPageObject.SortbyAscendingOrderPage;
import modelsPageObject.VerifyGenreMoviePage;
import utils.PageGenerator;

public class SortbyAscendigOrder {
    protected WebDriver driver = Hook.getDriver();

    @Given("the user wants to sort top-rated movies by their date")
    public void theUserWantsToSortTopRatedMoviesByTheirDate() throws Exception {
        PageGenerator.getInstance(HomePage.class,driver).goToThePage();
        PageGenerator.getInstance(VerifyGenreMoviePage.class,driver).filterFortopRatedMovies();
    }
    @When("the user sorts by date on ascending order")
    public void theUserSortsByDateOnAscendingOrder() throws Exception{
        PageGenerator.getInstance(SortbyAscendingOrderPage.class,driver).selectAscending();
       PageGenerator.getInstance(SortbyAscendingOrderPage.class,driver).selectFilterAction();
       PageGenerator.getInstance(SortbyAscendingOrderPage.class,driver).selectSearch();

    }


    @Then("the user should see the dates of the first  movies in ascending order")
    public void theUserShouldSeeTheDatesOfTheFirstMoviesInAscendingOrder() throws Exception {

        PageGenerator.getInstance(SortbyAscendingOrderPage.class,driver).isOrder();
    }



}
