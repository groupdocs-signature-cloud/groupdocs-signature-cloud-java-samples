package examples.BasicUsage.Storage.WorkingWithFolder;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class MoveFolder {

	public static void main(String[] args) {

		FolderApi apiInstance = new FolderApi(Constants.GetConfiguration());
		try {
			MoveFolderRequest request = new MoveFolderRequest("Signaturedocs1", "Signaturedocs\\Signaturedocs1",
					Constants.MYStorage, Constants.MYStorage);
			apiInstance.moveFolder(request);
			System.out.println(
					"Expected response type is Void: 'Signaturedocs1' folder moved to 'Signaturedocs/Signaturedocs1'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FolderApi:");
			e.printStackTrace();
		}
	}
}