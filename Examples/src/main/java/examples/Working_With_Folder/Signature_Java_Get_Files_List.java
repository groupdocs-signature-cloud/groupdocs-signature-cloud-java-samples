package examples.Working_With_Folder;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.FilesList;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Utils;

public class Signature_Java_Signature_Java_Get_Files_List {

	public static void main(String[] args) {

		FolderApi apiInstance = new FolderApi(Utils.AppSID, Utils.AppKey);
		try {
			GetFilesListRequest request = new GetFilesListRequest("Signaturedocs", Utils.MYStorage);
			FilesList response = apiInstance.getFilesList(request);
			System.out.println("Expected response type is FilesList.");
			for (StorageFile storageFile : response.getValue()) {
				System.out.println("Files: " + storageFile.getPath());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling FolderApi:");
			e.printStackTrace();
		}
	}
}