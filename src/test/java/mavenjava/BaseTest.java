package mavenjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void newDriver(){
        ChromeOptions options = new ChromeOptions();
        String chromeOpts = System.getenv("CHROME_OPTIONS");
        if (chromeOpts != null) {
            options.addArguments(chromeOpts.split(";"));
        }
        driver = new ChromeDriver(options); // Передаем options в ChromeDriver
        driver.get("https://askomdch.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
