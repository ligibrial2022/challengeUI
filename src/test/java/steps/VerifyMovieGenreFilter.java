package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelsPageObject.HomePage;
import modelsPageObject.VerifyGenreMoviePage;
import utils.PageGenerator;

public class VerifyMovieGenreFilter {
    protected WebDriver driver = Hook.getDriver();

    @Given("the user wants to see the top-rated movies")
    public void theUserWantsToSeeTheTopRatedMovies() throws Exception {
        PageGenerator.getInstance(HomePage.class,driver).goToThePage();
    }
    @Given("the user wants to filter for ‘action’ movies")
    public void theUserWantsToFilterForActionMovies() throws Exception{
        PageGenerator.getInstance(VerifyGenreMoviePage.class,driver).filterFortopRatedMovies();
    }
    @When("the user applies the ‘action’ filter")
    public void theUserAppliesTheActionFilter() throws Exception{
        PageGenerator.getInstance(VerifyGenreMoviePage.class,driver).filterForAction();
    }
    @When("the user selects any movie {string}")
    public void theUserSelectsAnyMovie(String nameMovie)throws Exception {
        PageGenerator.getInstance(VerifyGenreMoviePage.class,driver).selectFirstMovie();
    }
    @Then("the user should see the genre of the movie includes {string}")
    public void theUserShouldSeeTheGenreOfTheMovieIncludes(String genreMovie) throws Exception{

        PageGenerator.getInstance(VerifyGenreMoviePage.class,driver).compareGenre(genreMovie);
    }

}
