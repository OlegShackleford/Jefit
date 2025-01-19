package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import pages.LoginPage;

@Log4j2
public class LoginStep {

    private final LoginPage loginPage;

    public LoginStep() {
        this.loginPage = new LoginPage();
    }

    @Step("Full login step with credentials: {user} , {password}")
    public void allLoginStep(String user,String password){
        log.info("Method: allLoginStep with creds: '{}' ,'{}'",user,password);
        loginPage
                .openPage()
                .isPageOpened()
                .clickToButtonLogin()
                .login(user, password);
    }
}
