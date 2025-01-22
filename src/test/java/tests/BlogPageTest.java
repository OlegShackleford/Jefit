package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import static org.testng.Assert.assertEquals;

public class BlogPageTest extends BaseTest {

    public String testData = "How Many Days Should You Strength Train? Optimize Your Routine";

    @Test(testName = "Check popular post",
            description = "Checking that the most popular article on a blog page matches the expected title.")
    @Feature("Blog")
    @Description("Select most popular post")
    @Story("A QA engineer checks the display of the most popular article on a blog page")
    @Severity(SeverityLevel.MINOR)
    @Owner("Olegsey")
    public void checkPopularPost() {
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
