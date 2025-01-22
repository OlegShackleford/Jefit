package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.assertTrue;

public class ProgressPageTest extends BaseTest {

    public String textOfNote = "This is text for testing method - checkAddNewNote";
    public String exercises = "Barbell Bench Press";

    @Test(testName = "Check Add Note",
            description = "Test for creating a note on the Progress page and deleting it")
    @Description("Test add new note and delete after assert")
    @Story("QA Engineer. Chess creating a note. On the Progress page. Make sure the note is created")
    @Feature("Progress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Olegsey")
    public void checkAddNewNote() {
        loginStep.allLoginStep(user,password);
        progressPage
                .openPage()
                .clickNotes()
                .clickAddNote()
                .createNewNote(textOfNote)
                .clickToButtonSafe();
        assertTrue(progressPage.isNoteExist(textOfNote), "The note does not created");
        progressPage
                .clickToMenuNote("is text for")
                .delete();
    }

    @Test(testName = "Check Add Session",
            description = "Test for creating a training session on the Progress page with name - Training Summary 1")
    @Description("Test add session and delete after assert")
    @Story("QA Engineer. Chess creating a training session. On the Progress page. Make sure the training session" +
            " with name - Training Summary 1 is created")
    @Feature("Progress")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Olegsey")
    public void checkAddSession() {
        loginStep.allLoginStep(user,password);
        progressPage
                .openPage()
                .scrollToLogs()
                .clickToAddSession()
                .clickToExercises(exercises)
                .closeButton();
        assertTrue(progressPage.isTrainingSummaryExist("Training Summary 1"),
                "Session does not created");
        progressPage
                .clickMenuOfTrainingSummary()
                .clickDeleteSession()
                .delete();
    }
}
