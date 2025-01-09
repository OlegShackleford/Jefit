package tests.base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.DiscoverPage;
import pages.ExercisesPage;
import pages.LoginPage;
import pages.ProgressPage;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected DiscoverPage discoverPage;
    protected ExercisesPage exercisesPage;
    protected ProgressPage progressPage;

    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password",PropertyReader.getProperty("password"));

//    protected String user = "nordhagen88@rambler.ru";
//    protected String password = "Oleg2403";

    @BeforeMethod
    public void setUp(){
        Configuration.browser = Browsers.CHROME;
        Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = 60000;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        Configuration.browserCapabilities = options;


        open();
//        getWebDriver().manage().window().maximize();

        loginPage = new LoginPage();
        discoverPage = new DiscoverPage();
        exercisesPage = new ExercisesPage();
        progressPage = new ProgressPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown(){
//        if (getWebDriver() != null){
//            getWebDriver().quit();
//        }
//    }
}
