import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By socialLinks = By.cssSelector("div.social a");
    private By pogledajViseButton = By.cssSelector("a.button.blue2[href='/vijesti/']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean areSocialLinksPresent() {
        List<WebElement> links = driver.findElements(socialLinks);
        return !links.isEmpty();
    }

    public void clickOpusGlobalImage(){
        acceptCookies();
        try {
            WebElement opusGlobalImage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img[src='/static/images/sponsors/opus_global2.svg']")));
            opusGlobalImage.click();
            System.out.println("Clicked Opus Global image.");
        } catch (Exception e) {
            System.out.println("Failed to click Opus Global image.");
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public VijestiPage clickPogledajVise() {
        driver.manage().window().maximize();
        acceptCookies();
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(pogledajViseButton));
        button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        VijestiPage vijestiPage = new VijestiPage(driver);
        return vijestiPage;
    }

    private void acceptCookies(){
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".iubenda-cs-accept-btn")));
            acceptCookiesButton.click();
            System.out.println("Cookies accepted.");
        } catch (Exception e) {
            System.out.println("Cookie accept button not visible or already accepted.");
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

