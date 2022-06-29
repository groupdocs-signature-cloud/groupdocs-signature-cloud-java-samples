package examples.BasicUsage;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;

import examples.Constants;

import com.groupdocs.cloud.signature.api.LicenseApi;


/**
 * This example demonstrates how to get metered license consumption information
 */
public class GetMeteredConsumption {

	public static void main(String[] args) {
		
		LicenseApi apiInstance = new LicenseApi(Constants.GetConfiguration());
		
		try {
			ConsumptionResult response = apiInstance.getConsumptionCredit();

			System.out.println("Credit: " + response.getCredit());
			System.out.println("Quantity: " + response.getQuantity());
		} catch (ApiException e) {
			System.err.println("Exception while calling LicenseApi:");
			e.printStackTrace();
		}
	}
}