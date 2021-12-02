package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {

    public GoogleSearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='topstuff']//p[@role='heading']")
    private WebElement noResults;

   public String getNoResultsText(){
       return noResults.getText();
   }
}
