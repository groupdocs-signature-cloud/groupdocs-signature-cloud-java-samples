package examples.BasicUsage;

import com.groupdocs.cloud.signature.client.*;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.requests.*;
import com.groupdocs.cloud.signature.api.*;
import examples.Constants;

public class GetDocumentPreview {

	public static void main(String[] args) {

		PreviewApi apiInstance = new PreviewApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\one-page.docx");
			
            PreviewSettings previewSettings = new PreviewSettings();
			previewSettings.setFileInfo(fileInfo);

			PreviewDocumentRequest request = new PreviewDocumentRequest(previewSettings);

			PreviewResult response = apiInstance.previewDocument(request);
			System.out.println("Expected response type is PreviewResult: " + response);
        } catch (ApiException e) {
            System.err.println("Exception while calling PreviewApi:");
            e.printStackTrace();
        }
	}
}