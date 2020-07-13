package examples.BasicUsage.Storage.WorkingWithStorage;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class GetFileVersions {

	public static void main(String[] args) {

		StorageApi apiInstance = new StorageApi(Constants.GetConfiguration());
		try {
			GetFileVersionsRequest request = new GetFileVersionsRequest("Signaturedocs\\one-page.docx", Constants.MYStorage);
			FileVersions response = apiInstance.getFileVersions(request);
			System.out.println("Expected response type is FileVersions: " + response.getValue().size());
		} catch (ApiException e) {
			System.err.println("Exception while calling StorageApi:");
			e.printStackTrace();
		}
	}
}