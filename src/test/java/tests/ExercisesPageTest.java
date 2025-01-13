package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ExercisesPageTest extends BaseTest {

    @Test(testName = "Check create custom exercises")
    @Description("Test create custom exercises and delete after assert")
    public void checkCreateCustomExercises(){
        loginPage
                .openPage()
                .clickToButtonLogin()
                .login(user,password);

        exercisesPage
                .openPage()
                .clickButtonCreateCustomExercises()
                .createExercises("Biceps test","Biceps",
                        "Bench","Reps","This is test description")
                .clickButtonSafe();
        Assert.assertTrue(exercisesPage.isExercisesExist("Biceps test"),"This exercises not exist");
        exercisesPage.deleteProject("Biceps test");
    }
}
