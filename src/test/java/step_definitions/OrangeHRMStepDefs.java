package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMLoginPage;

public class OrangeHRMStepDefs {

    WebDriver driver;
    OrangeHRMLoginPage orangeHRMLoginPage;
    OrangeHRMHomePage orangeHRMHomePage;

    @Given("I am on OrangeHRM login page")
    public void i_am_on_orange_hrm_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
    @When("I fill up all info for login")
    public void i_fill_up_all_info_for_login() {
        orangeHRMLoginPage = new OrangeHRMLoginPage(driver);
        orangeHRMLoginPage.login("Admin","admin123");
    }
    @Then("I see dashboard page")
    public void i_see_dashboard_page() {
        orangeHRMHomePage = new OrangeHRMHomePage(driver);
        Assert.assertTrue(orangeHRMHomePage.getDashboardText().equals("Dashboard"));
    }
}
