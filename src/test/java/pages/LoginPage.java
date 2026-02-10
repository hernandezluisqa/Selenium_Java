package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    String titleText = "//h1[text()='Login']";
    String usernameInput = "//input[@id='userName']";
    String passwordInput = "//input[@id='password']";
    String loginButton = "//button[@id='login']";
    String newUserButton = "//button[@id='newUser']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyOnLoginPage() {
        Find(titleText);
    }

    public void fillForm(String username, String password) {
        write(usernameInput, username);
        write(passwordInput, password);
    }

    public void clickLoginButton() {
        forceClick(loginButton);
        //clickElement(loginButton);
    }

    public void clickNewUserButton() {
        clickElement(newUserButton);
    }
}
