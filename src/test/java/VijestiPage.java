import org.openqa.selenium.WebDriver;

public class VijestiPage {
    private WebDriver driver;


    public VijestiPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){return driver.getTitle();}
}

