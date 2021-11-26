package examples.AdvancedUsage.Info;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.requests.GetInfoRequest;
import com.groupdocs.cloud.signature.api.*;
import examples.Constants;

public class ShowDeletedSignatures {

	public static void main(String[] args) {

		InfoApi apiInstance = new InfoApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\one-page.docx");
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);
			infoSettings.setShowDeletedSignaturesInfo(true);

			GetInfoRequest request = new GetInfoRequest(infoSettings);

			InfoResult response = apiInstance.getInfo(request);
			System.out.println("Expected response type is InfoResult: " + response);
        } catch (ApiException e) {
            System.err.println("Exception while calling InfoApi:");
            e.printStackTrace();
        }
	}
}