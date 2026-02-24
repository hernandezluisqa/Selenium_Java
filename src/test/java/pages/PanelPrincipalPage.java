package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PanelPrincipalPage extends BasePage{

    String title = "//h2[text()='Panel Principal']";
    String username = "//span[@id='user-name']";
    String logoutButton = "//button[@id='logout-btn']";
    String modalLogoutConfirmButton = "//button[contains(@id, 'modal-confirm')]";
    String ModalLogoutCancelButton ="//button[contains(@id, 'modal-cancel')]";
    String titleModalLogout = "//div[contains(@class, 'modal-header')]/h3";
    String bodyModalLogout = "//div[contains(@class, 'modal-body')]/p";
    String toastMessage = "//div[@id='toast-container']";
    String accountBalance = "//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'account-card')]//span[contains(@class,'balance-value')]";
    String amountBalance = "//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'account-card')]//span[contains(@class,'balance-amount')]";
    String toggleBalanceButton = "//span[contains(text(),'%s')]/ancestor::div[contains(@class, 'account-card')]//button[contains(@class,'toggle-balance')]";


    public PanelPrincipalPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Obtiene el XPath del saldo disponible de una cuenta específica
     * mostrada en el panel principal.
     *
     * @param accountName nombre visible de la cuenta (por ejemplo: "Cuenta Corriente").
     * @return XPath del elemento que contiene el saldo disponible
     *         asociado a la cuenta indicada.
     */
    private String getAccountBalance(String accountName) {
        return String.format(accountBalance, accountName);
    }

    private String getAmountBalance(String accountName) {
        return String.format(amountBalance, accountName);
    }

    private String getToggleBalanceButton(String accountName) {
        return String.format(toggleBalanceButton, accountName);
    }

    public String getDisplayedUsername() {
        return Find(username).getText();
    }

    public void verifyOnProfilePage() {
        Find(title).isDisplayed();
        Find(username).isDisplayed();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.invisibilityOf(Find(toastMessage)));
        clickElement(logoutButton);
    }

    public void clickConfirmLogout() {
        clickElement(modalLogoutConfirmButton);
    }

    public void clickOnToggleBalanceButton(String accountName){
        clickElement(getToggleBalanceButton(accountName));
    }

    public boolean isBalanceHidden(String accountName) {
        boolean isAvailable = Find(getAccountBalance(accountName)).isDisplayed();
        boolean isHidden = Find(getAmountBalance(accountName)).getAttribute("class").contains("hidden-balance");
        boolean isVisible = Find(getAccountBalance(accountName)).getCssValue("filter").contains("blur(8px)");

        if(isHidden && isVisible && isAvailable){
            return true;
        }
        else{
         return false;
        }
    }
}
