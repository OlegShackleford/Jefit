package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

@Log4j2
public class DiscoverPageTest extends BaseTest {

    @Test(testName = "Create new post")
    @Description("Check create new post at page Discover. And Delete post after assert")
    public void checkCreateNewPost() {
        log.info("Method: checkCreateNewPost");
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
        Assert.assertTrue(discoverPage.
                isPostExist("This is text for testing method checkCreateNewPost")
                ,"Cant find this post");
        discoverPage.clickToButtonDelete("This is text");
    }
}
