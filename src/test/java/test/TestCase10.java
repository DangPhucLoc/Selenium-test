package test;

import DOM.LoginPage;
import DOM.TestingLogic;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriver.driverFactory;

import java.io.File;
import java.time.Duration;


public class TestCase10 {
    @Test
    public void test() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            int seconds = 10;
            //step 1
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            //step 2
            LoginPage backendLoginPage = new LoginPage(driver);
            TestingLogic testingLogic = new TestingLogic(driver);


            backendLoginPage.fillLoginPage2("user01", "guru99com");
            WebElement login = testingLogic.click("//*[@id=\"loginForm\"]/div/div[5]/input");

            Duration duration = Duration.ofSeconds(seconds);
            WebDriverWait wait = new WebDriverWait(driver, duration); // Adjust the timeout as needed

            By popupLocator = By.xpath("//*[@id=\"message-popup-window\"]");
            wait.until(ExpectedConditions.presenceOfElementLocated(popupLocator));

            WebElement popUpCloseBtn = testingLogic.click("//*[@id=\"message-popup-window\"]/div[1]/a/span");
            //step 3

            WebElement salesBtn =testingLogic.click("//*[@id=\"nav\"]/li[1]/a/span");

            //step 4
            WebElement ordersBtn = testingLogic.click("//*[@id=\"nav\"]/li[1]/ul/li[1]/a");

            //step 5

            testingLogic.sendKeyByXpath("//*[@id=\"sales_order_grid_filter_real_order_id\"]","100021246");


             testingLogic.sendKeyByCssSelector("input[name='created_at[from]'].input-text.no-changes","Nov 8, 2023 00:00:09 AM");

            testingLogic.sendKeyByCssSelector("input[name='created_at[to]']","Nov 8, 2023 11:59:59 PM");


            WebElement searchBtn = testingLogic.clickByCss("button[title='Search']");

            Duration duration2 = Duration.ofSeconds(seconds);
            WebDriverWait wait2 = new WebDriverWait(driver, duration2); // Adjust the timeout as needed
            wait2.until(ExpectedConditions.elementToBeClickable(searchBtn));

            //step 6
            testingLogic.takeScreenShot();
        } catch (Exception e) {
            Assert.fail("error at " + e);
        }
    }
}
