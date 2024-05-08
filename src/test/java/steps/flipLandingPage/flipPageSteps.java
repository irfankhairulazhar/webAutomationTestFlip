package steps.flipLandingPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.flipLandingPage.flipPagePO;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class flipPageSteps {

    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private flipPagePO flip =  new flipPagePO(driver);

    private String flipURL = System.getenv("URL_FLIP");

    @Given("user direct to flip landing page")
    public void user_direct_to_flip_landing_page () throws InterruptedException {
        selenium.navigateToPage(flipURL);
    }

    @When("user on flip page change language to en")
    public void user_on_flip_page_change_language_to_en () throws InterruptedException {
        flip.changeLanguageToEn ();
    }

    @Then("all wordings using english {string}")
    public void all_wordings_using_english (String enWording) throws InterruptedException {
        System.out.println("Actual : "+flip.resultAfterChangeLanguage());
        Assert.assertTrue(flip.resultAfterChangeLanguage().contains(enWording));

    }

    @And("user change back the language to id")
    public void user_change_back_thelanguage_to_id () throws InterruptedException {
        flip.changeBackToIdLanguage () ;
    }

    @When("user on flip page scroll down to digital product")
    public void user_on_flip_page_scroll_down_to_digital_product () throws InterruptedException {
        flip.scrollDownToDigitalProduct ();
    }

    @And("user click button learn more")
    public void user_click_button_learn_more () throws InterruptedException {
        flip.buttonLearnMore ();
    }

    @Then("user will see icon provider")
    public void use_will_see_icon_provider() throws InterruptedException {
        flip.seeIconProvider ();
    }

    @And("user on flip page open product")
    public void user_on_flip_page_open_product () throws InterruptedException {
        flip.productMenu ();
    }

    @And("user open flip globe")
    public void user_open_flip_globe () throws InterruptedException {
        flip.flipGlobe ();
    }

    @And("user input currency {string}")
    public void user_input_currency (String currency) throws InterruptedException {
        flip.inputCurrency (currency);
    }

    @And("user input idr amount {string}")
    public void user_input_idr_amount (String amount) throws InterruptedException {
        flip.inputIdrAmount (amount);
    }

    @Then("display GBP amount {string}")
    public void display_GBP_amount (String totalGBPamount) throws InterruptedException {
        System.out.println("Actual : "+flip.displayGbpAmount());
        Assert.assertTrue(flip.displayGbpAmount().contains(totalGBPamount));



    }

    @Then("display current kurs rate GBP {string}")
    public void display_current_kurs_rate_GBP (String kursRate) throws InterruptedException {
        System.out.println("Actual : "+flip.currentRateGBP());
        Assert.assertTrue(flip.currentRateGBP().contains(kursRate));
    }

    @Then("display service fee {string}")
    public void display_service_fee (String serviceFee) throws InterruptedException {
        System.out.println("Actual : "+flip.flipFee());
        Assert.assertTrue(flip.flipFee().contains(serviceFee));
    }

    @Then("display total payment {string}")
    public void display_total_payment (String totalPayment) throws InterruptedException {
        System.out.println("Actual : "+flip.displayTotalPayment());
        Assert.assertTrue(flip.displayTotalPayment().contains(totalPayment));
    }



}
