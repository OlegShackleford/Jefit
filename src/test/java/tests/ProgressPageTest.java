package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class ProgressPageTest extends BaseTest {

    public String textOfNote = "This is text for testing method - checkAddNewNote";
    public String exercises = "Barbell Bench Press";

    @Test(testName = "Check Add Note",description = "")
    @Description("Test add new note and delete after assert")
    public void checkAddNewNote(){
        loginPage
                .openPage()
                .clickToButtonLogin()
                .login(user,password);
        progressPage
                .openPage()
                .clickNotes()
                .clickAddNote()
                .createNewNote(textOfNote)
                .clickToButtonSafe();
        assertTrue(progressPage.isNoteExist(textOfNote),"The note does not created");
        progressPage
                .clickToMenuNote("is text for")
                .delete();
    }

    @Test(testName = "Check Add Session")
    @Description("Test add session and delete after assert")
    public void checkAddSession(){
        loginPage
                .openPage()
                .clickToButtonLogin()
                .login(user,password);
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
