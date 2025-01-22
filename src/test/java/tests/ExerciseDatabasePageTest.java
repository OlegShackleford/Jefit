package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.assertEquals;

public class ExerciseDatabasePageTest extends BaseTest {

    public String muscleGroup = "Biceps";
    public String countExercisesMuscle = "103";
    public String equipment = "Bench";
    public String countExercisesEquipment = "49";
    public String[] filters = {"Muscle", "Difficulty"};
    public String[] checkBox = {"Back", "Beginner"};
    public String countExercisesWithTwoFilters = "101";

    @Test(testName = "Check count exercises with filter by muscle",
            description = "Test for displaying the number of exercises with a single filter by muscle." +
                    " The number of exercises may vary")
    @Flaky
    @Story("QA engineer checks the number of exercises with the selected filter")
    @Feature("Exercises database")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Olegsey")
    @Description("Test filter by muscles with validation of the number of exercises")
    public void checkCountExercisesWithFilterByMuscle() {
        loginPage
                .openPage()
                .isPageOpened()
                .clickToExercises();
        exerciseDatabasePage
                .openPage()
                .isPageOpened()
                .chooseMuscleGroup(muscleGroup);
        assertEquals(exerciseDatabasePage.getCountExercises(),
                countExercisesMuscle, "Incorrect count exercises");
    }

    @Test(testName = "Check count exercises with filter by equipment",
            description = "Test for displaying the number of exercises with a single filter by equipment." +
                    " The number of exercises may vary")
    @Description("Test filter by equipment with validation of the number of exercises")
    @Story("QA engineer checks the number of exercises with the selected filter")
    @Flaky
    @Feature("Exercises database")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Olegsey")
    public void checkCountExercisesWithFilterByEquipment() {
        loginPage
                .openPage()
                .isPageOpened()
                .clickToExercises();
        exerciseDatabasePage
                .openPage()
                .isPageOpened()
                .chooseEquipmentGroup(equipment);
        assertEquals(exerciseDatabasePage.getCountExercises(),
                countExercisesEquipment, "Incorrect count exercises");
    }

    @Test(testName = "Check correctness of filters operation",
            description = "Test for displaying the number of exercises with two filter muscle and difficulty." +
                    " The number of exercises may vary")
    @Description("Test of correct filter operation with filters")
    @Feature("Exercises database")
    @Story("QA engineer checks the number of exercises with the selected filter")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Olegsey")
    public void checkCorrectnessOfFiltersOperation() {
        loginPage
                .openPage()
                .isPageOpened()
                .clickToExercises();
        exerciseDatabasePage
                .openPage()
                .isPageOpened()
                .clickFilterButton()
                .chooseFilters(filters[0], checkBox[0])
                .chooseFilters(filters[1], checkBox[1])
                .clickApplyFilters();
        assertEquals(exerciseDatabasePage.getCountExercises(),
                countExercisesWithTwoFilters, "Incorrect count exercises");
    }
}
