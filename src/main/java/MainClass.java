import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
    static  WebDriver driver;
    public static void main(String[] args) {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:/testing/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();


        MainPage mainPage = new MainPage(driver);
        AboutPage aboutPage = new AboutPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        //About Page: social buttons
        driver.get("https://github.com/");

        mainPage.clickAboutPageLink();

        aboutPage.clickFollowUsOnTwitterBtn()
                .showCurrentUrl()
                .goBack();

        aboutPage.clickSocialBtnTwitter()
                .showCurrentUrl()
                .goBack();

        aboutPage.clickSocialBtnFacebook()
                .showCurrentUrl()
                .goBack();

        aboutPage.clickSocialBtnYoutube()
                .showCurrentUrl()
                .goBack();

        aboutPage.clickSocialBtnLinkedIn()
                .showCurrentUrl()
                .goBack();

        aboutPage.clickSocialBtnGithub()
                .showCurrentUrl()
                .goBack();


        //Main Page: Footer: Sing Up with wrong email
        driver.get("https://github.com/");
        mainPage.registerUserFooter("User2346i","asdddad.com","Pass33v78");
                //.setUserNameFooter("User2346i")
                //.setUserEmailFooter("asdddad.com")
                //.setUserPasswordFooter("Pass33v78")
                //.clickSignUpBtnFooter();
        System.out.println("Error text: " + mainPage.getErrorEmailText());

        //Search Page: Simple search
        driver.get("https://github.com/search");
        searchPage
                .sendSearchRequest("selenium")
                .showSearchResultsCount();

        driver.quit();










    }
}
