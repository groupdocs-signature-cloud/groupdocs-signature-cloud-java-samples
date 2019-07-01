package examples.Supported_QRCodes;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;
import java.util.List;
import com.groupdocs.cloud.signature.client.Configuration;
import com.groupdocs.cloud.signature.api.*;
import examples.Utils;

public class Signature_Java_Get_Supported_QRCodes {

	public static void main(String[] args) {

		Configuration configuration = new Configuration(Utils.AppSID, Utils.AppKey);
		InfoApi apiInstance = new InfoApi(configuration);

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
