package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    /**
     * WebElements at /login
     */
    @FindBy(css = "h2")
    private WebElement loginPageTitle;

    @FindBy(css = "h4.subheader")
    private WebElement loginPageSubheader;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(css = "label[for='username']")
    private WebElement usernameLabel;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "label[for='password']")
    private WebElement passwordLabel;

    @FindBy(className = "radius")
    private WebElement loginButton;

    @FindBy(css = "#flash.flash.error")
    private WebElement flashError;

    @FindBy(css = "#flash.flash.success")
    private WebElement flashSuccess;

    @FindBy(className = "close")
    private WebElement flashClose;

    private static final String url = "https://the-internet.herokuapp.com/login";

    /**
     * Webdriver for login page
     * @param driver for webdriver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Navigate to page url
     */
    public void openPage() {
        super.openPage(url);
    }

    /**
     * Get login page title
     * @return String
     */
    public String getLoginPageTitle() {
        return loginPageTitle.getText();
    }

    /**
     * Get login page subheader
     * @return String
     */
    public String getLoginPageSubheader() {
        return loginPageSubheader.getText();
    }

    /**
     * Get username
     * @return WebElement
     */
    public WebElement getUsernameElement() {
        return username;
    }

    /**
     * Get username label
     * @return String
     */
    public String getUsernameLabel() {
        return usernameLabel.getText();
    }

    /**
     * Get password
     * @return WebElement
     */
    public WebElement getPasswordElement() {
        return password;
    }

    /**
     * Get login button
     * @return WebElement
     */
    public WebElement getLoginButtonElement() {
        return loginButton;
    }

    /**
     * Get password label
     * @return String
     */
    public String getPasswordLabel() {
        return passwordLabel.getText();
    }

    /**
     * Enter username
     * @param strUsername - username string
     */
    private void enterUsername(String strUsername) {
        username.sendKeys(strUsername);
    }

    /**
     * Enter password
     * @param strPassword - password string
     */
    private void enterPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    /**
     * Click login button
     */
    private void clickLogin() {
        loginButton.click();
    }

    /**
     * Login with credentials
     * @param strUsername - username string
     * @param strPassword - password string
     */
    public void loginWithCreds(String strUsername, String strPassword) {
        username.clear();
        password.clear();
        this.enterUsername(strUsername);
        this.enterPassword(strPassword);
        this.clickLogin();
    }

    /**
     * Get flash success message text
     * @return String
     */
    public String getFlashSuccessMsg() {
        return flashSuccess.getText();
    }

    /**
     * Get flash error message text
     * @return String
     */
    public String getFlashErrorMsg() {
        return flashError.getText();
    }
}
