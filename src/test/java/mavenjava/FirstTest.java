package mavenjava;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void testStoreName() throws InterruptedException {

        String websiteName = driver.findElement(By.xpath("//h1/a[@href='https://askomdch.com/']")).getText();
        Assert.assertEquals(websiteName, "AskOmDch");

        Thread.sleep(3000);
    }

}
