package helperClass;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import pageObjects.TemperatureConverterPage;
import utils.CommonUtility;

/** Smitha
 * Description : This class contains methods to convert input centigrade temperature value to equivalent 
 * Fahrenheit values in temperature converter website.
 * @author BDD Framework Automation
 * @version 0.1
 */

public class TemperatureInFahrenheitLibrary extends  CommonUtility{
	static Logger log = Logger.getLogger(TemperatureInFahrenheitLibrary.class);
	TemperatureConverterPage temperatureConverterPage = new TemperatureConverterPage(driver);
	
	/**
	 **********************************************************************
	 * @MethodName : inputCentigradeValue()
	 * @Description : This function is used to get input Centigrade Value
	 * @param String value
	 * @Return <none>
	 ***********************************************************************
	 */
	public void inputCentigradeValue(String inputCentigradeVal){
		try {
			driver.findElement(By.name("x")).sendKeys(inputCentigradeVal);	
		}catch(Exception e) {
			Reporter.addStepLog("inputCentigradeValue failed due to exception: "+e.getMessage());
			takeScreenShotForFail();
			Assert.fail("inputCentigradeValue failed");
		}
	}
	
	/**
	 **********************************************************************
	 * @MethodName : clickOnConvertButton()
	 * @Description : This function is used to click On Convert Button
	 * @param <none>
	 * @Return <none>
	 ***********************************************************************
	 */
	public void clickOnConvertButton() {
		try {
			driver.findElement(By.xpath("//button[@title='Convert']")).click();
		}catch(Exception e) {
			Reporter.addStepLog("clickOnConvertButton failed due to exception: "+e.getMessage());
			takeScreenShotForFail();
			Assert.fail("clickOnConvertButton failed");
		}
	}
				
	/**
	 **********************************************************************
	 * @MethodName : getConvertedFahrenheitValue()
	 * @Description : This function is used to get converted Fahrenheit Value
	 * @param <none>
	 * @Return String value
	 ***********************************************************************
	 */
	public String getConvertedFahrenheitValue() {
		String outputFarenhietValue = null;
		try {
			outputFarenhietValue = driver.findElement(By.name("y")).getAttribute("value");
		}catch(Exception e) {
			Reporter.addStepLog("getConvertedFahrenheitValue failed due to exception: "+e.getMessage());
			takeScreenShotForFail();
			Assert.fail("getConvertedFahrenheitValue failed");
		}
		return outputFarenhietValue;
	}
	
	/**
	 **********************************************************************
	 * @MethodName : closebrowser()
	 * @Description : This function is used to close browser
	 * @param <none>
	 * @Return <none>
	 ***********************************************************************
	 */
	public void closebrowser(){
		driver.quit();
	}
}
