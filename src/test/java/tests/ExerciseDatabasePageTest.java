package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ExerciseDatabasePageTest extends BaseTest {

    @Test(testName = "Check count exercises with filter by muscle")
    @Description("Test filter by muscles with validation of the number of exercises")
    public void checkCountExercisesWithFilterByMuscle(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToExercises();

        exerciseDatabasePage
                .openPage()
                .isPageOpened()
                .chooseMuscleGroup("Biceps");

        Assert.assertEquals(exerciseDatabasePage.getCountExercises(),
                "103","Incorrect count exercises");
    }

    @Test(testName = "Check count exercises with filter by equipment")
    @Description("Test filter by equipment with validation of the number of exercises")
    public void checkCountExercisesWithFilterByEquipment(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToExercises();

        exerciseDatabasePage
                .openPage()
                .isPageOpened()
                .chooseEquipmentGroup("Bench");

        Assert.assertEquals(exerciseDatabasePage.getCountExercises(),
                "49","Incorrect count exercises");

    }

    @Test(testName = "Check correctness of filters operation")
    @Description("Test of correct filter operation with filters")
    public void checkCorrectnessOfFiltersOperation(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToExercises();

        exerciseDatabasePage
                .openPage()
                .isPageOpened()
                .clickFilterButton()
                .chooseFilters("Muscle","Back")
                .chooseFilters("Difficulty","Beginner")
                .clickApplyFilters();

        Assert.assertEquals(exerciseDatabasePage.getCountExercises(),
                "101","Incorrect count exercises");
    }
}
