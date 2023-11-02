package DOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillLoginPage(String email, String password) {
        WebElement emailElement = driver.findElement(By.id("email"));
        emailElement.sendKeys(email);

        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton(){
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        System.out.println(registerButton.getText());
        registerButton.click();
    }
}
