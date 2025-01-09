package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ExercisesPagePageTest extends BaseTest {

    @Test
    public void checkCreateCustomExercises(){
        loginPage
                .openPage()
                .clickToButtonLogin()
                .login(user,password).skip();

        exercisesPage
                .openPage()
                .clickButtonCreateCustomExercises()
                .createExercises("Biceps test","Biceps",
                        "Bench","Reps","This is test description").clickButtonSafe();
        Assert.assertTrue(exercisesPage.isExercisesExist("Biceps test"),"This exercises not exist");
        exercisesPage.deleteProject("Biceps test");
    }
}
