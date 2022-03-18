package modelsPageObject;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

   public final Logger logger = Logger.getLogger(BasePage.class.getName());


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void click(WebElement element) {

        element.click();
        Serenity.takeScreenshot();
    }

    public void writeText(WebElement element, String word) {
        element.sendKeys(word);
        Serenity.takeScreenshot();

    }

    public void waitVisibility(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    public void implicitWatt(WebElement element){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String exists(WebElement element) {
        waitVisibility(element);
        if (element.getText().isEmpty()) {
            return element.getText();
        } else {
            return "null";
        }
    }




}
