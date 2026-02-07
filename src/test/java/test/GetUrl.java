package test;

import Pages.LoginPage;
import Pages.VidoesPage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Base;
import utilities.BrowserFactory;

import java.io.*;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

public class GetUrl extends Base {

    WebDriver driver;
    LoginPage loginPage;
    VidoesPage videosPage;
    @BeforeMethod
    public void  setup() {
        driver = BrowserFactory.startappURL(config.getURL());
        loginPage   = new LoginPage(driver);
        videosPage = new VidoesPage(driver);
    }

    @Test
    public void playvideo() throws InterruptedException, IOException {
        loginPage.typeInSearchField("Imagine dragons");
        loginPage.clickEnter();
        Thread.sleep(2000);
        videosPage.clickFirstVideo();

    }

    @Test
    public void playvideo2() throws InterruptedException, IOException {
        loginPage.typeInSearchField("Archangel");
        loginPage.clickEnter();
        Thread.sleep(2000);
        videosPage.clickFirstVideo();

        driver.get("https://www.google.com/");
        Set<String> str = driver.getWindowHandles();
        System.out.println("test");
        for(String s : str){
            driver.switchTo().window(s);
            if(driver.getTitle().equals("Google")){
                break;
            }
        }

        Thread.sleep(2000);
        for(String s : str){
            driver.switchTo().window(s);
            if(driver.getTitle().equals("YouTube")){
                break;
            }
        }
        String title = driver.getTitle();
        Assert.assertEquals(title, "abc");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('this is a test alert accept it')");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


}
