package modelsPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import models.Movies;

public class VerifyGenreMoviePage extends BasePage {

    @FindBy(xpath = "//a[@class='no_click k-link k-menu-link'][contains(.,'Movies')]")
    private WebElement btnMovies;

    @FindBy(xpath = "//a[@href='/movie/top-rated'][contains(.,'Top Rated')]")
    private WebElement btnTopRated;

    @FindBy(xpath = "//div[@class='name'][contains(.,'Filters')]")
    private WebElement menFilters;

    @FindBy(xpath = "//a[@class='no_click'][contains(.,'Action')]")
    private WebElement btnAction;

    @FindBy(xpath = "(//a[contains(.,'Search')])[1]")
    private WebElement btnSearch;

    @FindBy(xpath = "//img[@src='/t/p/w220_and_h330_face/md5wZRRj8biHrGtyitgBZo7674t.jpg']")
    private WebElement firstMovie;


    Movies genreMovie = new Movies();

    public VerifyGenreMoviePage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    ;

    public Boolean findAnieMovie(String genreMovies) {

        Movies genre = new Movies();
        genre.setGenre(genreMovies);
        boolean genreAction = true;
        List<WebElement> listMovies = driver.findElements(By.xpath("//*[@class='genres']/child::a"));
        for (int i = 0; i < listMovies.size(); i++)

            if ((listMovies.get(i).getText()).contains(genre.getGenre()) )
                genreAction=true;
        return genreAction;
    }

    public void filterFortopRatedMovies() {
        waitVisibility(btnMovies);
        waitVisibility(btnTopRated);
        click(btnTopRated);
    }


    public void filterForAction() {
        waitVisibility(menFilters);
        click(menFilters);
        waitVisibility(btnAction);
        click(btnAction);
        waitVisibility(menFilters);
        click(menFilters);
        waitVisibility(btnSearch);
        click(btnSearch);


    }

    public  void selectFirstMovie(){
        waitVisibility(firstMovie);
        click(firstMovie);
    }

    public  void compareGenre(String genreMovie){
        findAnieMovie(genreMovie);
        Assert.assertEquals(findAnieMovie(genreMovie),true);

    }
}
