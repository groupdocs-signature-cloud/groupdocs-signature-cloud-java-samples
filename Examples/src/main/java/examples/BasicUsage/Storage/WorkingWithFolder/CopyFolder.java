package examples.BasicUsage.Storage.WorkingWithFolder;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class CopyFolder {

	public static void main(String[] args) {

		FolderApi apiInstance = new FolderApi(Constants.GetConfiguration());
		try {
			CopyFolderRequest request = new CopyFolderRequest("Signaturedocs", "Signaturedocs1", Constants.MYStorage,
					Constants.MYStorage);
			apiInstance.copyFolder(request);
			System.out.println("Expected response type is Void: 'Signaturedocs' folder copied as 'Signaturedocs1'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FolderApi:");
			e.printStackTrace();
		}
	}
}