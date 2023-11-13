package test;

import DOM.TestingLogic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriver.driverFactory;

public class TestCase09 {
    /*  Verify Discount Coupon works correctly

Test Case Description:

1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated

TestData:  Coupon Code: GURU50

Expected result:

1) Price is discounted by 5%

*/

        @Test
        public void test() {
            WebDriver driver = driverFactory.getChromeDriver();

            try {
                //step 1
                driver.get("http://live.techpanda.org/");
                TestingLogic testingLogic = new TestingLogic(driver);
                //step 2
                WebElement mobileLink = testingLogic.click("//*[@id=\"nav\"]/ol/li[1]/a");

                WebElement addToCartBtn = testingLogic.click("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button");

                WebElement granTotalB4Coupon = testingLogic.click("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span");
                String totalMotUpdate = granTotalB4Coupon.getText();
                System.out.println(totalMotUpdate);

                //step 3
                testingLogic.sendKeyByXpath("//*[@id=\"coupon_code\"]","GURU50");
                WebElement apply = testingLogic.click("//*[@id=\"discount-coupon-form\"]/div/div/div/div/button/span/span");

                //step 4
                WebElement discount = testingLogic.click("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span");
                if(!discount.isDisplayed()) {
                    Assert.fail("discount is not generated");
                }

                WebElement grandTotal = testingLogic.click("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span");
                String total = grandTotal.getText();
                System.out.println(total);

                Assert.assertNotEquals(totalMotUpdate,total);
            }
            catch (Exception e){
                Assert.fail("error at "+e);
            }
        }
}
