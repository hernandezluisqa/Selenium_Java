package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;

public class Hooks {

    public static WebDriver driver;

    @Before //Inicializamos el navegador en modo headless
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // headless moderno
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) { //Si el escenario falla, tomamos una captura de pantalla y la adjuntamos al reporte
            scenario.log("Scenario failed. Taking screenshot...");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); /**Desde aqui para copiar la imagen a una carpeta*/
            try { FileUtils.copyFile(screenshotFile, new File("target/screenshots/" + scenario.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            } /**Hasta aqui*/

            scenario.attach(screenshot, "image/png", "screenshot of the error");
        }
        driver.quit(); //Cerramos el navegador
    }

}
