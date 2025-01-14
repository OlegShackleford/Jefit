package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class BlogPageTest extends BaseTest {

    public String testData = "How Many Days Should You Strength Train? Optimize Your Routine";

    @Test(testName = "Check popular post",description = "")
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
        assertEquals(blogPage.getPopularPost(),
                testData,
                "This post is not in the top");
    }
}
