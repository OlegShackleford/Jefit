package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class RoutineDatabasePage {

    private static String LINK = "https://www.jefit.com/routines";
    private static String LOADING_ELEMENT = "//img[@alt = 'HIIT: High Intensity Interval Training (Cardio)banner']";
    private static String COUNT_EXERCISES = "//span[@class = 'text-base/6 text-main-black dark:d-main-black font-semibold']";
    private static String BUTTON_FILTER = "//span[text() = 'FILTERS ']/ancestor::button[@type = 'button']";
    private static String FILTER_IN_MODAL_WINDOW = "//div[normalize-space() = '%s']/following-sibling::button[@type = 'button']";
    private static String CHECKBOX = "//span[@role = 'checkbox']/following-sibling::label[normalize-space() = '%s']";
    private static String APPLY_FILTERS = "//button[normalize-space()='Apply Filters']";
    private static String SORTED_BY_BUTTON = "//button[@id = 'headlessui-menu-button-:Rfpopuuduija:']";
    private static String MOST_VIEWED_OPTION = "//button[normalize-space() = 'Most Viewed']";
    private static String FIRST_PLAN_IN_LIST = "//table[@class = 'min-w-full text-left text-sm/6']" +
            "/descendant::p[@data-slot = 'text'][8]";

    @Step("Get first plan")
    public String getFirstPlan(){
        log.info("Method: getFirstPlan");
        sleep(500);
        return  $x(FIRST_PLAN_IN_LIST).shouldBe(Condition.visible).getText().replace("\n", " ");
    }

    @Step("Click most viewed")
    public RoutineDatabasePage clickMostViewed(){
        log.info("Method: clickMostViewed");
        $x(MOST_VIEWED_OPTION).click();
        return this;
    }

    @Step("Click sorted by")
    public RoutineDatabasePage clickSortedBy(){
        log.info("Method: clickSortedBy");
        $x(SORTED_BY_BUTTON).shouldBe(Condition.visible).scrollTo().click();
        return this;
    }

    @Step("Click filter button")
    public RoutineDatabasePage clickFilterButton(){
        log.info("Method: clickFilterButton");
        $x(BUTTON_FILTER).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Click apply filters")
    public RoutineDatabasePage clickApplyFilters(){
        log.info("Method: clickApplyFilters");
        $x(APPLY_FILTERS).shouldBe(Condition.visible).shouldBe(Condition.clickable).click();
        sleep(1000);
        return this;
    }

    @Step("Choose filters")
    public RoutineDatabasePage chooseFilters(String filter,String checkBox){
        log.info("Method: chooseFilters '{},'{}''",filter,checkBox);
        $x(String.format(FILTER_IN_MODAL_WINDOW,filter)).shouldBe(Condition.visible).click();
        $x(String.format(CHECKBOX,checkBox)).shouldBe(Condition.visible).click();
        $x(String.format(FILTER_IN_MODAL_WINDOW,filter)).click();
        return this;
    }

    @Step("Open page")
    public RoutineDatabasePage openPage(){
        log.info("Method: openPage");
        open(LINK);
        return this;
    }

    @Step("Is page opened")
    public RoutineDatabasePage isPageOpened(){
        log.info("Method: isPageOpened");
        $x(LOADING_ELEMENT).shouldBe(Condition.visible);
        return this;
    }

    @Step("Get count exercises")
    public String getCountExercises(){
        log.info("Method: getCountExercises");
        return $x(COUNT_EXERCISES).getText().trim();
    }
}
