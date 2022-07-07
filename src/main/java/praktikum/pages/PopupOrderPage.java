package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupOrderPage extends DriverLogic {

    private final By popupTitleLocator = By.xpath(".//div[text()='Хотите оформить заказ?']");
    private final By successButtonLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By cancelButtonLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Нет']");

    private final By successStateTitleLocator = By.xpath(".//div[text()='Заказ оформлен']");
    private final By checkOrderStateButton = By.xpath(".//button[text()='Посмотреть статус']");

    public PopupOrderPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPopupOrder() {
        waitForVisible(popupTitleLocator);
        waitForVisible(successButtonLocator);
        waitForVisible(cancelButtonLocator);
    }

    public void pressSuccessButton() {
        clickElement(successButtonLocator);
    }

    public void checkOrderStatus() {
        waitForVisible(successStateTitleLocator);
        waitForVisible(checkOrderStateButton);
    }

}
