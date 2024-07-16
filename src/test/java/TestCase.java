import UI.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import UI.pageObject.HomePage;

public class TestCase extends BaseClass {
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {
        setUpDriver(browser);
        getUrl();
        driver = getDriver();
    }

    // Data provider for the test plan
    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][] {
                {"Euro", "Thailand", 2 , "5GB", "30 DAYS", "Data only", "€9.39"},
        };
    }

    @Test(dataProvider = "testData")
    public void validateSimDataPlan(String currency, String country, int plan, String dataPlan, String validity, String planType, String amount) {
        HomePage homePage = new HomePage(driver);
        homePage.selectCurrency(currency);
        homePage.selectCountry(country);

        //Verify Plan details
        Assert.assertEquals(homePage.getPlanCountries(plan), country);
        Assert.assertEquals(homePage.getPlanData(), dataPlan);
        Assert.assertEquals(homePage.getPlanValidity(), validity);
        Assert.assertEquals(homePage.getPlanType(plan), planType);
        Assert.assertEquals(homePage.getPlanAmount(plan), amount);

    }

    @AfterTest
    public void tearDown() {
        // Close the browser once tests are completed
        tearDownBrowser();
    }

}
