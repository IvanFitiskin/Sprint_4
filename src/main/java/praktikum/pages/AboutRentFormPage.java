package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentFormPage extends DriverLogic {

    private final By headerLocator = By.xpath(".//div[text()='Про аренду']");

    private final By inputMonthCalendarLocator = inputLocatorByPlaceHolder("* Когда привезти самокат");
    private final By monthContainerLocator = By.className("react-datepicker__month-container");
    private final By nextMonthButtonLocator = By.xpath(".//button[@aria-label='Next Month']");
    private By dayLocatorByNumber(int number) {
        return By.xpath(String.format(".//div[@class='react-datepicker__week']/div[text()=%s]", number));
    }

    private final By rentalPeriodLocator = By.className("Dropdown-placeholder");
    private final By rentalPeriodDropdownMenuLocator = By.className("Dropdown-menu");
    private By rentalPeriodDropdownOptionByTextLocator(String text) {
        return By.xpath(String.format(".//div[@class='Dropdown-option' and text()='%s']", text));
    }

    private final By colorChoiceLocator = By.className("Order_Checkboxes__3lWSI");
    private final By titleColorChoiceLocator = By.xpath(".//div[text()='Цвет самоката']");
    private By checkBoxByColorNameLocator(String colorName) {
        return By.xpath(String.format(".//input[@id='%s']", colorName));
    }

    private final By inputCommentLocator = inputLocatorByPlaceHolder("Комментарий для курьера");

    private final By orderedButtonLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    private final By backButtonLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Назад']");

    public AboutRentFormPage(WebDriver driver) {
        super(driver);
    }

    public void waitForAboutRentFormPage() {
        waitForVisible(headerLocator);
        waitForVisible(inputMonthCalendarLocator);
        waitForVisible(rentalPeriodLocator);
        waitForVisible(colorChoiceLocator);
        waitForVisible(inputCommentLocator);
    }

    public void submitAdditionalData(int date, String period, String color, String comment) {
        clickElement(inputMonthCalendarLocator);
        waitForVisible(monthContainerLocator);
        // Выставляем следующий месяц и выбираем 1 день. Так быстрее всего накостылять тест без сложной логики.
        clickElement(nextMonthButtonLocator);
        clickElement(dayLocatorByNumber(date));

        clickElement(rentalPeriodLocator);
        waitForVisible(rentalPeriodDropdownMenuLocator);
        scrollElementTo(rentalPeriodDropdownOptionByTextLocator(period));
        clickElement(rentalPeriodDropdownOptionByTextLocator(period));

        clickElement(colorChoiceLocator);
        waitForVisible(titleColorChoiceLocator);
        waitForVisible(checkBoxByColorNameLocator("black"));
        waitForVisible(checkBoxByColorNameLocator("grey"));
        clickElement(checkBoxByColorNameLocator(color));

        setTextToInput(inputCommentLocator, comment);

        clickElement(orderedButtonLocator);
    }
}
