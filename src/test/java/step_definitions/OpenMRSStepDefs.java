package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.OpenMRSHomePage;
import utils.Driver;

import java.util.Map;

public class OpenMRSStepDefs {

    WebDriver driver;
    OpenMRSHomePage openMRSHomePage;

    @Given("I'm logged in to OpenMRS with following credentials:")
    public void i_m_logged_in_to_open_mrs_with_following_credentials(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> userNamePasswordMap = dataTable.asMap();
        String username = userNamePasswordMap.get("username");
        String password = userNamePasswordMap.get("password");
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);
        driver = Driver.getDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        openMRSHomePage = new OpenMRSHomePage();
        openMRSHomePage.signIn(username, password);
    }

    @When("I register a new patient with following info:")
    public void registerNewPatient(io.cucumber.datatable.DataTable dataTable){
        Map<String,String> patientInfoMap = dataTable.asMap();
        String givenName = patientInfoMap.get("GivenName");
        String familyName = patientInfoMap.get("FamilyName");
        System.out.println("Given Name: "+givenName);
        System.out.println("Family Name: "+familyName);

    }

    @Given("I'm logged in to OpenMRS with {string} and {string}")
    public void i_m_logged_in_to_open_mrs_with_and(String username, String password) {

    }

    @When("I register a new patient with {string}, {string}, {string}, {int}, {string}, {int}, {string} and {int}")
    public void i_register_a_new_patient_with_and(String name, String lastName, String gender, Integer birthDay,
                                                  String birthMonth, Integer birthYear, String address, Integer phoneNumber){

        System.out.println("First Name: "+name);
        System.out.println("Last Name: "+lastName);
        System.out.println("Phone Number: "+phoneNumber);

    }

}
