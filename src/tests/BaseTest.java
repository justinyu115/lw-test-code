package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;

    /**
     * Setup browser with cross browser testing
     * @param browser - choose browser type
     */
    public void setup(String browser) {
        //test with firefox browser
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
            driver = new FirefoxDriver();
            //test with chrome browser
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Cleanup after test
     */
    public void cleanup() {
        if(null != driver) {
            driver.close();
        }
    }

    /**
     * Get driver instance
     * @return Webdriver
     */
    public WebDriver getDriver() {
        return driver;
    }
}
