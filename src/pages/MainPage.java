package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    /**
     * WebElements at /login
     */
    private WebDriver driver;

    @FindBy(css="h2")
    private WebElement mainPageTitle;

    @FindBy(css="h4.subheader")
    private WebElement mainPageSubheader;

    @FindBy(css="a.button.secondary.radius")
    private WebElement logoutButton;

    @FindBy(css="#flash.flash.error")
    private WebElement flashError;

    @FindBy(css="#flash.flash.success")
    private WebElement flashSuccess;

    @FindBy(className="close")
    private WebElement flashClose;

    /**
     * webdriver for main page
     * @param driver for Webdriver
     */
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * get main page title
     * @return String
     */
    public String getMainPageTitle(){
        return mainPageTitle.getText();
    }

    /**
     * get main page subheader
     * @return String
     */
    public String getMainPageSubheader(){
        return mainPageSubheader.getText();
    }

    /**
     * click logout button
     */
    public void clickLogout(){
        logoutButton.click();
    }

    /**
     * get logout button
     * @return WebElement
     */
    public WebElement getLogoutButtonElement(){
        return logoutButton;
    }

    /**
     * Get flash success message text
     * @return String
     */
    public String getFlashSuccessMsg(){
        return flashSuccess.getText();
    }

    /**
     * Get flash success element
     * @return WebElement
     */
    public WebElement getFlashSuccessElement(){
        return flashSuccess;
    }

    /**
     * Get flash error message text
     * @return String
     */
    public String getFlashErrorMsg(){
        return flashError.getText();
    }

    /**
     * Get flash error element
     * @return WebElement
     */
    public WebElement getFlashErrorElement(){
        return flashError;
    }

    public void clickCloseFlashMsg(){
        flashClose.click();
    }
}
