package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
public class ProgressPage {

    private static String LINK = "https://www.jefit.com/my-jefit/progress/history";
    private static String UNIVERSAL_BUTTON = "//button[@type = 'button' and text() = '%s']";
    private static String MODAL_WINDOW_ADD_NOTE = "//textarea[@name = 'content']";
    private static String PATH_TO_NOTE = "//p[@data-slot = 'text' and contains(text(), '%s')]";
    private static String MENU_OF_POST = PATH_TO_NOTE + "/following::button[@aria-haspopup = 'menu']";
    private static String ADD_EXERCISES = "//div[@class = 'col-span-0 lg:col-span-2']" +
            "/descendant::button[@aria-label = '%s' and @type = 'button']";
    private static String ADD_EXERCISES_TWO = "(//*[@aria-label='Add %s'])[2]";
    private static String CLOSE = "//button[@type = 'button']/ancestor::div[@class = 'absolute top-2 right-2']";

    public ProgressPage closeButton(){
        $x(CLOSE).shouldBe(Condition.clickable).click();
        return this;
    }

    public ProgressPage clickToExercises(String exercises) throws InterruptedException {
        $x(String.format(ADD_EXERCISES_TWO,exercises)).shouldBe(Condition.clickable).click();
        Thread.sleep(2000);
        return this;
    }

    @Step("Scroll page to Logs")
    public ProgressPage scrollToLogs()  {
        log.info("Method: scrollToLogs");
        $x(String.format(UNIVERSAL_BUTTON,"Logs")).scrollTo();
        return this;
    }

    @Step("Click + Add Session")
    public ProgressPage clickToAddSession(){
        log.info("Method: clickToAddSession");
        $x(String.format(UNIVERSAL_BUTTON,"+ Add session")).click();
        return this;
    }

    @Step("Open Progress page")
    public ProgressPage openPage(){
        log.info("Method: openPage");
        open(LINK);
        return this;
    }

    @Step("Click to Notes")
    public ProgressPage clickNotes(){
        log.info("Method: clickNotes");
        $x(String.format(UNIVERSAL_BUTTON,"Notes")).scrollTo().click();
       return this;
    }

    @Step("Click to Add Note")
    public ProgressPage clickAddNote(){
        log.info("Method: clickAddNote");
        $x(String.format(UNIVERSAL_BUTTON,"+ Add Note")).click();
        return this;
    }

    @Step("Create new note in modal window")
    public ProgressPage createNewNote(String text){
        log.info("Method: createNewNote '{}'",text);
        $x(MODAL_WINDOW_ADD_NOTE).setValue(text);
        return this;
    }

    @Step("Click to button safe")
    public ProgressPage clickToButtonSafe(){
        log.info("Method: clickToButtonSafe");
        $x(String.format(UNIVERSAL_BUTTON,"Save Note")).click();
        return this;
    }

    public ProgressPage clickToMenuPost(String partOfPost){
        $x(String.format(MENU_OF_POST,partOfPost)).click();
        return this;
    }

    public ProgressPage deletePost(){
        $x(String.format(UNIVERSAL_BUTTON,"Delete")).click();
        return this;
    }
}
