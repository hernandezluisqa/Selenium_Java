package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    String usernameInput = "//input[@id='username']";
    String passwordInput = "//input[@id='password']";
    String loginButton = "//button[@id='login-btn']";
    String errorMessage = "//div[@id='login-error']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        navigateTo("https://homebanking-demo-tests.netlify.app/");
    }

    public void verifyOnLoginPage() {
        Find(usernameInput).isDisplayed();
        Find(passwordInput).isDisplayed();
        Find(loginButton).isDisplayed();
    }

    public void fillForm(String username, String password) {
        write(usernameInput, username);
        write(passwordInput, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        return Find(errorMessage).getText();
    }
}
