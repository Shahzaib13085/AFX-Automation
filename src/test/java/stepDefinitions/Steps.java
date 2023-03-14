package stepDefinitions;
import Utilities.DOMMethods;
import Utilities.baseclassdriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class Steps {
    baseclassdriver sgp;
    public WebDriver driver = sgp.getDriver();
    DOMMethods DomMethods = new DOMMethods(driver);
    String text;

    @Given("User Launch {string} Browser")
    public void user_launch_browser(String browser) throws IOException {
        DomMethods.getvaluesfromconfigfile("AFXTesting");
    }
    @When("User opens URL")
    public void user_opens_url() throws IOException {
        DomMethods.openURL();

    }

    @And("User should be navigated to {string}")
    public void user_should_be_navigated_to(String string) {

    }


    @When("User enters {string} in {string} field")
    public void     user_enters_in_field(String string, String string2) throws InterruptedException, IOException {
        DomMethods.enterText(string, string2, "AFXLOGIN");
    }

    @And("User enters AFXUsername in {string} field")
    public void user_enters_afx_username_in_field(String string) throws InterruptedException {
        DomMethods.enterText("IRFAN1", string, "AFXLOGIN");
    }

    @And("User clicks {string}")
    public void user_clicks(String button) {
        DomMethods.clickbuttonDOM(button,"AFXLOGIN");
    }

    @And("User clicks on {string} and wait for {string} to appear")
    public void user_clicks_on_and_wait_for_to_appear(String string, String string2) {
        DomMethods.clickondropdown(string,"AFXLOGIN", string2);
    }


    @And("User gets data from {string}")
    public void user_gets_data_from(String string) {
      text  =  DomMethods.getdatafromlocator(string,"AFXLOGIN");
    }

    @And("User sends data into {string} input field")
    public void user_sends_data_into_input_field(String string) throws InterruptedException {
        DomMethods.sendtext(string,"AFXLOGIN");
    }

    @And("User assert toast message {string} from {string}")
    public void user_assert_toast_message_from(String string, String string2) {
        DomMethods.assertanymessage(string);
    }







}
