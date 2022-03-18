package modelsPageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import models.User;
import net.thucydides.core.annotations.Step;

public class LoginFailed extends BasePage{

    User newuser= new User();

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernamee;

    @FindBy(id = "password")
    private WebElement passworde;

    @FindBy(id = "login_button")
    private WebElement btnLoginLogin;

    @FindBy(xpath = "//h2[@class='background_color red'][contains(.,'There was a problem')]")
    private WebElement errorMessage;


    public LoginFailed(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Step
    public void ingresarIncorrectas(String username, String password) {

        waitVisibility(usernamee);
        writeText(usernamee, username);
        waitVisibility(passworde);
        writeText(passworde,password);
        logger.info("username"+username);
        click(btnLoginLogin);



    }

    @Step
    public String message(){
        return errorMessage.getText();
    }


    public void validateErrorMessage(String message){
        newuser.setMessage(message);
        Assert.assertEquals(message(), newuser.getMessage());

    }

}
