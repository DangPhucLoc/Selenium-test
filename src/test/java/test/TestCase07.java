package test;

import DOM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriver.driverFactory;

public class TestCase07 {
    /*
    * Verify that you will be able to save previously placed order as a pdf file

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on My Account link

3. Login in application using previously created credential

4. Click on 'My Orders'

5. Click on 'View Order'

6. Click on 'Print Order' link
* */
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
            WebElement myOrder = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a"));
            myOrder.click();

            //step 5
            WebElement viewOrder = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[1]"));
            viewOrder.click();

            //step 6
            WebElement printOrder = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]"));
            printOrder.click();



        }catch (Exception e ) {
            Assert.fail("error at "+e);
        }
    }
}
