package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;
import java.util.concurrent.TimeUnit;

public class LoginSuccessToMainPageTest {
    private WebDriver driver;
    private LoginPage driverLogin;
    private MainPage driverMain;

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
        //assert username label is "Username"
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

    /**
     * When I login with correct test credentials:
     * username - "tomsmith"
     * password - "SuperSecretPassword!"
     * Then I should see a success message
     */
    @Test(priority=1)
    public void logInWithCorrectCredentials(){
        driverLogin = new LoginPage(driver);

        //login with correct credentials
        driverLogin.loginWithCreds("tomsmith", "SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait until see logout button on Main Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button.secondary.radius")));

        driverMain = new MainPage(driver);
        String flashSuccess = driverMain.getFlashSuccessMsg();
        //assert login success message shown
        Assert.assertTrue(flashSuccess.contains("You logged into a secure area!"));
    }

    /**
     * Then I should see the following elements on the Main Page:
     * Main Page Title
     * Main Page Subheader
     * Logout button
     */
    @Test(priority=2)
    public void mainPageDisplay(){
        driverMain = new MainPage(driver);

        String mainPageTitle = driverMain.getMainPageTitle();
        //assert Main Page title
        Assert.assertEquals(mainPageTitle, "Secure Area");

        String mainPageSubheader = driverMain.getMainPageSubheader();
        //assert Main Page subheader
        Assert.assertEquals(mainPageSubheader, "Welcome to the Secure Area. " +
                "When you are done click logout below.");

        WebElement logoutButton = driverMain.getLogoutButtonElement();
        //assert logout button is visible
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    /**
     * When I click the logout button
     * Then I should be at the login page
     */
    @Test(priority=3)
    public void logoutMainPage(){
        driverMain = new MainPage(driver);
        //click logout
        driverMain.clickLogout();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait until see logout button on Main Page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".radius")));

        driverLogin = new LoginPage(driver);
        String flashSuccess = driverLogin.getFlashSuccessMsg();
        //assert login success message shown
        Assert.assertTrue(flashSuccess.contains("You logged out of the secure area!"));
    }

    //close browser and disconnect
    @AfterTest
    public void cleanup(){
        driver.close();
    }
}