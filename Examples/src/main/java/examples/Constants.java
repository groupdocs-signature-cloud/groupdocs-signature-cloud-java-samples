package examples;
import com.groupdocs.cloud.signature.client.Configuration;

public class Constants {

	// TODO: Get your ClientId and ClientSecret at https://dashboard.groupdocs.cloud (free
	// registration is required).

	private static String ClientId = "XXXX-XXXX-XXXX-XXXX";
	private static String ClientSecret = "XXXXXXXXXXXXXXXX";

	public static String MYStorage = "First Storage";

	public static Configuration GetConfiguration()
	{
		Configuration cfg = new Configuration(Constants.ClientId, Constants.ClientSecret);	
		cfg.setApiBaseUrl("https://api.groupdocs.cloud");
		cfg.setTimeout(60000);				
		return cfg;
	}	
}