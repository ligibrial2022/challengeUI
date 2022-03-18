package modelsPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import net.thucydides.core.annotations.Step;

public class SortbyAscendingOrderPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"media_v4\"]/div/div/div[2]/div[1]/div[1]/div[1]")
    private WebElement btnSort;

    @FindBy(css = "#sort_by_listbox > li[data-offset-index='5']")
    private WebElement btnAscending;



    @FindBy(xpath = "(//span[contains(@unselectable,'on')])[5]")
    private WebElement listDesple;


    @FindBy(xpath = "//div[@class='name'][contains(.,'Filters')]")
    private WebElement btnFilter;

    @FindBy(xpath = "//a[@class='no_click'][contains(.,'Action')]")
    private WebElement btnAction;



    @FindBy(css = "#sort_by_listbox > li[data-offset-index='5']")
    private WebElement dateAscending;

    @FindBy(xpath = "(//a[@class='no_click load_more'][contains(.,'Search')])[1]")
    private WebElement btnSearch;





    @FindBy(xpath = "(//div[contains(@class,'card style_1')]//child::p)[0]")
    private WebElement firstMovie;

    @FindBy(xpath = "(//div[contains(@class,'card style_1')]//child::p)[1]")
    private WebElement secondMovie;

    @FindBy(xpath = "(//div[contains(@class,'card style_1')]//child::p)[2]")
    private WebElement ThirdMovie;

    @FindBy(xpath = "(//div[contains(@class,'card style_1')]//child::p)[3]")
    private WebElement FourMovie;

    public SortbyAscendingOrderPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    };

    @Step

    public void selectAscending(){
        waitVisibility(btnSort);
        click(btnSort);
        waitVisibility(btnAscending);
        click(btnAscending);
        waitVisibility(btnSort);
        click(btnSort);
    }


    @Step
    public void selectFilterAction() {


        waitVisibility(btnFilter);
        btnFilter.click();
        waitVisibility(btnAction);
        click(btnAction);
        waitVisibility(btnFilter);
        click(btnFilter);


    }
    @Step
    public void selectSearch() {

        waitVisibility(btnSearch);
        btnSearch.click();


    }
    @Step
    public List<String> dates() {

        List<String> dates = null;
        dates.add(firstMovie.getText());

        dates.add(secondMovie.getText());
        dates.add(ThirdMovie.getText());
        dates.add(FourMovie.getText());
        return dates;
    }

    @Step
    public Boolean validateAscendingOrder() {
        dates();
        Boolean ascend = true;
        for (int i = 0; i < 4; i++) {
            if (Integer.parseInt(dates().get(i + 1).split(", ")[1]) <
                    (Integer.parseInt(dates().get(i).split(", ")[1]))){
                    ascend=false;
            }else 
            ascend=true;
        }
        return ascend;
    }
    @Step
    public  void isOrder(){
        System.out.println("++++++++++++++++++"+validateAscendingOrder());
        Assert.assertEquals(validateAscendingOrder(), true);
    }

}