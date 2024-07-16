package UI.pageLocator;

import org.openqa.selenium.By;

public class HomePageLocatorClass {

    //Locators for Web elements in HomePage
    public static By language_Currency_Button = By.xpath("//*[text()[contains(.,'EUR')]]");
    public static By currency_Container_Euro = By.xpath("//*[text()='Euro']");

    public static By dynamicXPathForCountry(String elementName) {
        return By.xpath("//*[text()='" + elementName + "']");
    }

    public static By dynamicXPathForPlanAccess(String elementName, int num) { return By.xpath("//*[text()='"+ elementName + "'])["+ num +"]"); }

    //Locators for Web Elements in Data Plan Page
    public static By dynamicXPathForPlanCountries(int num) {
        return By.xpath("(//p[@class='underline text-right cursor-pointer'])["+ num +"]");
    }

    public static By planData = By.xpath("(//p[@class='bg-[#F8F8FF] rounded-[6px] p-2'])[3]");

    public static By planValidity = By.xpath("(//p[@class='bg-[#F8F8FF] rounded-[6px] p-2'])[4]");

    public static By dynamicXPathForPlanType(int num) {
        return By.xpath("(//*[text()='Data only'])["+ num +"]");
    }

    public static By dynamicXPathForPlanAmount(int num) {
        return By.xpath("(//p[@class='text-[24px] font-bold mt-0 mb-2'])["+ num +"]");
    }
}
