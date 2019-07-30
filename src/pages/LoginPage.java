package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * WebElements at /login
     */
    private WebDriver driver;

    @FindBy(css="h2")
    private WebElement loginPageTitle;

    @FindBy(css="h4.subheader")
    private WebElement loginPageSubheader;

    @FindBy(name="username")
    private WebElement username;

    @FindBy(css="label[for='username']")
    private WebElement usernameLabel;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(css="label[for='password']")
    private WebElement passwordLabel;

    @FindBy(className="radius")
    private WebElement loginButton;

    @FindBy(css="#flash.flash.error")
    WebElement flashError;

    @FindBy(css="#flash.flash.success")
    WebElement flashSuccess;

    @FindBy(className="close")
    WebElement flashClose;

    /**
     * webdriver for login page
     * @param driver for webdriver
     */
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * get login page title
     * @return String
     */
    public String getLoginPageTitle(){
        return loginPageTitle.getText();
    }

    /**
     * get login page subheader
     * @return String
     */
    public String getLoginPageSubheader(){
        return loginPageSubheader.getText();
    }

    /**
     * get username
     * @return WebElement
     */
    public WebElement getUsernameElement(){
        return username;
    }

    /**
     * get username label
     * @return String
     */
    public String getUsernameLabel(){
        return usernameLabel.getText();
    }

    /**
     * get password
     * @return WebElement
     */
    public WebElement getPasswordElement(){
        return password;
    }

    public WebElement getLoginButtonElement(){
        return loginButton;
    }

    /**
     * get password label
     * @return String
     */
    public String getPasswordLabel(){
        return passwordLabel.getText();
    }

    /**
     * enter username
     * @param strUsername - username string
     */
    private void enterUsername(String strUsername){
        username.sendKeys(strUsername);
    }

    /**
     * enter password
     * @param strPassword - password string
     */
    private void enterPassword(String strPassword){
        password.sendKeys(strPassword);
    }

    /**
     * click login button
     */
    private void clickLogin(){
        loginButton.click();
    }

    /**
     * login with credentials
     * @param strUsername - username string
     * @param strPassword - password string
     */
    public void loginWithCreds(String strUsername, String strPassword){
        this.enterUsername(strUsername);
        this.enterPassword(strPassword);
        this.clickLogin();
    }
}


