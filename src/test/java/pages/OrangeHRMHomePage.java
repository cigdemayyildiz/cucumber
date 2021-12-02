package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {

    public OrangeHRMHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "menu_dashboard_index")
    WebElement dashboardButton;

    public String getDashboardText(){
        return dashboardButton.getText();
    }

}
