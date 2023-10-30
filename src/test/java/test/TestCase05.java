package test;

import DOM.RegistrationPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriver.driverFactory;

import java.io.File;

public class TestCase05 {
    /* Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.

Note:

- build Register page as POM.

- code for switching to new window:

// switching to new window
for (String handle : driver.getWindowHandles()) {
    driver.switchTo().window(handle);
}
*/
    @Test
    public void test(){
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            //step 1
            driver.get("http://live.techpanda.org/");

            // step 2
            WebElement account = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]"));
            System.out.println(account.getText());
            account.click();

            //step 3
            WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[1]/a"));
            System.out.println(myAccount.getText());
            myAccount.click();

            WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[1]/div[2]/a"));
            System.out.println(createAccount.getText());
            createAccount.click();


            // Step 4: Fill New User information excluding the registered Email ID
            RegistrationPage registrationPage = new RegistrationPage(driver);
            registrationPage.fillRegistrationForm("loc","phuc", "dang", "joasd1355@example.com", "your_password");
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("screenshot_Input.png"));


            // step 5
            WebElement register = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span"));
            System.out.println(register.getText());
            register.click();

            WebElement checkRegister = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span"));
            String checkExpected = "Thank you for registering with Main Website Store.";
            Assert.assertEquals(checkExpected.trim(),checkRegister.getText().trim());
            File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile2, new File("screenshot_Input_Success.png"));

            //step 6
            WebElement TVmenu = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"));
            System.out.println(TVmenu.getText());
            TVmenu.click();

            // step 7
            WebElement addWishList = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
            System.out.println(addWishList.getText());
            addWishList.click();

            //step 8
            WebElement shareWish = driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[1]"));
            System.out.println(shareWish.getText());
            shareWish.click();
            //step 9

            WebElement email = driver.findElement(By.id("email_address"));
            email.sendKeys("johndoe@example.com");

            WebElement message =driver.findElement(By.id("message"));
            message.sendKeys("hello world");

            WebElement share = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button"));
            System.out.println(share.getText());
            share.click();

            //step 10

            WebElement checkWishlist = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span"));
            String expected = "Your Wishlist has been shared.";
            Assert.assertEquals(checkWishlist.getText().trim(),expected.trim());



        }catch (Exception e) {
            Assert.fail("error at "+e);
        }
    }
}
