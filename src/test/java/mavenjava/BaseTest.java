package mavenjava;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void newDriver(){
        driver = new ChromeDriver();
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @BeforeClass
    public void setUp() {
        // Устанавливаем драйвер с помощью WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Получаем параметры Chrome из переменной окружения
        ChromeOptions options = new ChromeOptions();
        String chromeOpts = System.getenv("CHROME_OPTS");
        if (chromeOpts != null) {
            options.addArguments(chromeOpts.split(" "));
        }
        driver = new ChromeDriver(options);
    }
}
