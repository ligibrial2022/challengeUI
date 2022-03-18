package modelsPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import models.MoviesToCompare;
import net.thucydides.core.annotations.Step;

public class SuccessfullySearch extends BasePage{
    MoviesToCompare nameMovies = new MoviesToCompare();



    @FindBy(xpath = "//a[contains(@class,'search')]")
    private WebElement searcher;

    @FindBy(xpath = "//input[@placeholder='Search for a movie, tv show, person...']")
    private  WebElement bar;

    @FindBy(xpath = "//*[@class='result' and @data-media-type='movie']//following::h2")
    private WebElement titlelistmovies;




    public SuccessfullySearch(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step
    public void enterSearcher() {
        waitVisibility(searcher);
        searcher.click();
    }
    @Step
    public  void serchMovie(String nameMovie){
        waitVisibility(bar);
        bar.click();
        writeText(bar,nameMovie);
        bar.sendKeys(Keys.ENTER);
    }
    @Step
    public String findFirstElement(){

        List<WebElement>listMovies = driver.findElements(By.xpath("//*[@class='result' and @data-media-type='movie']//following::h2"));
        return listMovies.get(0).getText();

    }
    @Step
    public void compareFirstMovie(String nameMoviestocompare){
        findFirstElement();
        nameMovies.setNameMoviestoCompare(nameMoviestocompare);
        Assert.assertEquals(findFirstElement(),nameMovies.getNameMoviestoCompare());

    }

}
