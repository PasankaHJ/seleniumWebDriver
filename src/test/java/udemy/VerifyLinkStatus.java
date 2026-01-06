package udemy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class VerifyLinkStatus {

	public static int invalidLinkCount;

	public static void verifyLink(String link) throws IOException { // Static method because we no need to create an
																	// object
		if (link != null && !link.isEmpty()) {
			try {
				URL url = new URL(link);

				// Create connection
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				// Set timeout
				connection.setConnectTimeout(3000);

				// Set request method to HEAD to check only the headers, not the entire content
				connection.setRequestMethod("HEAD");

				// Connect the URL
				connection.connect();

				if (connection.getResponseCode() == 200) {

				} else {
					invalidLinkCount++;
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void getInvalidLinkCount() {
		System.out.println("Total Invalid Link Count: " + invalidLinkCount);
	}
}
