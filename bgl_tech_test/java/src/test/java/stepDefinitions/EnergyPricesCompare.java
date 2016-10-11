package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class EnergyPricesCompare {
    public WebDriver driver;
    public EnergyPricesCompare() {driver = Hooks.driver;}

    @Given("^I am on the comparethemarket energy page$")
    public void i_am_on_ctm_energy_page() {
        driver.get("https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TST");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("find-postcode")));
    }

    @Given("^I search for energy prices for postcode \"(.*?)\"$")
    public void i_search_for_energy_prices_for_postcode(String postcode){
        driver.findElement(By.id("your-postcode")).sendKeys(postcode);
        driver.findElement(By.id("find-postcode")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("change-postcode")));

    }

    @Given("^I have my bill handy$")
    public void i_have_my_bill_handy() {
        driver.findElement(By.className("have-bill-yes")).click();
    }

    @Then("^I should not see question \"(.*?)\"$")
    public void i_should_not_see_question(String message) {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertFalse("Text exists!, which should not.", bodyText.contains(message));
    }

    @Then("^I should see question \"(.*?)\"$")
    public void i_should_see_question(String message) {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text doesnt' exist!", bodyText.contains(message));
    }

    @And("^I dont have my bill handy$")
    public void i_dont_have_my_bill_handy() {

        driver.findElement(By.className("have-bill-no")).click();
    }

    @And("^I want to compare gas and electricity$")
    public void iWantToCompareAll() {

        driver.findElement(By.className("energy-gas-electricity")).click();
    }


    @And("^my gas and electricity (.*) from same supplier$")
    public void myGasAndElectricityAreNotFromSameSupplier(String supplier) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(supplier == "are"){
           driver.findElement(By.xpath("//*[@id=\"same-supplier-question\"]/div/div/label[1]/span")).click();
        }
            if (supplier == "are not"){
                driver.findElement(By.xpath("//*[@id=\"same-supplier-question\"]/div/div/label[2]/span")).click();
        }

    }

    @And("^I go to supplier details$")
    public void goto_supplier_page(){
        driver.findElement(By.id("goto-your-supplier-details")).click();
    }

    @And("^enter annual electricity usage as (.*)$")
    public void enter_annual_elec_kwh(String usage) {
        driver.findElement(By.id("electricity-usage")).sendKeys(usage);
    }

    @And("^enter annual gas usage as (.*)$")
    public void enter_annual_gas_kwh(String usage) {
        driver.findElement(By.id("gas-usage")).sendKeys(usage);
    }

    @And("go to your details page")
    public void goto_your_details_page(){
        driver.findElement(By.id("goto-your-energy")).click();
    }

    @And("select all tariffs")
    public void select_options_for_my_details(){
        driver.findElement(By.xpath("//*[@id=\"tariff-selection-question\"]/div/label[3]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-selection-question\"]/div/label[4]/span/span")).click();
        driver.findElement(By.id("Email")).sendKeys("test@ctm.com");
        driver.findElement(By.xpath("//*[@id=\"terms-label\"]/span[2]")).click();
    }

    @And("^I go to prices page$")
    public void goto_prices(){
        driver.findElement(By.id("email-submit")).click();
    }
}

