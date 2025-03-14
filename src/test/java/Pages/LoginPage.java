package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Base;
import utilities.BrowserFactory;

import java.time.Duration;

import static org.openqa.selenium.support.How.XPATH;

public class LoginPage extends Base {
     WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@name='search_query']")
    public WebElement searchField;

    public LoginPage(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
        Assert.assertEquals(driver.getTitle(), "YouTube");
    }

    public void typeInSearchField(String text) {
        searchField.sendKeys(text);
    }
    public void clickEnter(){
        searchField.sendKeys(Keys.ENTER);
    }
}
