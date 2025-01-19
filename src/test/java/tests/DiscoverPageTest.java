package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class DiscoverPageTest extends BaseTest {

    public String textForPost = "This is text for testing method checkCreateNewPost";

    @Test(testName = "Create new post",
            description = "Creating a post. Comparison by string. And deletion based on partial match of post text")
    @Feature("Discover")
    @Severity(SeverityLevel.NORMAL)
    @Description("Check create new post at page Discover. And Delete post after assert")
    @Story("The QA engineer checks for the presence of a previously created post and its deletion.")
    @Owner("Olegsey")
    public void checkCreateNewPost() {
        loginStep.allLoginStep(user, password);
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
