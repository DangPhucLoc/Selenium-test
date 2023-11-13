package DOM;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class TestingLogic {
    private WebDriver driver;
    public TestingLogic(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement click(String xpath) {
        WebElement clickE = driver.findElement(By.xpath(xpath));
        clickE.click();
        return clickE;
    }

    public WebElement clickByCss(String cssSelector) {
        WebElement clickE = driver.findElement(By.cssSelector(cssSelector));
        clickE.click();
        return clickE;
    }

    public void sendKeyByXpath(String xpath, String sendData) {
        WebElement sendKeyE =driver.findElement(By.xpath(xpath));
        sendKeyE.clear();
        sendKeyE.sendKeys(sendData);
    }

    public void sendKeyByCssSelector(String cssSelector, String sendData) {
        WebElement sendKeyE =driver.findElement(By.cssSelector(cssSelector));
        sendKeyE.clear();
        sendKeyE.sendKeys(sendData);
    }
    public void takeScreenShot() {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshot_Search_result.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
