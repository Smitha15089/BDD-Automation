package stepDefinition;

import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helperClass.GitHubReposSearchLibrary;

public class ServiceBasedGitHubReposSearchStepDefinition {
	static Logger log = Logger.getLogger(ServiceBasedGitHubReposSearchStepDefinition.class);
	GitHubReposSearchLibrary gitHubReposSearchLibrary = new GitHubReposSearchLibrary();
	public static String url;
	String searchKeyword;
	public static int code;

	@Given("User enter the url (.*)")
	public static void user_enter_the_url(String inputUrl) {
		url = inputUrl;
	}

	@Given("User enters search keyword (.*) for searching the api")
	public void user_enters_search_keyword_for_searching_the_api(String inputSearchkey) {
		searchKeyword = inputSearchkey;
	}

	@When("User trigger the service")
	public void user_trigger_the_service() {
		try {
			HttpResponse response = gitHubReposSearchLibrary.triggerSearchService(url, searchKeyword);
			code = response.getStatusLine().getStatusCode();
			log.info("Searching github repository using a search keyword " + searchKeyword
					+ ", has recieved a response code as: " + code);
		} catch (Exception e) {
			log.error("Getting response code failed due to exception: " + e.getMessage());
		}
	}

	@Then("User verify for successfull HTTP response code (.*)")
	public static void user_verify_for_successfull_HTTP_response_code(int statusCode) {
		try {
			Assert.assertEquals(code, statusCode, "Response code is not as expected");
		} catch (Exception e) {
			log.error("Expected Response code is: " + statusCode + " and Actual Response Code is: " + code);
		}
	}
}
