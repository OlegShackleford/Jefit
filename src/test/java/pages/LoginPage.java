package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class LoginPage {

    private static String USER_INPUT = "//input[@name = 'username']";
    private static String PASSWORD_INPUT = "//input[@name = 'password']";
    private static String SUBMIT_LOGIN_BUTTON = "//button[@type = 'submit']";
    private static String LOGIN_BUTTON = " //a[normalize-space()='Log In']";
    private static String CONTINUE_BUTTON = "//button[text() = 'Continue']";

    WebDriverWait wait = new WebDriverWait(getWebDriver(),Duration.ofSeconds(5));

    @Step("Skip modal window - 'Welcome'")
    public void skip(){
        log.info("Method: skip");
        $x(CONTINUE_BUTTON).click();
    }

    @Step("Open main page")
    public LoginPage openPage(){
        log.info("Method: openPage");
        open("https://www.jefit.com/");
        return this;
    }

//    public LoginPage isPageOpened(){
//        log.info("Method: isPageOpened");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_BUTTON)));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN_BUTTON)));
//        return this;
//    }

    @Step("Click to button 'Login'")
    public LoginPage clickToButtonLogin(){
        log.info("Method: clickToButtonLogin");
        $x(LOGIN_BUTTON).shouldBe(Condition.visible).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("Login with credentials")
    public LoginPage login(String user,String password){
        log.info("Method: login '{}','{}'",user,password);
        $x(USER_INPUT).setValue(user);
        $x(PASSWORD_INPUT).setValue(password);
        $x(SUBMIT_LOGIN_BUTTON).click();
        $x(CONTINUE_BUTTON).click();
        return this;
    }
}
