package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EnergyCompareRequest {

    public WebDriver driver;
    public EnergyCompareRequest() {driver = Hooks.driver;}


    @And("^I enter all the mandatory information for creating a compare request$")
    public void enter_info_to_create_request(){
        EnergyPricesCompare request = new EnergyPricesCompare();
        request.i_have_my_bill_handy();
        request.iWantToCompareAll();
        request.goto_supplier_page();
        request.enter_annual_elec_kwh("500");
        request.goto_your_details_page();
        request.enter_annual_gas_kwh("500");
        request.goto_your_details_page();
        request.select_options_for_my_details();
        request.goto_prices();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price-page-results-view")));

    }

    @Then("^I should see all the providers with prices$")
    public void iShouldSeeAllTheProvidersWithPrices() {
        Assert.assertTrue(driver.findElements(By.id("price-panels-container")).size() != 0);
    }

}
