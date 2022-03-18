package modelsPageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import net.thucydides.core.annotations.Step;

public class ValidateActingTimelinePage extends BasePage{


    @FindBy(xpath = "//h2[contains(.,'Bring the Soul: The Movie')]")
    private WebElement firstMovieScreen;


    @FindBy(xpath = "(//*[@class='people scroller']/child::li)[1]")
    private WebElement firstActor;

    @FindBy(xpath = "//div[contains(@class,'credits_list')]")
    private WebElement nameMovie;

    @FindBy(xpath = "(//div[contains(@class,'page_wrapper')]//child::div)//child::h2")
    private WebElement listofNames;

    @FindBy(xpath = "((//div[@class='card style_1'])//child::h2)[1]")
    private WebElement first;

    public ValidateActingTimelinePage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    };


    @Step
    public void selectMovie(){
        waitVisibility(firstMovieScreen);
        click(firstMovieScreen);
    }




    public String devoverNombreMovie() {
      return   first.getText();
    }

    @Step
    public void selectActor(){

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
        waitVisibility(firstActor);
        click(firstActor);
    }

    @Step
    public void compararMovieDelActor(){
        devoverNombreMovie();
        Assert.assertEquals(devoverNombreMovie(),"Bring the Soul: The Movie");

    }
}
