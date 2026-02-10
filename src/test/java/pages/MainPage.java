package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage{

    private String loginButton = "//li/*[text()='Login']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToMainPage(String url) {
        navigateTo(url);
    }

    public void clickLoginButton() {
        forceClick(loginButton);
    }
}
