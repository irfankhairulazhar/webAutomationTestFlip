package steps.swagLabs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.swagLabsPO;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class swagLabsSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private swagLabsPO swagLabs =  new swagLabsPO(driver);

    private String testData="src/test/resources/testdata/data.properties";

    private String validUsername = JavaHelpers.getPropertyValue(testData,"validUsername");

    private String validPassword = JavaHelpers.getPropertyValue(testData,"validPassword");

    private String invalidUsername1 = JavaHelpers.getPropertyValue(testData,"invalidUsername1");

    private String invalidPassword1 = JavaHelpers.getPropertyValue(testData,"invalidPassword1");

    private String invalidusername2 = JavaHelpers.getPropertyValue(testData,"invalidusername2");

    private String invalidpassword2 = JavaHelpers.getPropertyValue(testData,"invalidpassword2");


    @Given("user direct to swag labs")
    public void user_direct_to_swag_labs () throws InterruptedException {
        swagLabs.directToSwagLabs ();
    }

    @When("user on swag labs user login with valid credential")
    public void user_on_swag_labs_user_login_with_valid_credential () throws InterruptedException {
        swagLabs.inputValidUsername(validUsername);
        swagLabs.inputValidPassword(validPassword);
    }

    @And("user click button login")
    public void user_click_button_login () throws InterruptedException {
        swagLabs.buttonLogin ();
    }

    @Then("user success login into swag labs {string}")
    public void user_success_login_into_swag_labs (String successLogin) throws InterruptedException {
        System.out.println("Actual : "+swagLabs.userSuccessLoginIntoSwagLabs());
        Assert.assertTrue(swagLabs.userSuccessLoginIntoSwagLabs().contains(successLogin));

    }

    @And("user shorting current product from Z-A")
    public void user_shorting_current_product_from_ZtoA() throws InterruptedException {
        swagLabs.shortDataFromZto ();
    }

    @Then("display product {string} on top list")
    public void displayExpectedProduct (String product) throws InterruptedException {
        System.out.println("Actual : " + swagLabs.displayExpectedProduct());
        Assert.assertTrue(swagLabs.displayExpectedProduct().contains(product));

    }

    @And("user Select first product on list of products")
    public void user_select_first_product_on_list_of_products () throws InterruptedException {
        swagLabs.selectFristProductOnList ();
    }

    @And("user open menu checkout")
    public void user_open_menu_checkout () throws InterruptedException {
        swagLabs.menuCheckout ();
    }

    @Then("display the product that checkouted {string}")
    public void display_the_product_that_checkouted (String selectedProdcut) throws InterruptedException {
        System.out.println("Actual : " + swagLabs.displaySelectedProduct());
        Assert.assertTrue(swagLabs.displaySelectedProduct().contains(selectedProdcut));
    }

    @And("user checkout item")
    public void user_checkout_item () throws InterruptedException {
        swagLabs.checkoutItem ();
    }

    @And("user input firstname {string}")
    public void user_input_firstname (String firstName) throws InterruptedException {
        swagLabs.inputFirtsName (firstName);
    }

    @And("user input lastname {string}")
    public void user_input_lastname (String lastName) throws InterruptedException {
        swagLabs.inputLastName (lastName);
    }

    @And("user input postal code {string}")
    public void user_input_postal_code (String postalCode) throws InterruptedException {
        swagLabs.inputPostalCode (postalCode);
    }

    @And("user click button continue")
    public void user_click_button_continue () throws InterruptedException {
        swagLabs.buttonContinue ();
    }

    @And("user click button finish on overview")
    public void user_click_button_finish_on_overview () throws InterruptedException {
        swagLabs.buttonFinishOnOverview ();
    }

    @Then("user will get info success order {string}")
    public void user_will_get_info_success_order (String successOrder) throws InterruptedException {
        System.out.println("Actual : " + swagLabs.getInfoSuccessOrde());
        Assert.assertTrue(swagLabs.getInfoSuccessOrde().contains(successOrder));
    }

    @When("user on swag labs user login with locked user credential")
    public void user_on_swag_labs_user_login_with_locked_user_credential () throws InterruptedException {
        swagLabs.invalidUsernameOne (invalidUsername1);
        swagLabs.invalidPasswordOne (invalidPassword1);
    }

    @When("user on swag labs user login with not match credential")
    public void user_on_swag_labs_user_login_with_not_match_credential () throws InterruptedException {
        swagLabs.notMatchUsername (invalidusername2);
        swagLabs.notMatchPassword (invalidpassword2);
    }

    @Then("user failed login and display message {string}")
    public void user_failed_login_and_display_message (String errorMessage) throws InterruptedException {
        swagLabs.failedLogin (errorMessage);
    }




}
