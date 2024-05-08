package pageobject.flipLandingPage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import utilities.SeleniumHelpers;

public class flipPagePO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public flipPagePO (WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    @FindBy(xpath = "//p[contains(text(),'EN')]")
    WebElement changeLanguageToEn;

    @FindBy(xpath = "//h3[@class='chakra-heading css-cy1hn2']")
    WebElement resultAfterChangeLanguage;

    @FindBy(xpath = "(//p[contains(text(),'ID')])[1]")
    WebElement changeBackToIdLanguage;

    @FindBy(xpath = "(//a[@class='chakra-button css-os5e35'])[3]")
    WebElement buttonLearnMore;

    @FindBy(xpath = "//button[.='Produk']")
    WebElement productMenu;

    @FindBy(xpath = "//p[.='Flip Globe']")
    WebElement flipGlobe;

    @FindBy(xpath = "//button[@class='chakra-menu__menu-button css-1l1pwnu']")
    WebElement destinationBank;

    @FindBy(xpath = "//input[@class='chakra-input css-4gru8k']")
    WebElement inputCurrency;

    @FindBy(xpath = "//p[@class='chakra-text css-1i33ipy']")
    WebElement selectCountry;

    @FindBy(xpath = "//div[@class='css-6ccagd']/div[1]/input[@class='css-19t8ja4']")
    WebElement inputIdrAmount;

    @FindBy(xpath = "//input[@placeholder='Input amount in GBP']")
    WebElement displayGbpAmount;

    @FindBy(xpath = "(//p[@class='chakra-text css-1int6b7'])[1]")
    WebElement currentRateGBP;

    @FindBy(xpath = "(//p[@class='chakra-text css-1int6b7'])[2]")
    WebElement flipFee;

    @FindBy(xpath = "//p[@class='chakra-text css-1151a72']")
    WebElement displayTotalPayment;



    public void changeLanguageToEn () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(changeLanguageToEn);
    }

    public String resultAfterChangeLanguage () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(resultAfterChangeLanguage);
    }

    public void changeBackToIdLanguage () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(changeBackToIdLanguage);
    }

    public void scrollDownToDigitalProduct () throws InterruptedException {
        selenium.hardWait(2);
        WebElement digitalProduct = driver.findElement(By.xpath("(//h2[@class='chakra-heading panel-title css-ogkx9q'])[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", digitalProduct);

    }

    public void buttonLearnMore () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(buttonLearnMore);
        selenium.hardWait(2);
        WebElement provider = driver.findElement(By.xpath("(//h3[@class='chakra-heading horizontal-card-title css-n3ofyd'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", provider);
    }

    public void seeIconProvider () throws InterruptedException {
        selenium.hardWait(2);
        WebElement mobileCredit= driver.findElement(By.xpath("//h3[.='Pengisian Pulsa']"));
        WebElement imageIndonsat= mobileCredit.findElement(By.xpath("(//img[@alt='indosat'])[1]"));
        WebElement imageTelkomsel= mobileCredit.findElement(By.xpath("(//img[@alt='telkomsel'])[1]"));
        WebElement imageXl= mobileCredit.findElement(By.xpath("(//img[@alt='XL'])[1]"));
        boolean imagePresent1 = imageIndonsat.isDisplayed();
        boolean imagePresent2 = imageTelkomsel.isDisplayed();
        boolean imagePresent3 = imageXl.isDisplayed();
        Assert.assertTrue(imagePresent1, "No image is exist");
        Assert.assertTrue(imagePresent2, "No image is exist");
        Assert.assertTrue(imagePresent3, "No image is exist");

    }

    public void productMenu () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(productMenu);
    }

    public void flipGlobe () throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(flipGlobe);
    }

    public void inputCurrency (String currency) throws InterruptedException {
        selenium.hardWait(2);
        selenium.click(destinationBank);
        selenium.hardWait(2);
        selenium.enterText(inputCurrency, currency, true) ;
        selenium.hardWait(2);
        selenium.click(selectCountry);
    }


    public void inputIdrAmount (String amount) throws InterruptedException {
        selenium.hardWait(2);
        selenium.enterText(inputIdrAmount, amount, true);
        selenium.hardWait(2);

    }

    public String displayGbpAmount () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(displayGbpAmount);

    }




    public String currentRateGBP () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(currentRateGBP);
    }

    public String flipFee () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(flipFee);
    }

    public String displayTotalPayment () throws InterruptedException {
        selenium.hardWait(2);
        return selenium.getText(displayTotalPayment);
    }




}
