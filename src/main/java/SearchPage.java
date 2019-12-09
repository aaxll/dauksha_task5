import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private WebDriver driver;
    @FindBy(css = "input[name=\"q\"]")
    private WebElement searchBox;
    @FindBy(css = "#search_form button")
    private WebElement simpleSearchBtn;
    @FindBy(css = "div[class=\"px-2\"]>div>h3")
    private WebElement searchResultsCount;

    public SearchPage setSearchRequest (String value) {
        searchBox.sendKeys(value);
        return this;
    }

    public SearchPage clickSimpleSearchBtn(){
        simpleSearchBtn.click();
        return new SearchPage(driver);
    }

    public SearchPage showSearchResultsCount(){
        System.out.println(searchResultsCount.getText());
        return new SearchPage(driver);
    }

    public String getSearchResultsCount(){
       return searchResultsCount.getText();
    }

    public SearchPage sendSearchRequest(String request){
        this.setSearchRequest(request);
        this.clickSimpleSearchBtn();
        return new SearchPage(driver);
    }
}
