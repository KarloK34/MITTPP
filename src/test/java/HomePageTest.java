import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.AssertJUnit.assertTrue;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Bypass CORS issues
        driver = new ChromeDriver(options);
        driver.get("https://nk-osijek.hr/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testHomePageTitle() {
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, "Nogometni klub Osijek");
    }

    @Test
    public void testVijestiPageTitle(){
        VijestiPage vijestiPage = homePage.clickPogledajVise();
        String title = vijestiPage.getTitle();
        System.out.println(vijestiPage.getTitle());
        Assert.assertEquals(title, "Vijesti - Nogometni klub Osijek");
    }

    @Test
    public void testSocialLinksArePresent() {
        assertTrue("Social links should be present on the page", homePage.areSocialLinksPresent());
    }
    @Test
    public void testClickOpusGlobalImage() {
        driver.manage().window().maximize();
        homePage.clickOpusGlobalImage();
        String currentUrl = homePage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("opusglobal"), "Opus Global page should open");
    }

    @Test
    public void testPogledajViseNavigation() {
        homePage.clickPogledajVise();
        String currentUrl = homePage.getCurrentUrl();
        System.out.println("Navigated to: " + currentUrl);
        Assert.assertTrue(currentUrl.endsWith("/vijesti/"), "Navigation failed! Expected URL to end with /vijesti/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
