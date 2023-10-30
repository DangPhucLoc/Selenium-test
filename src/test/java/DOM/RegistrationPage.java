package DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm(String firstName, String middleName,String lastName, String email, String password) {
        WebElement firstNameElement = driver.findElement(By.id("firstname"));
        firstNameElement.sendKeys(firstName);

        WebElement middleNameElement = driver.findElement(By.id("middlename"));
        middleNameElement.sendKeys(middleName);

        WebElement lastNameElement = driver.findElement(By.id("lastname"));
        lastNameElement.sendKeys(lastName);

        WebElement emailElement = driver.findElement(By.id("email_address"));
        emailElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys(password);

        WebElement confirmPasswordElement = driver.findElement(By.id("confirmation"));
        confirmPasswordElement.sendKeys(password);
    }

    public void clickRegister() {
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[3]/button/span/span"));
        registerButton.click();
    }
}
