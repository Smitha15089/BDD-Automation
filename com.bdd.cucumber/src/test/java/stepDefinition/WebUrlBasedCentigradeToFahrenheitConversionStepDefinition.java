package stepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helperClass.TemperatureInFahrenheitLibrary;
import utils.CommonUtility;

public class WebUrlBasedCentigradeToFahrenheitConversionStepDefinition {
	static Logger log = Logger.getLogger(WebUrlBasedCentigradeToFahrenheitConversionStepDefinition.class);
	static WebDriver driver;
	TemperatureInFahrenheitLibrary temperatureInFahrenheitLibrary = new TemperatureInFahrenheitLibrary();

	@Given("User launches temperature convertion site")
	public void user_launches_temperature_convertion_site() {
		CommonUtility.initializeBrowser();
		log.info("Temperature conversion site is successfully launched");
	}

	@Given("User enters centigrade value (.*) for equivalent fahrenheit conversion")
	public void user_enters_centigrade_value_for_equivalent_fahrenheit_conversion(String inputCentiValue) {
		temperatureInFahrenheitLibrary.inputCentigradeValue(inputCentiValue);
		log.info("Centigrade value is entered in webpage");
	}

	@When("User clicks on temperature convert button")
	public void user_clicks_on_temperature_convert_button() {
		temperatureInFahrenheitLibrary.clickOnConvertButton();
		log.info("Temperature Convert button is clicked");
	}

	@Then("User verify for web url based centigrade equivalent Fahrenheit value (.*)")
	public void user_verify_for_web_url_based_centigrade_equivalent_Fahrenheit_value(float expectedFahreheitValue) {
		Float actualFahrenheitValue = Float.valueOf(temperatureInFahrenheitLibrary.getConvertedFahrenheitValue());
		try {
			Assert.assertEquals(expectedFahreheitValue, actualFahrenheitValue,"Actual Converted Fahrenheit value is not matching with expected Farenheit value");
			log.info("The Actual Converted Fahrenheit Value : " + actualFahrenheitValue + " is matched with expected Fahrenheit Value " + expectedFahreheitValue);
		} catch (Exception e) {
			log.info("The Actual Converted Fahrenheit Value : " + actualFahrenheitValue + " is not matched with expected Fahrenheit Value " + expectedFahreheitValue);
		}
	}

	@Then("User close the browser")
	public void closeBrowser() {
		temperatureInFahrenheitLibrary.closebrowser();
		log.info("Close the browser");
	}
}
