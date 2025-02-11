package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ExerciseDatabasePage {

    private final static String Link = "https://www.jefit.com/exercises";
    private final static String FILTER_BY = "//button[@type = 'button']/descendant::p[text() = '%s']";
    private final static String COUNT_EXERCISES = "//span[@class = 'text-base/6 text-main-black dark:d-main-black font-semibold']";
    private final static String LOADING_ELEMENT = "//img[@alt='body equipment example']";
    private final static String BUTTON_FILTER = "//span[text() = 'FILTERS ']/ancestor::button[@type = 'button']";
    private final static String FILTER_IN_MODAL_WINDOW = "//div[normalize-space() = '%s']/following-sibling::button[@type = 'button']";
    private final static String CHECKBOX = "//span[@role = 'checkbox']/following-sibling::label[normalize-space() = '%s']";
    private final static String APPLY_FILTERS = "//button[normalize-space()='Apply Filters']";

    @Step("Click filter button")
    public ExerciseDatabasePage clickFilterButton() {
        log.info("Method: clickFilterButton");
        $x(BUTTON_FILTER).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Click apply filter")
    public ExerciseDatabasePage clickApplyFilters() {
        log.info("Method: clickApplyFilters");
        $x(APPLY_FILTERS).shouldBe(Condition.visible).shouldBe(Condition.clickable).click();
        sleep(1000);
        return this;
    }

    @Step("Choose filters {filter} , {checkBox}")
    public ExerciseDatabasePage chooseFilters(String filter, String checkBox) {
        log.info("Method: chooseFilters '{},'{}'", filter, checkBox);
        $x(String.format(FILTER_IN_MODAL_WINDOW, filter)).shouldBe(Condition.visible).click();
        $x(String.format(CHECKBOX, checkBox)).shouldBe(Condition.visible).click();
        $x(String.format(FILTER_IN_MODAL_WINDOW, filter)).click();
        return this;
    }

    @Step("Open page")
    public ExerciseDatabasePage openPage() {
        log.info("Method: openPage");
        open(Link);
        return this;
    }

    @Step("Is page opened")
    public ExerciseDatabasePage isPageOpened() {
        log.info("Method: isPageOpened");
        $x(LOADING_ELEMENT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Choose muscle group {muscle}")
    public ExerciseDatabasePage chooseMuscleGroup(String muscle) {
        sleep(500);
        log.info("Method: chooseMuscleGroup ,{}", muscle);
        executeJavaScript("arguments[0].click();", $x(String.format(FILTER_BY, muscle)));
        return this;
    }

    @Step("Choose equipment {equipment}")
    public ExerciseDatabasePage chooseEquipmentGroup(String equipment) {
        sleep(500);
        log.info("Method: chooseMuscleGroup ,{}", equipment);
        executeJavaScript("arguments[0].click();", $x(String.format(FILTER_BY, equipment)));
        return this;
    }

    @Step("Get count exercises")
    public String getCountExercises() {
        sleep(500);
        log.info("Method: getCountExercises");
        return $x(COUNT_EXERCISES).getText().trim();
    }
}
