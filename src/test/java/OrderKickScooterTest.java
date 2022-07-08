import praktikum.config.TestConfig;
import praktikum.model.AboutRentData;
import praktikum.model.UserData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.model.constants.Color;
import praktikum.pages.AboutRentFormPage;
import praktikum.pages.HomePage;
import praktikum.pages.OrderFormPage;
import praktikum.pages.PopupOrderPage;

@RunWith(Parameterized.class)
public class OrderKickScooterTest {

    private WebDriver driver;
    private String url = TestConfig.URL;

    private final UserData userData;
    private final AboutRentData aboutRentData;

    public OrderKickScooterTest(UserData userData, AboutRentData aboutRentData) {
        this.userData = userData;
        this.aboutRentData = aboutRentData;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        UserData userTestData1 = new UserData(
                "Иван",
                "Фитискин",
                "Лухмановская, д.20",
                "Бульвар Рокоссовского",
                "+79653090000"
        );
        UserData userTestData2 = new UserData(
                "Ваня",
                "Фитискин",
                "Тверская, д.1",
                "Пушкинская",
                "+79653090001"
        );
        AboutRentData aboutRentDataTestData1 = new AboutRentData(
                1,
                "сутки",
                Color.GREY,
                "Просто комментарий"
        );
        AboutRentData aboutRentDataTestData2 = new AboutRentData(
                15,
                "семеро суток",
                Color.BLACK,
                "Просто комментарий"
        );
        return new Object[][] {
                { userTestData1, aboutRentDataTestData1 },
                { userTestData2, aboutRentDataTestData2 },
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void testOrderKickScooter() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage();
        homePage.submitCookies();
        homePage.openOrderFormFromHeader();

        OrderFormPage orderFormPage = new OrderFormPage(driver);
        orderFormPage.waitForOrderFormPage();
        orderFormPage.submitUserData(
                userData.getFirstName(),
                userData.getSecondName(),
                userData.getAddress(),
                userData.getStation(),
                userData.getPhoneNumber()
        );

        AboutRentFormPage aboutRentFormPage = new AboutRentFormPage(driver);
        aboutRentFormPage.waitForAboutRentFormPage();
        aboutRentFormPage.submitAdditionalData(
                aboutRentData.getDate(),
                aboutRentData.getPeriod(),
                aboutRentData.getColor(),
                aboutRentData.getComment()
        );

        PopupOrderPage popupOrderPage = new PopupOrderPage(driver);
        popupOrderPage.waitForPopupOrder();

        // Здесь тест сломается, так как есть баг в https://qa-scooter.praktikum-services.ru/,
        // о котором говорится в задании
        popupOrderPage.pressSuccessButton();
        popupOrderPage.checkOrderStatus();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
