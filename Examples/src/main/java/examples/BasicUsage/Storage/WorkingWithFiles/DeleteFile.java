package examples.BasicUsage.Storage.WorkingWithFiles;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class DeleteFile {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Constants.GetConfiguration());
		try {

			DeleteFileRequest request = new DeleteFileRequest("Signaturedocs1\\one-page1.docx", Constants.MYStorage, null);
			apiInstance.deleteFile(request);
			System.out.println("Expected response type is Void: 'Signaturedocs1/one-page1.docx' deleted.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}