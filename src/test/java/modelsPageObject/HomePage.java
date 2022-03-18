package modelsPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.annotations.Step;

public class HomePage extends BasePage {

    private String baseURL = "https://www.themoviedb.org/";

    @FindBy(xpath = "(//a[@href='/login'][contains(.,'Login')])[1]")
    private WebElement btnLogin;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step
    public HomePage goToThePage() {
        driver.get(baseURL);
        return this;
    }
    @Step
    public void clickLogin() {

        waitVisibility(btnLogin);
        click(btnLogin);

    }




}
