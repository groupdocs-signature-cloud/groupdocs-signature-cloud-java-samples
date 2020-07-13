package examples.BasicUsage.Storage.WorkingWithFiles;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class MoveFile {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Constants.GetConfiguration());
		try {

			MoveFileRequest request = new MoveFileRequest("Signaturedocs\\one-page.docx", "Signaturedocs1\\one-page1.docx",
					Constants.MYStorage, Constants.MYStorage, null);
			apiInstance.moveFile(request);
			System.out.println(
					"Expected response type is Void: 'Signaturedocs/one-page.docx' file moved to 'Signaturedocs1/one-page1.docx'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}