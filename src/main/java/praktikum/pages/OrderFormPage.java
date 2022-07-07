package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderFormPage extends DriverLogic {

    private final By headerLocator = By.xpath(".//div[text()='Для кого самокат']");

    private final By inputNameLocator = inputLocatorByPlaceHolder("* Имя");
    private final By inputSecondNameLocator = inputLocatorByPlaceHolder("* Фамилия");
    private final By inputAddressLocator = inputLocatorByPlaceHolder("* Адрес: куда привезти заказ");
    private final By inputStationsLocator = inputLocatorByPlaceHolder("* Станция метро");
    private final By inputPhoneLocator = inputLocatorByPlaceHolder("* Телефон: на него позвонит курьер");

    private By itemMetroStationLocatorByName(String name) {
        return By.xpath(String.format(".//li[@class='select-search__row']//*[text()='%s']", name));
    }

    private final By continueButton = By.xpath(".//button[text()='Далее']");

    public OrderFormPage(WebDriver driver) {
        super(driver);
    }

    public void waitForOrderFormPage() {
        waitForVisible(headerLocator);
        waitForVisible(inputNameLocator);
        waitForVisible(inputSecondNameLocator);
        waitForVisible(inputAddressLocator);
        waitForVisible(inputStationsLocator);
        waitForVisible(inputPhoneLocator);
    }

    public void submitUserData(String firstName, String secondName, String address, String station, String phone) {
        setTextToInput(inputLocatorByPlaceHolder("* Имя"), firstName);
        setTextToInput(inputLocatorByPlaceHolder("* Фамилия"), secondName);
        setTextToInput(inputLocatorByPlaceHolder("* Адрес: куда привезти заказ"), address);

        By inputMetroLocator = inputLocatorByPlaceHolder("* Станция метро");
        By itemMetroStationLocator = itemMetroStationLocatorByName(station);

        clickElement(inputMetroLocator);
        setTextToInput(inputLocatorByPlaceHolder("* Станция метро"), station);
        scrollElementTo(itemMetroStationLocator);
        clickElement(itemMetroStationLocatorByName(station));

        setTextToInput(inputLocatorByPlaceHolder("* Телефон: на него позвонит курьер"), phone);

        clickElement(continueButton);
    }

}
