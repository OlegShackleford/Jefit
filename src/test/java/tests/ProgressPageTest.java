package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProgressPageTest extends BaseTest {

    @Test(testName = "Check Add Note")
    @Description("Test add new note and delete after assert")
    public void checkAddNewNote(){
        String textOfNote = "This is text for testing method - checkAddNewNote";
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
        Assert.assertTrue(progressPage.isNoteExist(textOfNote),"The note does not created");
        progressPage
                .clickToMenuNote("is text for")
                .delete();

    }

    @Test(testName = "Check Add Session")
    @Description("Test add session and delete after assert")
    public void checkAddSession() throws InterruptedException {
        loginPage
                .openPage()
                .clickToButtonLogin()
                .login(user,password);
        progressPage
                .openPage()
                .scrollToLogs()
                .clickToAddSession()
                .clickToExercises("Barbell Bench Press")
                .closeButton();
        Assert.assertTrue(progressPage.isTrainingSummaryExist("Training Summary 1"),
                "Session does not created");
        progressPage
                .clickMenuOfTrainingSummary()
                .clickDeleteSession()
                .delete();
    }
}
