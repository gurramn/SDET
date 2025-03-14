package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VidoesPage {

    WebDriver driver;
    @FindBy(how= How.XPATH, using="//div[@id='title-wrapper']")
    WebElement firstVideo;

    public VidoesPage(WebDriver ldriver) {
        this.driver= ldriver;
        PageFactory.initElements(driver, this);
    }

    public void clickFirstVideo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(firstVideo));
        firstVideo.click();
    }
}
