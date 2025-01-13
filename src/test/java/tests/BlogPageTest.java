package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class BlogPageTest extends BaseTest {

    @Test(testName = "Check popular post")
    @Description("Select most popular post")
    public void checkPopularPost(){
        loginPage
                .openPage()
                .isPageOpened()
                .clickToCommunity()
                .clickToBlog();
        blogPage
                .openPage()
                .isPageOpened();
        Assert.assertEquals(blogPage.getPopularPost(),
                "How Many Days Should You Strength Train? Optimize Your Routine",
                "This post is not in the top");
    }
}
