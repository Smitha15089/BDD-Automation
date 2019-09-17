package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Smitha
 * Description : This class contains objects required for temperature conversion.
 * @author BDD Framework Automation
 * @version 0.1
 */
public class TemperatureConverterPage{

	@FindBy(xpath = "//button[@title='Convert']")
	public WebElement temperatureConvertBtn;
	
	@FindBy(name = "x")
	public WebElement inputCentigradeValue;
	
	@FindBy(name = "y")
	public WebElement outputFarenheitValue;
	
	public TemperatureConverterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
