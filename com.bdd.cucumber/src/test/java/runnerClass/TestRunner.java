package runnerClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cucumber.listener.ExtentProperties;
import org.testng.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resource/features" }, 
					 glue = {"stepDefinition", "utils", "pageObjects", "helperClass","runnerClass" }, 
				   plugin = { "com.cucumber.listener.ExtentCucumberFormatter:" })

@Test
public class TestRunner extends AbstractTestNGCucumberTests {
	Logger logger = Logger.getLogger(TestRunner.class);
	public static String filePathdir = System.getProperty("user.dir");

	/**
	 **********************************************************************
	 * @MethodName : generateReport()
	 * @Description : This function is used to generate Report
	 * @param <none>
	 * @Return <none>
	 ***********************************************************************
	 */
	@BeforeTest
	public void generateReport() {
		try {
			PropertyConfigurator.configure(filePathdir + "\\log4j.properties.txt");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_h_mm_ss a");
			String formattedDate = sdf.format(date);
			formattedDate = formattedDate.replace("-", "").replace(" ", "");
			File mainFolder = new File("./report");
			if (!mainFolder.exists()) {
				mainFolder.mkdirs();
			}
			String projectname = "BDD_Automation";
			File ResPathFolder = new File("./report");
			File PathFolderOuter = new File(
					ResPathFolder.getAbsolutePath() + "\\Result_" + projectname + "_" + formattedDate);
			File f = PathFolderOuter.getAbsoluteFile();
			Thread.sleep(10);
			ExtentProperties extentProperties = ExtentProperties.INSTANCE;
			extentProperties.setReportPath(f + "/" + projectname + "_" + formattedDate + ".html");
			Reporter.getCurrentTestResult();
		} catch (Exception e) {
			Assert.fail("Failed in generateReport method due to exception: " + e.getMessage());
		}
	}
}
