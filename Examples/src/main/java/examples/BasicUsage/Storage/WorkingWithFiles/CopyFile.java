package examples.BasicUsage.Storage.WorkingWithFiles;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class CopyFile {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Constants.GetConfiguration());
		try {

			CopyFileRequest request = new CopyFileRequest("Signaturedocs\\one-page.docx",
					"Signaturedocs\\one-page-copied.docx", Constants.MYStorage, Constants.MYStorage, null);
			apiInstance.copyFile(request);
			System.out.println(
					"Expected response type is Void: 'Signaturedocs/one-page1.docx' file copied as 'Signaturedocs/one-page-copied.docx'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}