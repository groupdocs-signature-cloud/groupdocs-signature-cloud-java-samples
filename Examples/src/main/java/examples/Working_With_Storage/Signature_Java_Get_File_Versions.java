package examples.Working_With_Storage;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Utils;

public class Signature_Java_Signature_Java_Get_File_Versions {

	public static void main(String[] args) {

		StorageApi apiInstance = new StorageApi(Utils.AppSID, Utils.AppKey);
		try {
			GetFileVersionsRequest request = new GetFileVersionsRequest("Signaturedocs\\one-page.docx", Utils.MYStorage);
			FileVersions response = apiInstance.getFileVersions(request);
			System.out.println("Expected response type is FileVersions: " + response.getValue().size());
		} catch (ApiException e) {
			System.err.println("Exception while calling StorageApi:");
			e.printStackTrace();
		}
	}
}