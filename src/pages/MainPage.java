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
    WebElement mainPageTitle;

    @FindBy(css="h4.subheader")
    WebElement mainPageSubTitle;

    @FindBy(className="button secondary radius")
    private WebElement logoutButton;

    @FindBy(css="#flash.flash.error")
    WebElement flashError;

    @FindBy(css="#flash.flash.success")
    WebElement flashSuccess;

    @FindBy(className="close")
    WebElement flashClose;

    /**
     * webdriver for main page
     * @param driver for Webdriver
     */
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * click logout button
     */
    public void clickLogout(){
        logoutButton.click();
    }
}
