package tests;

import io.qameta.allure.Description;
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

    @Test(retryAnalyzer = Retry.class,testName = "Check create new day plan",description = "")
    @Description("Test creating a new training day and delete after assert")
    public void checkCreateNewDayPlan(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToButtonLogin()
                .login(user,password);
        workoutsPage
                .openPage()
                .clickCreatePlan()
                .editNameOfPlan(newDayPlan)
                .chooseOptions(section,option)
                .inputDescription(description)
                .clickAddExercises()
                .selectExercises(exercises)
                .clickFinishEditing();
        assertTrue(workoutsPage.isDayPlanExist("New test name"),"This day plan doesnt exist");
        delete(newDayPlan);
    }

    @Test(retryAnalyzer = Retry.class,testName = "Check printable day plan",description = "")
    @Description("Test of choosing a training plan and transition to creating a printed version. and delete after assert")
    public void checkPrintablePlan(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToButtonLogin()
                .login(user,password);
        workoutsPage
                .openFindPlan()
                .selectPlan(plan)
                .clickDownload()
                .clickToMenu(plan)
                .chooseMenuOption("Printable Version");
        assertTrue(workoutsPage.isPlanSheetExist(plan),"This workout plan does not exist");
        delete(plan);
    }

    public void delete(String line){
        workoutsPage.openPage().clickToMenu(line).chooseMenuOption("Delete").clickAcceptDelete();
    }
}
