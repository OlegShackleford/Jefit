package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProgressPage {

    private final static String LINK = "https://www.jefit.com/my-jefit/progress/history";
    private final static String UNIVERSAL_BUTTON = "//button[@type = 'button' and text() = '%s']";
    private final static String MODAL_WINDOW_ADD_NOTE = "//textarea[@name = 'content']";
    private final static String PATH_TO_NOTE = "//p[@data-slot = 'text' and contains(text(), '%s')]";
    private final static String MENU_OF_POST = PATH_TO_NOTE + "/following::button[@aria-haspopup = 'menu']";
    private final static String ADD_EXERCISES_TWO = "(//*[@aria-label='Add %s'])[2]";
    private final static String CLOSE = "//button[@type = 'button']/ancestor::div[@class = 'absolute top-2 right-2']";
    private final static String TRAINING_SUMMARY = "//h4[normalize-space()='%s']";
    private final static String MENU_OF_TRAINING_SUMMARY = "//*[normalize-space()='Training Summary 1']" +
            "/descendant::button[@aria-haspopup = 'menu']";
    private final static String DELETE_TRAINING_SUMMARY = "//p[@data-slot = 'text' and text() = 'Delete session']";

    @Step("Is note exist {note}")
    public boolean isNoteExist(String note) {
        log.info("Method: isNoteExist ,{}", note);
        String getNote = $x(String.format(PATH_TO_NOTE, note)).getText();
        return getNote.equals(note);
    }

    @Step("Click delete session")
    public ProgressPage clickDeleteSession() {
        log.info("Method: clickDeleteSession");
        $x(DELETE_TRAINING_SUMMARY).click();
        return this;
    }

    @Step("Click menu of training summary")
    public ProgressPage clickMenuOfTrainingSummary() {
        log.info("Method: clickMenuOfTrainingSummary");
        $x(MENU_OF_TRAINING_SUMMARY).click();
        return this;
    }

    @Step("Is training summary exist {title}")
    public boolean isTrainingSummaryExist(String title) {
        log.info("Method: isTrainingSummaryExist, {}", title);
        String trainingSummary = $x(String.format(TRAINING_SUMMARY, title)).getText();
        return title.equals(trainingSummary);
    }

    @Step("Close button")
    public ProgressPage closeButton() {
        log.info("Method: closeButton");
        $x(CLOSE).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("Click to Exercises {exercises}")
    public ProgressPage clickToExercises(String exercises) {
        log.info("Method: clickToExercises , {}", exercises);
        $x(String.format(ADD_EXERCISES_TWO, exercises)).shouldBe(Condition.clickable).click();
        sleep(2000);
        return this;
    }

    @Step("Scroll page to Logs")
    public ProgressPage scrollToLogs() {
        log.info("Method: scrollToLogs");
        $x(String.format(UNIVERSAL_BUTTON, "Logs")).scrollTo();
        return this;
    }

    @Step("Click + Add Session")
    public ProgressPage clickToAddSession() {
        log.info("Method: clickToAddSession");
        $x(String.format(UNIVERSAL_BUTTON, "+ Add session")).click();
        return this;
    }

    @Step("Open Progress page")
    public ProgressPage openPage() {
        log.info("Method: openPage");
        open(LINK);
        return this;
    }

    @Step("Click to Notes")
    public ProgressPage clickNotes() {
        log.info("Method: clickNotes");
        $x(String.format(UNIVERSAL_BUTTON, "Notes")).scrollTo().click();
        return this;
    }

    @Step("Click to Add Note")
    public ProgressPage clickAddNote() {
        log.info("Method: clickAddNote");
        $x(String.format(UNIVERSAL_BUTTON, "+ Add Note")).click();
        return this;
    }

    @Step("Create new note in modal window {text}")
    public ProgressPage createNewNote(String text) {
        log.info("Method: createNewNote '{}'", text);
        $x(MODAL_WINDOW_ADD_NOTE).setValue(text);
        return this;
    }

    @Step("Click to button safe")
    public ProgressPage clickToButtonSafe() {
        log.info("Method: clickToButtonSafe");
        $x(String.format(UNIVERSAL_BUTTON, "Save Note")).click();
        return this;
    }

    @Step("Click to menu note")
    public ProgressPage clickToMenuNote(String partOfPost) {
        log.info("Method: clickToMenuNote, {}", partOfPost);
        $x(String.format(MENU_OF_POST, partOfPost)).click();
        return this;
    }

    @Step("CLick delete")
    public ProgressPage delete() {
        log.info("Method: delete");
        $x(String.format(UNIVERSAL_BUTTON, "Delete")).click();
        sleep(300);
        return this;
    }
}
