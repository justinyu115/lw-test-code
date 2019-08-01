package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class TestLoginFailureToMainPage extends BaseTest {
    private WebDriver driver;
    private LoginPage driverLogin;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
        super.setup(browser);
        driver = super.getDriver();
        driverLogin = new LoginPage(driver);
        driverLogin.openPage();
    }

    /*
     * When I login with a wrong username and password, wrong username, or wrong password:
     * username - "invalidUsername"
     * password - "SuperSecretPassword!"
     * Then I should see a flash error message
     */
    @Test(priority = 1, dataProvider = "credentials", description = "Login failures")
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

    //close browser and disconnect
    @AfterTest
    public void cleanup() {
        super.cleanup();
    }

    //test credentials data
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
