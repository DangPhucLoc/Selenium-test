package DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        try {
            WebElement addToCartButton = driver.findElement(By.xpath("//td[5]/div/button/span/span"));
            addToCartButton.click();

            selectCountry("United States");
            selectRegion("California");
            String zip = "90005";
            WebElement firstNameElement = driver.findElement(By.id("postcode"));
            firstNameElement.sendKeys(zip);

            WebElement estimate = driver.findElement(By.xpath("//*[@id=\"shipping-zip-form\"]/div/button"));
            estimate.click();

            WebElement shipFee = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label/span"));
            Assert.assertEquals(shipFee.getText().trim(),"$5.00");

            WebElement stick = driver.findElement(By.xpath("//*[@id=\"s_method_flatrate_flatrate\"]"));
            stick.click();

            WebElement updateTotal = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/div/button"));
            updateTotal.click();

            WebElement checkPrice = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
            Assert.assertEquals(checkPrice.getText().trim(),"$505.00");

            WebElement processCheckout = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button"));
            processCheckout.click();


        }catch (Exception e) {
            Assert.fail("error at "+e);
        }
    }


    public void selectCountry(String countryName) {
        WebElement countryDropdown = driver.findElement(By.id("country"));

        Select select = new Select(countryDropdown);

        select.selectByVisibleText(countryName);
    }

    public void selectRegion(String region) {
        WebElement RegionDropdown = driver.findElement(By.id("region_id"));
        Select select = new Select(RegionDropdown);
        select.selectByVisibleText(region);

    }


}
