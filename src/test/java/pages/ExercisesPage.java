package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ExercisesPage {

    private final String LINK = "https://www.jefit.com/my-jefit/exercises";
    private final String CREATE_CUSTOM_EXERCISES = "//a[text() = 'Exercise Database']" +
            "/ancestor::nav//button[text() = 'Create custom exercise ']";
    private final String EXERCISES_TITLE_INPUT = "//input[@value = 'New Exercise']";
    private final String MUSCLE_GROUP_SELECT = "//select[@name = 'muscle1']";
    private final String EQUIPMENT_SELECT = "//select[@name = 'equipment1']";
    private final String RECORDING_TYPE = "//select[@name = 'input_format']";
    private final String OPTIONS = "//option[text() = '%s']";
    private final String EXERCISES_INSTRUCTION = "//textarea[@name = 'description']";
    private final String SAVE_EXERCISES_BUTTON = "//button[text() = 'Save Exercise']";
    private final String TITLE_OF_EXERCISES = "//p[@data-slot='text' and text()='%s']";
    private final String MENU_OF_CREATED_EXERCISES = "/following::button[@type ='button']";
    private final String DELETE_BUTTON = "//div[@data-slot = 'label' and text() = 'Delete']";
    private final String CONFIRM_DELETE_BUTTON = "//button[@type = 'button' and text() = 'Delete']";

    public ExercisesPage openPage (){
        open(LINK);
        return this;
    }

    public ExercisesPage clickButtonCreateCustomExercises(){
        $x(CREATE_CUSTOM_EXERCISES).shouldBe(Condition.visible).click();
        return this;
    }

    public ExercisesPage createExercises(String title, String muscleType, String equipment, String recordingType,
                                         String description){
        $x(EXERCISES_TITLE_INPUT).setValue(title);
        $x(MUSCLE_GROUP_SELECT).click();
        $x(String.format(OPTIONS,muscleType)).click();
        $x(EQUIPMENT_SELECT).click();
        $x(String.format(OPTIONS,equipment)).click();
        $x(RECORDING_TYPE).click();
        $x(String.format(OPTIONS,recordingType)).click();
        $x(EXERCISES_INSTRUCTION).setValue(description);
        return this;
    }

    public ExercisesPage clickButtonSafe(){
        $x(SAVE_EXERCISES_BUTTON).click();
        return this;
    }

    public boolean isExercisesExist(String title){
       String exercises = $x(String.format(TITLE_OF_EXERCISES,title)).getText();
       return exercises.equals(title);
    }

    public ExercisesPage deleteProject(String title){
        $x(String.format(TITLE_OF_EXERCISES,title) + MENU_OF_CREATED_EXERCISES).click();
        $x(DELETE_BUTTON).click();
        $x(CONFIRM_DELETE_BUTTON).click();
        return this;
    }
}
