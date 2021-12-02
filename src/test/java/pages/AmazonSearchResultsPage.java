package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonSearchResultsPage {

    public AmazonSearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(tagName = "a")
    private List<WebElement> resultsLinks;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    private WebElement resultsText;

    public int getResultsCount(){
        return resultsLinks.size();
    }

    public int getResultNumber(){
        String [] resultsArray = resultsText.getText().split(" ");
        String resultsNum = resultsArray[3].replace(",","");
        return Integer.parseInt(resultsNum);
    }
}
