import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;
    //private By aboutPageLink = By.cssSelector("li>a[data-ga-click*=\"Footer, go to about\"]");
    @FindBy(css = "li>a[data-ga-click*=\"Footer, go to about\"]")
    private WebElement aboutPageLink;
    @FindBy(css = "#user\\[login\\]-footer")
    private WebElement registrationUserLoginFooter;
    @FindBy(css = "#user\\[email\\]-footer")
    private WebElement registrationUserEmailFooter;
    @FindBy(css = "#user\\[password\\]-footer")
    private WebElement registrationUserPasswordFooter;
    @FindBy(css = "button[data-ga-click*=\"Signup, Attempt, location:teams;\"]")
    private WebElement signUpBtnFooter;
    @FindBy (css = "auto-check[src=\"/signup_check/email\"] >dl > dd[class=\"error\"]")
    private WebElement errorEmail;

    public MainPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MainPage clickAboutPageLink() {
        aboutPageLink.click();
        return new MainPage(driver);
    }

    public MainPage clickSignUpBtnFooter(){
        signUpBtnFooter.click();
        return new MainPage(driver);
    }

    public  MainPage setUserNameFooter (String value) {
        registrationUserLoginFooter.sendKeys(value);
        return this;
    }

    public  MainPage setUserEmailFooter (String value) {
        registrationUserEmailFooter.sendKeys(value);
        return this;
    }

    public  MainPage setUserPasswordFooter (String value) {
        registrationUserPasswordFooter.sendKeys(value);
        return this;
    }

    public MainPage registerUserFooter (String name, String email, String password) {
        this.setUserNameFooter(name);
        this.setUserEmailFooter(email);
        this.setUserPasswordFooter(password);
        this.clickSignUpBtnFooter();
        return new MainPage(driver);

    }

    public String getErrorEmailText (){
        return errorEmail.getText();
    }




}
