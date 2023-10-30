package test;
import webDriver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile

4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available.

5. Verify the error message

6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty
 */
public class TestCase03 {
    @Test
    public void test() {
        WebDriver webDriver = driverFactory.getChromeDriver();
        try {
            //step 1
            webDriver.get("http://live.techpanda.org/");


            //step 2
            WebElement mobileMenu = webDriver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
            System.out.println(mobileMenu.getText());
            mobileMenu.click();


            //step 3

            WebElement addToCart = webDriver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button/span/span"));
            System.out.println(addToCart.getText());
            addToCart.click();

            //step 4

            WebElement QTY = webDriver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input"));
            QTY.clear();
            QTY.sendKeys("1000");

            WebElement updateButton =webDriver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button"));
            System.out.println(updateButton.getText());
            updateButton.click();

            // step 5

            WebElement showError = webDriver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/p"));
            String expectError = "The requested quantity for \"Sony Xperia\" is not available";
            Assert.assertEquals(showError.getText().trim(), expectError.trim());

            // step 6

            WebElement emptyCart = webDriver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]/span/span"));
            System.out.println(emptyCart.getText());
            emptyCart.click();

            WebElement stringForEmptyCart = webDriver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1"));
            String expected = "SHOPPING CART IS EMPTY";
            Assert.assertEquals(stringForEmptyCart.getText().trim(), expected.trim());

            // step 7

            WebElement cart = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/div/a/span[2]"));
            System.out.println(cart.getText());
            cart.click();
            WebElement checkNonfi = webDriver.findElement(By.xpath("//*[@id=\"header-cart\"]/div[3]/p[2]"));
            if(!checkNonfi.isDisplayed()) {
                Assert.fail();
            }

        }catch (Exception e) {
            Assert.fail("some thing wrong at "+e);
        }
    }
}
