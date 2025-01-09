package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProgressPageTest extends BaseTest {

    @Test
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
        progressPage.clickToMenuPost("is text for").deletePost();

    }

    @Test
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
    }
}
