package examples.Working_With_Files;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Utils;

public class Signature_Java_Copy_File {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Utils.AppSID, Utils.AppKey);
		try {

			CopyFileRequest request = new CopyFileRequest("Signaturedocs\\one-page.docx",
					"Signaturedocs\\one-page-copied.docx", Utils.MYStorage, Utils.MYStorage, null);
			apiInstance.copyFile(request);
			System.out.println(
					"Expected response type is Void: 'Signaturedocs/one-page1.docx' file copied as 'Signaturedocs/one-page-copied.docx'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}