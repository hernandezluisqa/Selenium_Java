package pages;

// Importaciones necesarias
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    /**
     * Metodo para navegar a una URL específica.
     * @url La URL a la que se desea navegar.
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Espera hasta que la URL actual del navegador contenga la cadena especificada.
     *
     * Este método utiliza WebDriverWait con ExpectedConditions.urlContains
     * para sincronizar la prueba y evitar fallos por carga lenta.
     *
     * @param url Subcadena que debe estar presente en la URL actual.
     */
    public void waitForUrlContains(String url) {
        wait.until(ExpectedConditions.urlContains(url));
    }

    /**
     * Forzar click en un elemento utilizando JavaScript.
     * @param locator El locator XPath del elemento al que se le quiere hacer click.
     */
    public void forceClick(String locator) {
        WebElement element = Find(locator);

        // Scroll hasta el elemento
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Forzar el clic con JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
     * esperando a que esté presentente en el DOM
     * @param locator El locator XPath del elemento a encontrar.
     * @return El WebElement encontrado.
     */
    protected WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    /**
     * Encuentra y devuelve una lista de WebElements en la página utilizando un locator XPath,
     * @param locator El locator XPath de los elementos a encontrar.
     * @return Una lista de WebElements encontrados.
     */
    protected List<WebElement> FindAll(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    /**
     * Realiza un clic en un elemento ubicado por su locator XPath.
     * @param locator El locator XPath del elemento al que se le quiere hacer click.
     */
    public void clickElement(String locator) {
        Find(locator).click();
    }

    /**
     * Escribe texto en un campo de entrada ubicado por su locator XPath.
     * Primero limpia el campo antes de enviar las teclas.
     * @param locator El locator XPath del campo de entrada.
     * @param keysToSend El texto que se desea escribir en el campo.
     */
    public void write(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    /**
     * Selecciona una opción de un dropdown (elemento <select>) por su valor.
     * @param locator El locator XPath del elemento <select>.
     * @param value El valor de la opción que se desea seleccionar.
     */
    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }

    /**
     * Selecciona una opción de un dropdown (elemento <select>) por su index.
     * @param locator El locator XPath del elemento <select>.
     * @param index El índice de la opción que se desea seleccionar (comienza en 0).
     */
    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    /**
     * Devuelve el número de opciones disponibles en un dropdown (elemento <select>).
     * @param locator El locator XPath del elemento <select>.
     * @return El número de opciones disponibles en el dropdown.
     */
    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

    /**
     * Devuelve una lista de los textos de las opciones disponibles en un dropdown (elemento <select>).
     * @param locator El locator XPath del elemento <select>.
     * @return Una lista de los textos de las opciones disponibles en el dropdown.
     */
    public List<String> dropdownListText(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.stream().map(WebElement::getText).toList();
    }

    /**
     * Devuelve una lista de los textos de los elementos encontrados por el locator XPath.
     * @param locator El locator XPath de los elementos a encontrar.
     * @return Una lista de los textos de los elementos encontrados.
     */
    public List<String> getOptionsText(String locator){
        List<WebElement> options = FindAll(locator);
        List<String> textOptions = options.stream().map(WebElement::getText).toList();

        return textOptions;
    }

}
