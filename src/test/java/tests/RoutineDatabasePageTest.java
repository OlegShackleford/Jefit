package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

import static org.testng.Assert.assertEquals;

public class RoutineDatabasePageTest extends BaseTest {
    public String [] filters = {"Muscle","Days"};
    public String [] checkBox = {"Chest","1 day"};
    public String countExercises = "133";

    @Test(retryAnalyzer = Retry.class,testName = "Check search workouts plan",description = "")
    @Description("Test search workouts plan with filters and delete after assert")
    @Flaky
    public void checkSearchWorkoutsPlans(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToWorkouts()
                .clickToRoutineDatabase();
        routineDatabasePage
                .openPage()
                .isPageOpened()
                .clickFilterButton()
                .chooseFilters(filters[0], checkBox[0])
                .chooseFilters(filters[1], checkBox[1])
                .clickApplyFilters();
        assertEquals(routineDatabasePage.getCountExercises(),
                countExercises,"Incorrect count exercises");
    }

    @Test(retryAnalyzer = Retry.class,testName = "Check most viewed plan",description = "")
    @Description("Workout Sorting Test (Most Viewed). And delete after assert")
    @Flaky
    public void checkMostViewedPlan(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToWorkouts()
                .clickToRoutineDatabase();

        routineDatabasePage
                .openPage()
                .isPageOpened()
                .clickSortedBy()
                .clickMostViewed();
        assertEquals(routineDatabasePage.getFirstPlan(),
                "28-Day Cutting (Basic Gym Equipment)","Incorrect plan name");
    }
}
