package flockofbirds;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(priority = 6)
public class TimeSeriesTest {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\drivers\\Firefox driver\\geckodriver.exe");
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WIN10);

        driver = new FirefoxDriver(capability);

        driver.get("https://allwidgetdemo.mxapps.io/index.html");
        driver.findElement(By.cssSelector("div.mx-name-navigationTree2 > div > ul > li:nth-child(7)")).click();
    }

    @Test(priority = 1)
    public void RenderSlider() {
        WebElement timeSeriesElement = driver.findElement(By.cssSelector(".mx-name-timeSeries1"));
        WebElement chart = timeSeriesElement.findElement(By.cssSelector("div.nv-chart"));
        chart.findElement(By.tagName("svg"));

    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

}
