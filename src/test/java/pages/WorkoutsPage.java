package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class WorkoutsPage {

    private final static String LINK = "https://www.jefit.com/my-jefit/workouts";
    private final static String FIND_PLAN = "https://www.jefit.com/my-jefit/workouts/find";
    private final static String LINK_OF_PLAN2 = "//p[text() = '%s']/ancestor::td//" +
            "a[@tabindex = '0' and @data-headlessui-state = '']";
    private final static String DOWNLOAD_BUTTON = "//button[normalize-space() = 'Download']";
    private final static String MENU_OF_PLAN = "//p[normalize-space()='%s']/following::button[@aria-haspopup = 'menu'][1]";
    private final static String MENU_OPTION = "//div[normalize-space() = '%s']";
    private final static String SHEET_OF_PLAN = "//strong[normalize-space() = '%s']";
    private final static String ACCEPT_DELETE = "//button[normalize-space() = 'Delete']";
    private final static String CREATE_PLAN_BUTTON = "//button[normalize-space() = 'Create Plan']";
    private final static String EDIT_NAME = "//textarea[@name = 'Name']";
    private final static String OPTIONS = "//div[@data-slot = 'label' and text() = '%s']" +
            "/following::button[normalize-space() = '%s']";
    private final static String DESCRIPTION = "//textarea[@placeholder = 'Add workout plan description']";
    private final static String ADD_EXERCISES_BUTTON = "//*[normalize-space()= 'Add Exercise'][1]";
    private final static String SELECT_EXERCISES = "//button[@aria-label = 'Add %s']";
    private final static String FINISH_BUTTON = "//a[normalize-space()= 'Finish Editing']";
    private final static String PLAN_DAY_NAME = "//p[normalize-space() = '%s' and @data-slot = 'text']";

    @Step("Choose menu option {option}")
    public WorkoutsPage chooseMenuOption(String option) {
        log.info("Method: chooseMenuOption ,{}", option);
        $x(String.format(MENU_OPTION, option)).click();
        return this;
    }

    @Step("Is day plan exist {name}")
    public boolean isDayPlanExist(String name) {
        log.info("Method: isDayPlanExist , {}", name);
        String line = $x(String.format(PLAN_DAY_NAME, name)).getText();
        return name.equals(line);
    }

    @Step("Click finish editing")
    public WorkoutsPage clickFinishEditing() {
        log.info("Method: clickFinishEditing");
        $x(FINISH_BUTTON).click();
        sleep(500);
        return this;
    }

    @Step("Select exercises {exercises}")
    public WorkoutsPage selectExercises(String exercises) {
        log.info("Method: selectExercises ,{}", exercises);
        $x(String.format(SELECT_EXERCISES, exercises)).shouldBe(Condition.clickable).click();
        return this;
    }

    @Step("Click add exercises")
    public WorkoutsPage clickAddExercises() {
        log.info("Method: clickAddExercises");
        $x(ADD_EXERCISES_BUTTON).click();
        return this;
    }

    @Step("Input description {desc}")
    public WorkoutsPage inputDescription(String desc) {
        log.info("Method: inputDescription , {}", desc);
        $x(DESCRIPTION).setValue(desc);
        return this;
    }

    @Step("Choose option {optionOne} , {optionTwo}")
    public WorkoutsPage chooseOptions(String optionOne, String optionsTwo) {
        log.info("Method: chooseOptions ,{} , {}", optionOne, optionsTwo);
        $x(String.format(OPTIONS, optionOne, optionsTwo)).click();
        return this;
    }

    @Step("Edit name of plan {name}")
    public WorkoutsPage editNameOfPlan(String name) {
        log.info("Method: editNameOfPlan ,{}", name);
        $x(EDIT_NAME).setValue(name);
        return this;
    }

    @Step("Click created plan")
    public WorkoutsPage clickCreatePlan() {
        log.info("Method: clickCreatePlan");
        sleep(1000);
        $x(CREATE_PLAN_BUTTON).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Click accept delete")
    public WorkoutsPage clickAcceptDelete() {
        log.info("Method: clickAcceptDelete");
        $x(ACCEPT_DELETE).click();
        sleep(5000);
        return this;
    }

    @Step("Is plan sheet exist {plan}")
    public boolean isPlanSheetExist(String plan) {
        log.info("Method: isPlanExist, '{}'", plan);
        String line = $x(String.format(SHEET_OF_PLAN, plan)).getText();
        return line.equals(plan);
    }

    @Step("Click to menu {plan}")
    public WorkoutsPage clickToMenu(String plan) {
        log.info("Method: clickToMenu, '{}'", plan);
        sleep(500);
        $x(String.format(MENU_OF_PLAN, plan)).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Click download")
    public WorkoutsPage clickDownload() {
        log.info("Method: clickDownload");
        $x(DOWNLOAD_BUTTON).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Open find plan")
    public WorkoutsPage openFindPlan() {
        log.info("Method: openFindPlan");
        open(FIND_PLAN);
        return this;
    }

    @Step("Select plan {plan}")
    public WorkoutsPage selectPlan(String plan) {
        log.info("Method: selectPlan, '{}'", plan);
        $x(String.format(LINK_OF_PLAN2, plan)).click();
        return this;
    }

    @Step("Open WorkoutsPage")
    public WorkoutsPage openPage() {
        log.info("Method: openPage 'WorkoutsPage'");
        open(LINK);
        sleep(1500);
        return this;
    }
}
