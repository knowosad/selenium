package pl.com.knowosad.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Selenium {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\freszczypior\\IdeaProjects\\ForSelenium\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://www.pornhub.com/");
        wait(driver, "headerLoginLink");
        driver.findElement(By.id("headerLoginLink")).click();
        wait(driver, "username");
        driver.findElement(By.id("username")).sendKeys("wiadroViagry");
        driver.findElement(By.id("password")).sendKeys("wiadroViagryPassword");
        driver.findElement(By.id("submit")).click();
        wait(driver, "searchInput");
        driver.findElement(By.id("searchInput")).sendKeys("sexyCode");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        screenShot(driver);
    }

    public static void wait(WebDriver webDriver, String element_id){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(element_id)));
    }
    public static void screenShot(WebDriver driver) throws IOException {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("C:\\Users\\freszczypior\\IdeaProjects\\selenium\\screenshots\\shot.jpg"));
    }
}
