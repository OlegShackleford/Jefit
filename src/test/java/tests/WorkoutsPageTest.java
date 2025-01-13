package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class WorkoutsPageTest extends BaseTest {

    @Test(testName = "Check create new day plan")
    @Description("Test creating a new training day and delete after assert")
    public void checkCreateNewDayPlan(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToButtonLogin()
                .login(user,password);

        workoutsPage
                .openPage()
                .isPageOpened()
                .clickCreatePlan()
                .editNameOfPlan("New test name")
                .chooseOptions("Focus","Bulking")
                .inputDescription("This is test message for new day plan")
                .clickAddExercises()
                .selectExercises("Barbell Bench Press")
                .clickFinishEditing();
        Assert.assertTrue(workoutsPage.isDayPlanExist("New test name"),"This day plan doesnt exist");
        workoutsPage.clickToMenu("New test name").chooseMenuOption("Delete").clickAcceptDelete();
    }

    @Test(testName = "Check printable day plan")
    @Description("Test of choosing a training plan and transition to creating a printed version. and delete after assert")
    public void checkPrintablePlan(){
        String plan = "6-Weeks to Six-Pack Abs";
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
        Assert.assertTrue(workoutsPage.isPlanSheetExist(plan),"This workout plan does not exist");
        workoutsPage.openPage().clickToMenu(plan).chooseMenuOption("Delete").clickAcceptDelete();
    }
}
