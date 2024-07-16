package UI.pageObject;

import org.openqa.selenium.WebDriver;
import UI.pageLocator.HomePageLocatorClass;

public class HomePage {
    WebDriver driver ;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCurrency(String currency) {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized in HomePage");
        }

        String currencySelected = driver.findElement(HomePageLocatorClass.language_Currency_Button).getText();
        if(!currencySelected.equals("Eur")) {
            driver.findElement(HomePageLocatorClass.language_Currency_Button).click();
        }
        driver.findElement(HomePageLocatorClass.currency_Container_Euro).click();
    }

    public void selectCountry(String country) {
        driver.findElement(HomePageLocatorClass.dynamicXPathForCountry(country)).click();
    }

    public String getPlanCountries(int num) {
        return driver.findElement(HomePageLocatorClass.dynamicXPathForPlanCountries(num)).getText();
    }

    public String getPlanData() {
        return driver.findElement(HomePageLocatorClass.planData).getText();
    }

    public String getPlanValidity() {
        return driver.findElement(HomePageLocatorClass.planValidity).getText();
    }

    public String getPlanType(int num) {
        return driver.findElement(HomePageLocatorClass.dynamicXPathForPlanType(num)).getText();
    }

    public String getPlanAmount(int num) {
        return driver.findElement(HomePageLocatorClass.dynamicXPathForPlanAmount(num)).getText();
    }
}
