package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class BlogPage {
    private final static String LINK = "https://www.jefit.com/blog/";
    private final static String POPULAR_POST = "//div[@class ='ss-popular-posts-widget ss-clearfix" +
            " ss-circle-thumb ss-thumbnail-thumb']/descendant::a[@data-ranking = '1. ']";
    private final static String TITLE = "//h2[@class = 'widget-title' and text() = 'Popular Posts']";

    @Step("Open page")
    public BlogPage openPage() {
        log.info("Method: openPage");
        open(LINK);
        return this;
    }

    @Step("Is page opened")
    public BlogPage isPageOpened() {
        log.info("Method: is pageOpened");
        $x(TITLE).shouldBe(Condition.visible);
        return this;
    }

    @Step("Get popular post")
    public String getPopularPost() {
        log.info("Method: getPopularPost");
        return $x(POPULAR_POST).getText();
    }
}
