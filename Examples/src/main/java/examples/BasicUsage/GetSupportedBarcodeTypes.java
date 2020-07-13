package examples.BasicUsage;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.api.*;
import examples.Constants;

public class GetSupportedBarcodeTypes {

	public static void main(String[] args) {

		InfoApi apiInstance = new InfoApi(Constants.GetConfiguration());

        try {
            BarcodesResult response = apiInstance.getSupportedBarcodes();
            for (BarcodeType format : response.getBarcodeTypes()) {
                System.out.println(format.getName());
            }
        } catch (ApiException e) {
            System.err.println("Exception while calling InfoApi:");
            e.printStackTrace();
        }
	}
}
