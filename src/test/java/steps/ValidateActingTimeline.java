package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modelsPageObject.HomePage;
import modelsPageObject.ValidateActingTimelinePage;
import modelsPageObject.VerifyGenreMoviePage;
import utils.PageGenerator;

public class ValidateActingTimeline {


    protected WebDriver driver = Hook.getDriver();

    @Given("the user selects a movie with actors")
    public void theUserSelectsAMovieWithActors() throws Exception {
        PageGenerator.getInstance(HomePage.class,driver).goToThePage();
        PageGenerator.getInstance(VerifyGenreMoviePage.class,driver).filterFortopRatedMovies();
        PageGenerator.getInstance(ValidateActingTimelinePage.class,driver).selectMovie();
    }
    @Given("the user selects an actor from the top billed cast")
    public void theUserSelectsAnActorFromTheTopBilledCast() throws Exception {
        PageGenerator.getInstance(ValidateActingTimelinePage.class,driver).selectActor();

    }
    @When("the user checks the actor’s acting timeline")
    public void theUserChecksTheActorSActingTimeline()throws Exception {
        PageGenerator.getInstance(ValidateActingTimelinePage.class,driver).devoverNombreMovie();
    }
    @Then("the title of the movie should be in the timeline")
    public void theTitleOfTheMovieShouldBeInTheTimeline()throws Exception {
        PageGenerator.getInstance(ValidateActingTimelinePage.class,driver).compararMovieDelActor();
    }

}
