package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;
import static org.testng.Assert.assertEquals;

public class RoutineDatabasePageTest extends BaseTest {
    public String [] filters = {"Muscle","Days"};
    public String [] checkBox = {"Chest","1 day"};
    public String countExercises = "133";

    @Test(retryAnalyzer = Retry.class,testName = "Check search workouts plan",
            description = "Test for sorting workouts by two filters and comparing their number")
    @Description("Test search workouts plan with filters")
    @Story("QA Engineer check that the number of sorted workouts matches.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("RoutineDatabase in workouts")
    @Flaky
    @Owner("Olegsey")
    public void checkSearchWorkoutsPlans(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToWorkouts()
                .clickToRoutineDatabase();
        routineDatabasePage
                .clickFilterButton()
                .chooseFilters(filters[0], checkBox[0])
                .chooseFilters(filters[1], checkBox[1])
                .clickApplyFilters();
        assertEquals(routineDatabasePage.getCountExercises(),
                countExercises,"Incorrect count exercises");
    }

    @Test(retryAnalyzer = Retry.class,testName = "Check most viewed plan",
            description = "Test to display the most viewed workout")
    @Description("Workout Sorting Test (Most Viewed).")
    @Severity(SeverityLevel.NORMAL)
    @Flaky
    @Feature("RoutineDatabase in workouts")
    @Story("QA Engineer check that the most downloaded workout is the first in the list of workouts")
    @Owner("Olegsey")
    public void checkMostViewedPlan(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToWorkouts()
                .clickToRoutineDatabase();
        routineDatabasePage
                .clickSortedBy()
                .clickMostViewed();
        assertEquals(routineDatabasePage.getFirstPlan(),
                "28-Day Cutting (Basic Gym Equipment)","Incorrect plan name");
    }
}
