package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginFailureToMainPageTest {
    private WebDriver driver;
    private LoginPage driverLogin;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
        //test with firefox browser
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

            //test with chrome browser
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    /**
     * When I login with a wrong username:
     * username - "invalidUsername"
     * password - "SuperSecretPassword!"
     * Then I should see a fail message
     */
    @Test(priority = 1, dataProvider = "credentials")
    public void logInWithIncorrectCredentials(String username, String password) {
        driverLogin = new LoginPage(driver);

        //login with correct credentials
        driverLogin.loginWithCreds(username, password);

        String flashError = driverLogin.getFlashErrorMsg();

        //wrong username and wrong password
        if (username.equals("invalidUsername") && password.equals("invalidPassword")) {
            Assert.assertTrue(flashError.contains("Your username is invalid!"));
            //wrong password only
        } else if (username.equals("tomsmith")) {
            Assert.assertTrue(flashError.contains("Your password is invalid!"));
            //wrong username only
        } else if (password.equals("SuperSecretPassword!")) {
            Assert.assertTrue(flashError.contains("Your username is invalid!"));
        }
    }

    @AfterTest
    protected void cleanup() {
        driver.close();
    }

    @DataProvider(name = "credentials")
    public Object[][] getDataFromDataProvider() {
        return new Object[][]
                {
                        {"invalidUsername", "invalidPassword"},
                        {"tomsmith", "invalidPassword"},
                        {"invalidUsername", "SuperSecretPassword!"}
                };
    }
}
