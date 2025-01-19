package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Flaky;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class LoginPage {

    private final static String USER_INPUT = "//input[@name = 'username']";
    private final static String PASSWORD_INPUT = "//input[@name = 'password']";
    private final static String SUBMIT_LOGIN_BUTTON = "//button[@type = 'submit']";
    private final static String LOGIN_BUTTON = " //a[normalize-space()='Log In']";
    private final static String CONTINUE_BUTTON = "//button[text() = 'Continue']";
    private final static String COMMUNITY_BUTTON = "//p[normalize-space()='Community']";
    private final static String BLOG_BUTTON = "//a[@href = '/blog/']";
    private final static String EXERCISES_BUTTON = "//a[normalize-space()='Exercises']";
    private final static String WORKOUTS_BUTTON = "//p[normalize-space()='Workouts']";
    private final static String ROUTINE_DATABASE_BUTTON = "//a[normalize-space()='Routine Database']";

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

    @Step("Open main page")
    @Flaky
    public LoginPage openPage(){
        log.info("Method: openPage");
        open("https://www.jefit.com/");
        sleep(1500);
        return this;
    }

    @Step("Click to button 'Login'")
    @Flaky
    public LoginPage clickToButtonLogin(){
        log.info("Method: clickToButtonLogin");
        $x(LOGIN_BUTTON).shouldBe(Condition.visible).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("Login with credentials: {user} , {password}")
    public LoginPage login(String user,String password){
        log.info("Method: login '{}','{}'",user,password);
        $x(USER_INPUT).setValue(user);
        $x(PASSWORD_INPUT).setValue(password);
        $x(SUBMIT_LOGIN_BUTTON).click();
        $x(CONTINUE_BUTTON).click();
        return this;
    }
}
