import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClassTest {
    private WebDriver driver;
    private MainPage mainPage;
    private AboutPage aboutPage;
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/testing/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        aboutPage = new AboutPage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    @DisplayName("Main Page: Footer: Sing Up with wrong email")
    public void registerUserFooterTest(){
        driver.get("https://github.com/");
        mainPage.registerUserFooter("dfsdfsdf33c2","sdadad.com","Pass2v5g9");
        String emailErrorText = mainPage.getErrorEmailText();
        assertEquals("Email is invalid or already taken",emailErrorText);

    }

    @Test
    @DisplayName("About Page: social buttons")
    public void socialButtontsTest(){
        driver.get("https://github.com/");
        mainPage.clickAboutPageLink();

        aboutPage.clickFollowUsOnTwitterBtn();
        assertEquals("https://www.twitter.com/github",driver.getCurrentUrl());

        driver.navigate().back();

        aboutPage.clickSocialBtnTwitter();
        assertEquals("https://twitter.com/github",driver.getCurrentUrl());

        driver.navigate().back();

        aboutPage.clickSocialBtnFacebook();
        assertEquals("https://www.facebook.com/GitHub",driver.getCurrentUrl());

        driver.navigate().back();

        aboutPage.clickSocialBtnYoutube();
        assertEquals("https://www.youtube.com/github",driver.getCurrentUrl());

        driver.navigate().back();

        aboutPage.clickSocialBtnLinkedIn();
        assertEquals("https://www.linkedin.com/company/github",driver.getCurrentUrl());

        driver.navigate().back();

        aboutPage.clickSocialBtnGithub();
        assertEquals("https://github.com/github",driver.getCurrentUrl());

    }

    @Test
    @DisplayName("Search Page: Simple search")
    public void simpleSearchTest(){
        driver.get("https://github.com/search");
        searchPage.sendSearchRequest("selenium");
        assertEquals("https://github.com/search?utf8=%E2%9C%93&q=selenium&ref=simplesearch",driver.getCurrentUrl());

    }

    @AfterEach
    public void quitDriver(){
        driver.quit();
    }

}
