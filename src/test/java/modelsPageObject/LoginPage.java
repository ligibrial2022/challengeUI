package modelsPageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import models.User;
import net.thucydides.core.annotations.Step;

import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
    User newuser= new User();

    @FindBy(xpath = "//h2[contains(.,'Stats')]")
    private WebElement status;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernamee;

    @FindBy(id = "password")
    private WebElement passworde;

    @FindBy(id = "login_button")
    private WebElement btnLoginLogin;


    public LoginPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step
    public void ingresarCredenciales() {

        User usuario = new User();
        usuario.ReadPropertiesFile();

        waitVisibility(usernamee);
       // writeText(usernamee, username);
        writeText(usernamee, usuario.getUsername());
        waitVisibility(passworde);
        //writeText(passworde,password);
        writeText(passworde,usuario.getPassword());
        waitVisibility(btnLoginLogin);
        click(btnLoginLogin);

    }
    @Step
    public String message() {

        return status.getText();

    }
    @Step
    public void validateMessage() {
        Assert.assertEquals("Stats", message());

    }
}
