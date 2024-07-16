package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {
    private WebDriver driver ;
    private Properties properties = new Properties();

    public void setUpDriver(String browser) {
        String driverPath = System.getProperty("user.dir") + "/drivers/";

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void getUrl() {
        loadProperties();
        String url = properties.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void tearDownBrowser() {
        driver.quit();
    }

    private void loadProperties() {
        try (InputStream input = new FileInputStream("src/main/resources/login.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
