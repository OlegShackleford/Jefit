package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.assertTrue;

public class ExercisesPageTest extends BaseTest {

    public String title = "Biceps test";
    public String muscleType = "Biceps";
    public String equipment = "Bench";
    public String recordingType = "Reps";
    public String description = "This is test description";

    @Test(testName = "Check create custom exercises",
            description = "Test creating your own exercise with 4 parameters. And a comparison by name.")
    @Description("Test create custom exercises and delete after assert")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Exercises")
    @Story("QA Engineer Chess creating your own exercise on the Exercises page")
    @Owner("Olegsey")
    public void checkCreateCustomExercises() {
        loginStep.allLoginStep(user, password);
        exercisesPage
                .openPage()
                .clickButtonCreateCustomExercises()
                .createExercises(title, muscleType, equipment, recordingType, description)
                .clickButtonSafe();
        assertTrue(exercisesPage.isExercisesExist("Biceps test"), "This exercises not exist");
        exercisesPage.deleteProject(title);
    }
}
