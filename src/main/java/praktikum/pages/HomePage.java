package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends DriverLogic {

    private final By headerLocator = By.className("Header_Header__214zg");
    private final By firstPartLocator = By.className("Home_FirstPart__3g6vG");
    private final By fourPartLocator = By.className("Home_FourPart__1uthg");
    private final By subHeadLocator =
            By.xpath(".//div[@class = 'Home_SubHeader__zwi_E' and text()='Вопросы о важном']");

    private final By submitCookiesLocator = By.id("rcc-confirm-button");

    private final By orderButtonInHeaderLocator = By.xpath(".//div[@class='Header_Header__214zg']//button[text()='Заказать']");
    private final By orderButtonInRoadMapLocator = By.xpath(".//div[@class='Home_RoadMap__2tal_']//button[text()='Заказать']");


    private By accordionTitleByText(String text) {
        return By.xpath(String.format(".//*[@class='accordion__button' and text()='%s']", text));
    }

    private By accordionDescriptionByText(String text) {
        return By.xpath(String.format(".//*[@class='accordion__panel']//p[text()='%s']", text));
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoadHomePage() {
        waitForVisible(headerLocator);
        waitForVisible(firstPartLocator);
    }

    public void submitCookies() {
        clickElement(submitCookiesLocator, 5);
    }

    public void scrollToQuestionAboutImportantHeader() {
        scrollElementTo(fourPartLocator);
        waitForVisible(subHeadLocator);
    }

    public void checkAccordingItemByTitleText(String titleText, String description) {
        scrollElementTo(accordionTitleByText(titleText));
        clickElement(accordionTitleByText(titleText));
        waitForVisible(accordionDescriptionByText(description));
    }

    public void openOrderFormFromHeader() {
        clickElement(orderButtonInHeaderLocator);
    }

    public void openOrderFormFromRoadMap() {
        scrollElementTo(orderButtonInHeaderLocator);
        clickElement(orderButtonInHeaderLocator);
    }
}
