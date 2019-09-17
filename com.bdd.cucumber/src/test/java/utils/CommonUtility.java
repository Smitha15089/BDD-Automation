package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.cucumber.listener.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtility {
	/** Smitha
	 * Description : This class contains actions to initialize browser and some common selenium methods.
	 * @author BDD Framework Automation
	 * @version 0.1
	 */
	
	static Logger log = Logger.getLogger(CommonUtility.class);
	public static WebDriver driver;

	/**
	 **********************************************************************
	 * @MethodName : initializeBrowser()
	 * @Description : This function is used to initialize the Browser
	 * @param <none>
	 * @Return <none>
	 ***********************************************************************
	 */
	public static void initializeBrowser() {
		try {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.get("https://www.rapidtables.com/convert/temperature/celsius-to-fahrenheit.html");
//			driver.manage().window().maximize();
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.rapidtables.com/convert/temperature/celsius-to-fahrenheit.html");
			driver.manage().window().maximize();
		} catch (Exception e) {
			log.error("Browser launch failed due to exception: " +e.getMessage());
			takeScreenShotForFail();
		}
	}

	/**
	 **********************************************************************
	 * @MethodName : convertCentiToFahrenheitUsingFormula()
	 * @Description : This function is used to convert Centigrade to Fahrenheit Using Formula
	 * @param <none>
	 * @Return float Value 
	 ***********************************************************************
	 */
	public float convertCentiToFahrenheitUsingFormula(int i) {
		float val;
		val = i * 9 / 5 + 32;
		return val;
	}
	
	/**
	 **********************************************************************
	 * @MethodName : takeScreenShotForFail()
	 * @Description : This method is to take screenshot for Failed steps.
	 * @param <none>
	 * @Return <none>
	 ***********************************************************************
	 */
	public static void takeScreenShotForFail() {
		String filePath = System.getProperty("user.dir") + "\\Screenshots\\";
		String fileName = null;
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String mainFolderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			File mainFolder = new File("./Screenshots/" + mainFolderName);
			if (!mainFolder.exists()) {
				mainFolder.mkdirs();
			}
			File subFolder = new File("./" + mainFolder + "/FailedStepScreenshots");
			if (!subFolder.exists()) {
				subFolder.mkdirs();
			}
			fileName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
			FileUtils.copyFile(src, new File("./" + subFolder + "/" + fileName + ".PNG"));
			String path = filePath + mainFolderName + "\\FailedStepScreenshots\\" + fileName + ".PNG";
			Reporter.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			Reporter.addStepLog("Cature screeenshot for failed step failed");
			Assert.fail("Cature screeenshot for failed step failed due to exception: " + e.getMessage());
		}
	}

}