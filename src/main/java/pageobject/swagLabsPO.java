package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.SeleniumHelpers;

public class swagLabsPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public swagLabsPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    @FindBy(xpath = "//input[@id='user-name']")
    WebElement inputdUsername;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement buttonLogin;

    @FindBy(xpath = "//span[@class='title']")
    WebElement userSuccessLoginIntoSwagLabs;

    @FindBy(xpath = "//div[.='Sauce Labs Onesie']")
    WebElement displayExpectedProduct;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    WebElement selectFristProductOnList;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[1]")
    WebElement menuCheckout;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement displaySelectedProduct;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutItem;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement inputFirtsName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement inputPostalCode;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement buttomContinue;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement buttonFinishOnOverview;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement getInfoSuccessOrde;



    public void directToSwagLabs () throws InterruptedException {
        selenium.navigateToPage("https://www.saucedemo.com/");
    }

    public void inputValidUsername (String validUsername) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputdUsername, validUsername, true);
    }

    public void inputValidPassword (String validPassword) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputPassword, validPassword, true);
    }

    public void buttonLogin () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(buttonLogin);
        selenium.hardWait(2);
    }

    public String userSuccessLoginIntoSwagLabs () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(userSuccessLoginIntoSwagLabs);

    }

    public void shortDataFromZto () throws InterruptedException {
        selenium.hardWait(2);
        Select slt = new Select (driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        selenium.hardWait(2);
        slt.selectByVisibleText("Name (Z to A)");

    }

    public String displayExpectedProduct () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(displayExpectedProduct);
    }

    public void selectFristProductOnList () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(selectFristProductOnList);
    }

    public void menuCheckout () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(menuCheckout);
    }

    public String displaySelectedProduct () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(displaySelectedProduct);
    }

    public void checkoutItem () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(checkoutItem);
    }

    public void inputFirtsName (String firstName) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputFirtsName, firstName, true);
    }

    public void inputLastName (String lastName) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputLastName, lastName, true);
    }

    public void inputPostalCode (String postalCode) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputPostalCode, postalCode, true);
    }

    public void buttonContinue () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(buttomContinue);
    }

    public void buttonFinishOnOverview () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(buttonFinishOnOverview);
    }

    public String getInfoSuccessOrde () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(getInfoSuccessOrde);
    }

    public void invalidUsernameOne (String invalidUsername1) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputdUsername, invalidUsername1, true);
    }

    public void invalidPasswordOne (String invalidPassword1) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputPassword, invalidPassword1, true);
    }


    public void notMatchUsername (String invalidusername2) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputdUsername, invalidusername2, true);
    }

    public void notMatchPassword (String invalidPassword2) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputPassword, invalidPassword2, true);
    }

    public void failedLogin (String errorMessage) throws InterruptedException {
        selenium.hardWait(2);
        WebElement error = driver.findElement(By.xpath("//h3[.='"+errorMessage+"']"));
        String rslt = error.getText();
        if(driver.getPageSource().contains(rslt)){
            System.out.println("Text is present");
        }else{
            System.out.println("Text is absent");
        }
        System.out.println(rslt);

    }



}
