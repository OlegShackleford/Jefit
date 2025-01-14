package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class DiscoverPage {

    private final static String LINK = "https://www.jefit.com/my-jefit";
    private final static String CREATE_POST_BUTTON = "//button[text() = 'Create Post']";
    private final static String TEXT_AREA = "//textarea[@name = 'content']";
    private final static String POST_BUTTON = "//button[text() = 'Post']";
    private final static String PATH_TO_POST = "//p[@data-slot = 'text' and contains(text(), '%s')]";
    private final static String DELETE_BUTTON = "//button[text() = 'Delete']";
    private final static String MENU_OF_POST = PATH_TO_POST +
            "/ancestor::div[contains(@class, 'flex')][1]//button[@aria-haspopup='menu']";

    @Step("Open page")
    public DiscoverPage openPage() {
        log.info("Method: ");
        open(LINK);
        return this;
    }

    @Step("Click button create post")
    public DiscoverPage clickButtonCreatePost() {
        log.info("Method: clickButtonCreatePost");
        $x(CREATE_POST_BUTTON).click();
        return this;
    }

    @Step("Create new post {text}")
    public DiscoverPage createNewPost(String text) {
        log.info("Method: createNewPost , {}", text);
        $x(TEXT_AREA).setValue(text);
        return this;
    }

    @Step("Click button post")
    public DiscoverPage clickButtonPost() {
        log.info("Method: clickButtonPost");
        $x(POST_BUTTON).click();
        return this;
    }

    @Step("Is post exist {searchText}")
    public boolean isPostExist(String searchText) {
        log.info("Method: isPostExist , {}", searchText);
        String actualText = $x(String.format(PATH_TO_POST, searchText)).getText();
        return actualText.equals(searchText);
    }

    @Step("Click to button delete {partOfPost}")
    public void clickToButtonDelete(String partOfPost) {
        log.info("Method: clickToButtonDelete , {}", partOfPost);
        $x(String.format(MENU_OF_POST, partOfPost)).click();
        $x(DELETE_BUTTON).click();
    }
}
