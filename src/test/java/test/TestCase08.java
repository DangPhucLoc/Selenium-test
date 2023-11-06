package test;

import DOM.CheckoutPage;
import DOM.LoginPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriver.driverFactory;

import java.time.Duration;

public class TestCase08 {
    /*
    * *  Verify you are able to change or reorder previously added product

 *  Test Data = QTY = 10

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on 'REORDER' link , change QTY & click Update

5. Verify Grand Total is changed

6. Complete Billing & Shipping Information

7. Verify order is generated and note the order number

Expected outcomes:

1) Grand Total is Changed

2) Order number is generated*/
    @Test
    public void test() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //step 1
            driver.get("http://live.techpanda.org/");
            //step 2
            WebElement accountLink = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]"));
            accountLink.click();

            // step 3
            WebElement Login = driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a"));
            Login.click();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.fillLoginPage("joasd1355@example.com","your_password");
            loginPage.clickLoginButton();

            //step 4
            WebElement recorded = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[2]"));
            recorded.click();

            //step 5
            WebElement granTotalNotUpdate = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr/td[2]/span"));
            String totalMotUpdate = granTotalNotUpdate.getText();
            System.out.println(totalMotUpdate);

            WebElement QTY = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input"));
            QTY.clear();
            QTY.sendKeys("10");

            WebElement update = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span"));
            update.click();

            WebElement grandTotal = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
            String total = grandTotal.getText();
            System.out.println(total);
            Assert.assertNotEquals(grandTotal,granTotalNotUpdate);

            WebElement proceed = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button"));
            proceed.click();


            //step 6
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.checkout();

            //step 7
            WebElement orderNum = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a"));
            if(!orderNum.isDisplayed()) {
                Assert.fail("order number does not generate");
            }else{
                System.out.println(orderNum.getText());
            }

        }catch (Exception e ) {
            Assert.fail("error at "+e);
        }

    }
}

