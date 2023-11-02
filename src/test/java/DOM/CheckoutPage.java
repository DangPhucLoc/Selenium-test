package DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout(){
        WebElement conti1 = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button"));
        conti1.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")));

        element.click();
        //step14
        WebElement payment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p_method_checkmo\"]")));
        payment.click();

        WebElement paymentCountinue = driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button"));
        paymentCountinue.click();
        //step 15
        WebElement oder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"review-buttons-container\"]/button/span/span")));
        oder.click();

        wait.until(ExpectedConditions.urlContains("http://live.techpanda.org/index.php/checkout/onepage/success/"));

        WebElement check = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1")));
        Assert.assertEquals(check.getText().trim(),"YOUR ORDER HAS BEEN RECEIVED.");



    }
}
