package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.config.TestConfig;

import java.time.Duration;

public abstract class DriverLogic {

    private final WebDriver driver;
    private final long timeout = TestConfig.TIMEOUT;

    protected DriverLogic(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisible(By locator, long timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForVisible(By locator) {
        waitForVisible(locator, timeout);
    }

    protected void scrollElementTo(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    protected void clickElement(By locator, long timeout) {
        waitForVisible(locator, timeout);
        driver.findElement(locator).click();
    }

    protected void clickElement(By locator) {
        clickElement(locator, timeout);
    }

    protected void setTextToInput(By locator, String text, long timeout) {
        waitForVisible(locator, timeout);
        driver.findElement(locator).sendKeys(text);
    }

    protected void setTextToInput(By locator, String text) {
        setTextToInput(locator, text, timeout);
    }

    protected By inputLocatorByPlaceHolder(String placeHolder) {
        return By.xpath(String.format(".//input[@placeholder = '%s']", placeHolder));
    }

}
