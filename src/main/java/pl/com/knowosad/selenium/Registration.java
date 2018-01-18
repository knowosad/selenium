package pl.com.knowosad.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Registration {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\freszczypior\\IdeaProjects\\ForSelenium\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        goTo(driver, "http://demoqa.com//");

        pushTheButton(driver, "menu-item-374");

        inputText(driver, "name_3_firstname", "John");
        inputText(driver, "name_3_lastname", "Doe");

        selectRadioOrCheckbox(driver, ".//*[@id='pie_register']/li[2]/div/div/input[1]");
        selectRadioOrCheckbox(driver, ".//*[@id='pie_register']/li[3]/div/div/input[1]");

        getDropDownElements(driver, "dropdown_7");

        selectFromDropDownList(driver, "dropdown_7", "Poland");
        selectFromDropDownList(driver, "mm_date_8", "12");
        selectFromDropDownList(driver, "dd_date_8", "12");
        selectFromDropDownList(driver, "yy_date_8", "1990");

        ifCheckboxIsSelectedUnselectIt(driver, ".//*[@id='pie_register']/li[3]/div/div/input[1]");

        selectRadioOrCheckbox(driver, ".//*[@id='pie_register']/li[3]/div/div/input[2]");

        uploadProfilePicture(driver, "profile_pic_10",
                "C:\\Users\\freszczypior\\IdeaProjects\\selenium\\photo\\profilePicture.jpg");

        inputText(driver, "phone_9", "004850050050");
        inputText(driver, "username", "usernameJohnDoe");
        inputText(driver, "email_1", "usernameJohn@gmail.com");
        inputText(driver, "password_2", "password123");
        inputText(driver, "confirm_password_password_2", "password123");

        driver.findElement(By.xpath(".//*[@id='pie_register']/li[14]/div/input")).submit();

        //driver.findElement(By.id("xxxxx")).sendKeys(Keys.ENTER);
        screenShot(driver, "C:\\Users\\freszczypior\\IdeaProjects\\selenium\\screenshots\\shot.jpg");
    }

    private static void goTo(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    private static void pushTheButton(WebDriver driver, String buttonId) {
        wait(driver, buttonId);
        driver.findElement(By.id(buttonId)).click();
    }

    private static void inputText(WebDriver driver, String elementId, String text) {
        wait(driver, elementId);
        driver.findElement(By.id(elementId)).sendKeys(text);
    }

    private static void selectRadioOrCheckbox(WebDriver driver, String elementXpath) {
        driver.findElement(By.xpath(elementXpath)).click();
    }

    private static void uploadProfilePicture(WebDriver driver, String uploadPictureId, String path) {
        WebElement uploadImg = driver.findElement(By.id(uploadPictureId));
        uploadImg.sendKeys(path);
    }

    private static void ifCheckboxIsSelectedUnselectIt(WebDriver driver, String xpath) {
        WebElement hobby = driver.findElement(By.xpath(xpath));
        if (hobby.isSelected())
            hobby.click();
    }

    private static void getDropDownElements(WebDriver driver, String dropDownId) {
        Select dropDown = new Select(driver.findElement(By.id(dropDownId)));
        List<WebElement> webElements = dropDown.getOptions();
    }

    private static void selectFromDropDownList(WebDriver driver, String dropDownId, String text) {
        Select selectCountryList = new Select(driver.findElement(By.id(dropDownId)));
        selectCountryList.selectByVisibleText(text);
    }

    private static void wait(WebDriver webDriver, String element_id){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(element_id)));
    }
    private static void screenShot(WebDriver driver, String path) throws IOException {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(path));
    }
}