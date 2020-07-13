package examples.BasicUsage;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;

import examples.Constants;

import com.groupdocs.cloud.signature.api.*;


public class GetSupportedQrCodeTypes {

	public static void main(String[] args) {

		InfoApi apiInstance = new InfoApi(Constants.GetConfiguration());

        try {
            QRCodesResult response = apiInstance.getSupportedQRCodes();
            for (QRCodeType format : response.getQrCodeTypes()) {
                System.out.println(format.getName());
            }
        } catch (ApiException e) {
            System.err.println("Exception while calling InfoApi:");
            e.printStackTrace();
        }
	}
}
