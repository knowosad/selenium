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

        driver.navigate().to("http://demoqa.com//");
        wait(driver, "menu-item-374");
        driver.findElement(By.id("menu-item-374")).click();
        wait(driver, "name_3_firstname");
        driver.findElement(By.id("name_3_firstname")).sendKeys("John");
        driver.findElement(By.id("name_3_lastname")).sendKeys("Doe");

        driver.findElement(By.xpath(".//*[@id='pie_register']/li[2]/div/div/input[1]")).click();
        driver.findElement(By.xpath(".//*[@id='pie_register']/li[3]/div/div/input[1]")).click();

        selectFromDropDownList(driver, "dropdown_7", "Poland");
        selectFromDropDownList(driver, "mm_date_8", "12");
        selectFromDropDownList(driver, "dd_date_8", "12");
        selectFromDropDownList(driver, "yy_date_8", "1990");

        WebElement uploadImg = driver.findElement(By.id("profile_pic_10"));
        uploadImg.sendKeys("C:\\Users\\freszczypior\\IdeaProjects\\selenium\\photo\\profilePicture.jpg");

        driver.findElement(By.id("phone_9")).sendKeys("004850050050");
        driver.findElement(By.id("username")).sendKeys("johndoe123");
        driver.findElement(By.id("email_1")).sendKeys("johndoe123@gmail.com");
        driver.findElement(By.id("password_2")).sendKeys("password");
        driver.findElement(By.id("confirm_password_password_2")).sendKeys("password");

        driver.findElement(By.xpath(".//*[@id='pie_register']/li[14]/div/input")).click();

        //driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        screenShot(driver);
    }

    private static void selectFromDropDownList(WebDriver driver, String dropDownListId, String selectFromList) {
        Select selectCountryList = new Select(driver.findElement(By.id(dropDownListId)));
        selectCountryList.selectByVisibleText(selectFromList);
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
