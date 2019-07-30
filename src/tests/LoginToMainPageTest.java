package tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginToMainPageTest {
    private WebDriver driver;
    private LoginPage driverLogin;
    private MainPage driverMain;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    /**
     * Given I am at the Login Page, I should see the following elements:
     * Login Page Title
     * Login Page Subheader
     * Username Label
     * Username Field
     * Password Label
     * Password Field
     * Login button
     */
    @Test(priority=0)
    public void initialLoginPageDisplay(){
        driverLogin = new LoginPage(driver);

        String loginPageTitle = driverLogin.getLoginPageTitle();
        //assert login page title text
        Assert.assertEquals(loginPageTitle, "Login Page");

        String loginPageSubheader = driverLogin.getLoginPageSubheader();
        //assert login page subheader text
        Assert.assertEquals(loginPageSubheader, "This is where you can log into the secure area. " +
                "Enter tomsmith for the username and SuperSecretPassword! for the password. " +
                "If the information is wrong you should see error messages.");

        WebElement username = driverLogin.getUsernameElement();
        //assert username field is displayed
        Assert.assertTrue(username.isDisplayed());

        String usernameLabel = driverLogin.getUsernameLabel();
        // assert username label is "Username"
        Assert.assertEquals(usernameLabel, "Username");

        WebElement password = driverLogin.getPasswordElement();
        //assert password field is displayed
        Assert.assertTrue(password.isDisplayed());

        String passwordLabel = driverLogin.getPasswordLabel();
        //assert password label is "Password"
        Assert.assertEquals(passwordLabel, "Password");

        WebElement loginButton = driverLogin.getLoginButtonElement();
        //assert login button is displayed
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @AfterClass
    public void quit() {
        driver.close();
    }
}