package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage {
    private static final int TIMEOUT = 5;
    private WebDriver driver;

    /**
     * BasePage constructor to initialize PageFactory
     * @param driver - WebDriver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    /**
     * Navigate to url page
     */
    protected void openPage(String url) {
        driver.navigate().to(url);
    }
}
