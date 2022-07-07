import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.config.TestConfig;
import praktikum.pages.HomePage;
import praktikum.pages.OrderFormPage;

public class OpenOrderFormWithButton {

    private WebDriver driver;
    private String url = TestConfig.URL;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForLoadHomePage();
        homePage.submitCookies();
        homePage.openOrderFormFromRoadMap();

        OrderFormPage orderFormPage = new OrderFormPage(driver);
        orderFormPage.waitForOrderFormPage();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
