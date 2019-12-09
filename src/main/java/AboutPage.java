import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage {
    private WebDriver driver;
    private By followUsOnTwitterBtn = By.cssSelector("a[class=\"btn-mktg btn-outline-mktg\"]");
    private By socialBtnTwitter = By.cssSelector("li>a[href=\"https://twitter.com/github\"]>svg");
    private By socialBtnFacebook = By.cssSelector("li>a[href=\"https://www.facebook.com/GitHub\"]>svg");
    private By socialBtnYoutube = By.cssSelector("li>a[href=\"https://www.youtube.com/github\"]>svg");
    private By socialBtnLinkedIn = By.cssSelector("li>a[href=\"https://www.linkedin.com/company/github\"]>svg");
    private By socialBtnGithub = By.cssSelector("li>a[href=\"https://github.com/github\"]>svg");

    public AboutPage(WebDriver driver) { this.driver = driver; }

    public AboutPage goBack() {
        driver.navigate().back();
        return new  AboutPage(driver);
    }

    public AboutPage showCurrentUrl() {
        System.out.println(driver.getCurrentUrl());
        return new AboutPage(driver);
    }

    public AboutPage clickFollowUsOnTwitterBtn() {
        driver.findElement(followUsOnTwitterBtn).click();
        return  new AboutPage(driver);
    }

    public AboutPage clickSocialBtnTwitter() {
        driver.findElement(socialBtnTwitter).click();
        return  new AboutPage(driver);
    }

    public AboutPage clickSocialBtnFacebook() {
        driver.findElement(socialBtnFacebook).click();
        return  new AboutPage(driver);
    }

    public AboutPage clickSocialBtnYoutube() {
        driver.findElement(socialBtnYoutube).click();
        return  new AboutPage(driver);
    }

    public AboutPage clickSocialBtnLinkedIn() {
        driver.findElement(socialBtnLinkedIn).click();
        return  new AboutPage(driver);
    }

    public AboutPage clickSocialBtnGithub() {
        driver.findElement(socialBtnGithub).click();
        return  new AboutPage(driver);
    }

}
