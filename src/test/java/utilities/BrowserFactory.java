package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

public class BrowserFactory {

    public static WebDriver startappURL(String url) {
        System.setProperty("webdriver.chrome.driver",  "./Drivers/chromedriver.exe");
        WebDriver webdriver = new ChromeDriver();
        WebDriverListener listener = new MyWebDriverListener();
        WebDriver driver = new EventFiringDecorator<>(listener).decorate(webdriver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        return driver;
    }

}
