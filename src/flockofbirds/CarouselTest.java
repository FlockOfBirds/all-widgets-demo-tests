package flockofbirds;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(priority = 5)
public class CarouselTest {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\drivers\\Firefox driver\\geckodriver.exe");
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.WIN10);

        driver = new FirefoxDriver(capability);

        driver.get("https://allwidgetdemo.mxapps.io/index.html");
        driver.findElement(By.cssSelector("div.mx-name-navigationTree2 > div > ul > li:nth-child(6)")).click();

    }

    @Test(priority = 1)
    public void RenderImages() {
        WebElement imageElement = driver.findElement(By.cssSelector("div.widget-carousel-item.active > img"));
        String src = imageElement.getAttribute("src");

        AssertJUnit.assertEquals(src, "https://allwidgetdemo.mxapps.io/img/Carousel$image1.jpg?636209466213251470");

    }

    @Test(priority = 2)
    public void NavigateRight() {
        driver.findElement(By.cssSelector("div.widget-carousel-control.right")).click();
        WebElement imageElement = driver.findElement(By.cssSelector("div.widget-carousel-item.active > img"));
        String src = imageElement.getAttribute("src");

        AssertJUnit.assertEquals(src, "https://allwidgetdemo.mxapps.io/img/Carousel$image3.jpg?636209466213251470");

    }

    @Test(priority = 3)
    public void NavigateLeft() {
        WebElement leftNavigationElement = driver.findElement(By.cssSelector("div.widget-carousel-control.left"));
        leftNavigationElement.click();
        leftNavigationElement.click();
        WebElement imageElement = driver.findElement(By.cssSelector("div.widget-carousel-item.active > img"));
        String src = imageElement.getAttribute("src");

        AssertJUnit.assertEquals(src, "https://allwidgetdemo.mxapps.io/img/Carousel$image2.jpg?636209466213251470");

    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

}
