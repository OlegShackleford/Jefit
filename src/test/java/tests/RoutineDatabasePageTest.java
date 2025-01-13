package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class RoutineDatabasePageTest extends BaseTest {

    @Test(testName = "Check search workouts plan")
    @Description("Test search workouts plan with filters and delete after assert")
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
                .chooseFilters("Muscle","Chest")
                .chooseFilters("Days","1 day")
                .clickApplyFilters();
        Assert.assertEquals(routineDatabasePage.getCountExercises(),
                "132","Incorrect count exercises");
    }

    @Test(testName = "Check most viewed plan")
    @Description("Workout Sorting Test (Most Viewed). And delete after assert")
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
        Assert.assertEquals(routineDatabasePage.getFirstPlan(),
                "28-Day Cutting (Basic Gym Equipment)","Incorrect plan name");
    }
}
