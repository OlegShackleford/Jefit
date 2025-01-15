package tests.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected DiscoverPage discoverPage;
    protected ExercisesPage exercisesPage;
    protected ProgressPage progressPage;
    protected BlogPage blogPage;
    protected ExerciseDatabasePage exerciseDatabasePage;
    protected RoutineDatabasePage routineDatabasePage;
    protected WorkoutsPage workoutsPage;

    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                Configuration.browserCapabilities = chromeOptions;
                Configuration.timeout = 90000;
                Configuration.browser = Browsers.CHROME;
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless", "--width=1920", "--height=1080");
                Configuration.browserCapabilities = firefoxOptions;
                Configuration.timeout = 90000;
                Configuration.browser = Browsers.FIREFOX;
                break;
        }
        open();

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        exercisesPage = new ExercisesPage();
        progressPage = new ProgressPage();
        blogPage = new BlogPage();
        exerciseDatabasePage = new ExerciseDatabasePage();
        routineDatabasePage = new RoutineDatabasePage();
        workoutsPage = new WorkoutsPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
