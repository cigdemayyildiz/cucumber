package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;

public class AmazonStepDefs {
    WebDriver driver;
    AmazonHomePage amazonHomePage;
    AmazonSearchResultsPage amazonSearchResultsPage;

    @When("I navigate to Amazon home page")
    public void i_navigate_to_amazon_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
    }
    @And("I search for iphone 13 case")
    public void i_search_for_iphone_case() {
        amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.search("iphone 13 case");
    }
    @Then("I should get more than {int} result")
    public void i_should_get_more_than_result(Integer resultCount) {
        amazonSearchResultsPage = new AmazonSearchResultsPage(driver);
        Assert.assertTrue(amazonSearchResultsPage.getResultsCount()>resultCount);
    }
    @And("I validate the search result number")
    public void i_validate_the_search_result_number() {
        amazonSearchResultsPage = new AmazonSearchResultsPage(driver);
        Assert.assertEquals(amazonSearchResultsPage.getResultNumber(), 20000);
    }
}
