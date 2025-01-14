package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.assertTrue;

public class DiscoverPageTest extends BaseTest {

    public String textForPost = "This is text for testing method checkCreateNewPost";

    @Test(testName = "Create new post",description = "")
    @Description("Check create new post at page Discover. And Delete post after assert")
    public void checkCreateNewPost() {
        loginPage
                .openPage()
                .clickToButtonLogin()
                .login(user,password);

        discoverPage
                .openPage()
                .clickButtonCreatePost()
                .createNewPost(textForPost)
                .clickButtonPost();
        assertTrue(discoverPage.isPostExist("This is text for testing method checkCreateNewPost"),
                "Cant find this post");
        discoverPage.clickToButtonDelete("This is text");
    }
}
