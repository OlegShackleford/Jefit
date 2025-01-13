package tests;

import io.qameta.allure.Description;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;


public class DiscoverPageTest extends BaseTest {

    @Test(testName = "Create new post")
    @Description("Check create new post at page Discover. And Delete post after assert")
    public void checkCreateNewPost() {
        String textForPost = "This is text for testing method checkCreateNewPost";
        loginPage
                .openPage()
                .clickToButtonLogin()
                .login(user,password);

        discoverPage
                .openPage()
                .clickButtonCreatePost()
                .createNewPost(textForPost)
                .clickButtonPost();

        Assert.assertTrue(discoverPage.isPostExist("This is text for testing method checkCreateNewPost"),
                "Cant find this post");
        discoverPage.clickToButtonDelete("This is text");
    }
}
