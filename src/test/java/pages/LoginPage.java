package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {

    private static String USER_INPUT = "//input[@name = 'username']";
    private static String PASSWORD_INPUT = "//input[@name = 'password']";
    private static String SUBMIT_LOGIN_BUTTON = "//button[@type = 'submit']";
    private static String LOGIN_BUTTON = " //a[normalize-space()='Log In']";
    private static String CONTINUE_BUTTON = "//button[text() = 'Continue']";
    private static String COMMUNITY_BUTTON = "//p[normalize-space()='Community']";
    private static String BLOG_BUTTON = "//a[@href = '/blog/']";
    private static String EXERCISES_BUTTON = "//a[normalize-space()='Exercises']";
    private static String WORKOUTS_BUTTON = "//p[normalize-space()='Workouts']";
    private static String ROUTINE_DATABASE_BUTTON = "//a[normalize-space()='Routine Database']";

    @Step("Click to routine database")
    public LoginPage clickToRoutineDatabase(){
        log.info("Method: clickToRoutineDatabase");
        $x(ROUTINE_DATABASE_BUTTON).click();
        return this;
    }

    @Step("Click to workouts")
    public LoginPage clickToWorkouts(){
        log.info("Method: clickToWorkouts");
        $x(WORKOUTS_BUTTON).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("Click to exercises")
    public LoginPage clickToExercises(){
        log.info("Method: clickToExercises");
        $x(EXERCISES_BUTTON).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("Is page opened")
    public LoginPage isPageOpened(){
        log.info("Method: isPageOpened");
        $x(LOGIN_BUTTON).shouldBe(Condition.visible).shouldBe(Condition.clickable);
        return this;
    }

    @Step("CLick to community")
    public LoginPage clickToCommunity(){
        log.info("Method: clickToCommunity");
        $x(COMMUNITY_BUTTON).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("CLick to blog")
    public LoginPage clickToBlog(){
        log.info("Method: clickToBlog");
        $x(BLOG_BUTTON).click();
        return this;
    }

//    @Step("Skip modal window - 'Welcome'")
//    public void skip(){
//        log.info("Method: skip");
//        $x(CONTINUE_BUTTON).click();
//    }

    @Step("Open main page")
    public LoginPage openPage(){
        log.info("Method: openPage");
        open("https://www.jefit.com/");
        sleep(1000);
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
