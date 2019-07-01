package examples.Supported_File_Formats;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;
import java.util.List;
import com.groupdocs.cloud.signature.client.Configuration;
import com.groupdocs.cloud.signature.api.*;
import examples.Utils;

public class Signature_Java_Signature_Java_Get_Supported_Formats {

	public static void main(String[] args) {

		Configuration configuration = new Configuration(Utils.AppSID, Utils.AppKey);
		InfoApi apiInstance = new InfoApi(configuration);

        try {
            FormatsResult response = apiInstance.getSupportedFileFormats();
            for (Format format : response.getFormats()) {
                System.out.println(format.getFileFormat());
            }
        } catch (ApiException e) {
            System.err.println("Exception while calling InfoApi:");
            e.printStackTrace();
        }
	}
}
