package flockofbirds;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(priority = 2)
public class ProgressBarTest {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\drivers\\Firefox driver\\geckodriver.exe");
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WIN10);

        driver = new FirefoxDriver(capability);

        driver.get("https://allwidgetdemo.mxapps.io/index.html");
        driver.findElement(By.cssSelector("div.mx-name-navigationTree2 > div > ul > li:nth-child(3)")).click();
    }

    @Test(priority = 1)
    public void RenderBar() {
        WebElement progressBarElement = driver.findElement(By.cssSelector(".mx-name-progressBar2"));
        WebElement bar = progressBarElement.findElement(By.cssSelector("div.progress-bar"));
        bar.getAttribute("style").equals("width: 45%;");

    }

    @Test(priority = 3)
    public void ChangeProgressBarValue() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.cssSelector("div.mx-dataview-content > table > tbody > tr:nth-child(1) > td:nth-child(2)"))));

        element.findElement(By.tagName("input")).sendKeys("60");
        // WebElement progressBarElement =
        // driver.findElement(By.cssSelector(".mx-name-progressBar2"));
        // WebElement progressBarChildElement =
        // progressBarElement.findElement(By.cssSelector("div.progress-bar"));
        // String value = progressBarChildElement.getText();
        //
        // AssertJUnit.assertEquals(value, "60%");

    }

    @Test(priority = 2)
    public void ChangeProgressBarStyle() {
        Select dropdown = new Select(driver.findElement(By.cssSelector(".mx-name-dropDown1")));
        dropdown.deselectByVisibleText("success");

        WebElement progressBarElement = driver.findElement(By.cssSelector(".mx-name-progressBar2"));
        WebElement progressBarChildElement = progressBarElement.findElement(By.cssSelector("div.progress-bar"));
        String style = progressBarChildElement.getAttribute("style");

        AssertJUnit.assertEquals(style, "width: 60%;");

    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

}
