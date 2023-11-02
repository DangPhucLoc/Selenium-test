package test;

import DOM.CartPage;
import DOM.CheckoutPage;
import DOM.LoginPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriver.driverFactory;

import java.time.Duration;


public class TestCase06 {
    /* Verify user is able to purchase product using registered email id (USE CHROME BROWSER)

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on MY WISHLIST link

5. In next page, Click ADD TO CART link

6. Enter general shipping country, state/province and zip for the shipping cost estimate

7. Click Estimate

8. Verify Shipping cost generated

9. Select Shipping Cost, Update Total

10. Verify shipping cost is added to total

11. Click "Proceed to Checkout"

12a. Enter Billing Information, and click Continue

12b. Enter Shipping Information, and click Continue

13. In Shipping Method, Click Continue

14. In Payment Information select 'Check/Money Order' radio button. Click Continue

15. Click 'PLACE ORDER' button

16. Verify Oder is generated. Note the order number

Note:

- Build CartPage/CheckOutPage/LoginPage as POM
*/

        @Test
        public void test() {
            WebDriver driver = driverFactory.getChromeDriver();
            try{
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
                WebElement myWishlist = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a"));
                myWishlist.click();

                //step 5

                CartPage cartPage = new CartPage(driver);
                cartPage.clickAddToCart();

                CheckoutPage checkoutPage = new CheckoutPage(driver);
                checkoutPage.checkout();




            }catch (Exception e) {
                Assert.fail("error at "+e);
            }
        }
}
