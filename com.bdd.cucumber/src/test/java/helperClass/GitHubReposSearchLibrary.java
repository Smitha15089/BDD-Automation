package helperClass;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import utils.CommonUtility;

/**
 * Smitha Description : This class contains methods to search keyword in git hub
 * using rest service
 * 
 * @author BDD Framework Automation
 * @version 0.1
 */

public class GitHubReposSearchLibrary extends CommonUtility {
	static Logger log = Logger.getLogger(GitHubReposSearchLibrary.class);

	/**
	 **********************************************************************
	 * @MethodName : triggerSerachService()
	 * @Description : This function is used to triggerSerachService
	 * @param String url
	 * @param String searchKey
	 * @return HttpResponse
	 ***********************************************************************
	 */
	public HttpResponse triggerSearchService(String url, String searchKey) {
		try {
			url = url + "?q=" + searchKey;
			HttpClient httpclient = HttpClientBuilder.create().build();
			URIBuilder builder;
			builder = new URIBuilder(url);
			URI uri = builder.build();
			HttpGet get = new HttpGet(uri);
			HttpResponse response = httpclient.execute(get);
			return response;
		} catch (Exception e) {
			log.error("triggerSearchService failed due to exception: " + e.getMessage());
		}
		return null;
	}
}
