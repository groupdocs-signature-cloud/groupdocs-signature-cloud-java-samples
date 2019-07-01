package examples.Document_Information;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;
import java.util.List;
import com.groupdocs.cloud.signature.client.Configuration;
import com.groupdocs.cloud.signature.api.*;
import examples.Utils;

public class Signature_Java_DocumentInfo_File {

	public static void main(String[] args) {

		Configuration configuration = new Configuration(Utils.AppSID, Utils.AppKey);
		InfoApi apiInstance = new InfoApi(configuration);

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\one-page.docx");
			fileInfo.setPassword(null);
			fileInfo.setVersionId(null);
			fileInfo.setStorageName(Utils.MYStorage);
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			GetInfoRequest request = new GetInfoRequest(infoSettings);

			InfoResult response = apiInstance.getInfo(request);
			System.out.println("Expected response type is InfoResult: " + response.getPath());
        } catch (ApiException e) {
            System.err.println("Exception while calling InfoApi:");
            e.printStackTrace();
        }
	}
}