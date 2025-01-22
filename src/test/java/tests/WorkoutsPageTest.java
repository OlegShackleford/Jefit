package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;
import static org.testng.Assert.assertTrue;

public class WorkoutsPageTest extends BaseTest {

    public String newDayPlan = "New test name";
    public String exercises = "Barbell Bench Press";
    public String description = "This is test message for new day plan";
    public String section = "Focus";
    public String option = "Bulking";
    public String plan = "6-Weeks to Six-Pack Abs";

    @Test(retryAnalyzer = Retry.class, testName = "Check create new day plan",
            description = "Test for creating a training day with the necessary parameters")
    @Description("Test creating a new training day and delete after assert")
    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Story("QA Engineer testing the creation of a training day with two parameters, one exercise, name and description")
    @Feature("Workouts")
    @Owner("Olegsey")
    public void checkCreateNewDayPlan() {
        loginStep.allLoginStep(user,password);
        workoutsPage
                .openPage()
                .clickCreatePlan()
                .editNameOfPlan(newDayPlan)
                .chooseOptions(section, option)
                .inputDescription(description)
                .clickAddExercises()
                .selectExercises(exercises)
                .clickFinishEditing();
        assertTrue(workoutsPage.isDayPlanExist("New test name"), "This day plan doesnt exist");
        delete(newDayPlan);
    }

    @Test(retryAnalyzer = Retry.class, testName = "Check printable day plan",
            description = "Testing the ability to download the selected workout")
    @Description("Test of choosing a training plan and transition to creating a printed version. and delete after assert")
    @Flaky
    @Severity(SeverityLevel.NORMAL)
    @Story("QA Engineer check that it is possible to print the selected workout")
    @Feature("Workouts")
    @Owner("Olegsey")
    public void checkPrintablePlan() {
        loginStep.allLoginStep(user,password);
        workoutsPage
                .openFindPlan()
                .selectPlan(plan)
                .clickDownload()
                .clickToMenu(plan)
                .chooseMenuOption("Printable Version");
        assertTrue(workoutsPage.isPlanSheetExist(plan), "This workout plan does not exist");
        delete(plan);
    }

    public void delete(String line) {
        workoutsPage.openPage().clickToMenu(line).chooseMenuOption("Delete").clickAcceptDelete();
    }
}
