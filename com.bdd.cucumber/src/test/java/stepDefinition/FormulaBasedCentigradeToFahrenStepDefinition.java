package stepDefinition;

import org.apache.log4j.Logger;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.CommonUtility;

public class FormulaBasedCentigradeToFahrenStepDefinition {
	static Logger log = Logger.getLogger(FormulaBasedCentigradeToFahrenStepDefinition.class);
	CommonUtility commonUtility = new CommonUtility();
	int getCentiValue;
	float getFahrenValue;

	@Given("User enters centigrade value (.*) for converting the temperature from centigrade to fahrenheit")
	public void user_enters_centigrade_value_for_converting_temperature_from_centigrade_to_fahrenheit(int inputCentiValue) {
		this.getCentiValue = inputCentiValue;
	}

	@When("User triggers to convert centigrade value to fahrenheit value")
	public void user_triggers_to_convert_centigrade_value_to_fahrenheit_value() {
		getFahrenValue = commonUtility.convertCentiToFahrenheitUsingFormula(getCentiValue);
		log.info("Centigrade Equivalent Fahrenheit value is: " + getFahrenValue);
	}

	@Then("User verify for formula based centigrade equivalent Fahrenheit value (.*)")
	public void user_verify_for_the_centigrade_equivalent_Fahrenheit_value(float Fahrenheitvalue) {
		try {
			Assert.assertEquals(getFahrenValue, Fahrenheitvalue,"Centigrade equivalent fahrenheit value are not matching");
			log.info("Centigrade Equivalent Fahrenheit Value " + getFahrenValue + " matched successfully");
		} catch (Exception e) {
			log.error("Centigrade Equivalent Fahrenheit Value " + getFahrenValue + " match failed due to exception "+e.getMessage());
		}
	}
}