package pages;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DiscoverPage {

    private static String CREATE_POST_BUTTON = "//button[text() = 'Create Post']";
    private static String TEXT_AREA = "//textarea[@name = 'content']";
    private static String POST_BUTTON = "//button[text() = 'Post']";
    private static String PATH_TO_POST = "//p[@data-slot = 'text' and contains(text(), '%s')]";
    private static String DELETE_BUTTON = "//button[text() = 'Delete']";
    private static String MENU_OF_POST = PATH_TO_POST +
            "/ancestor::div[contains(@class, 'flex')][1]//button[@aria-haspopup='menu']";

    public DiscoverPage openPage(){
        open("https://www.jefit.com/my-jefit");
        return this;
    }

    public DiscoverPage clickButtonCreatePost(){
        $x(CREATE_POST_BUTTON).click();
        return this;
    }

    public DiscoverPage createNewPost(String text){
        $x(TEXT_AREA).setValue(text);
        return this;
    }

    public DiscoverPage clickButtonPost(){
        $x(POST_BUTTON).click();
        return this;
    }

    public boolean isPostExist(String searchText){
        String actualText = $x(String.format(PATH_TO_POST,searchText)).getText();
        return actualText.equals(searchText);
    }

    public void clickToButtonDelete(String partOfPost){
        $x(String.format(MENU_OF_POST,partOfPost)).click();
        $x(DELETE_BUTTON).click();
    }
}
