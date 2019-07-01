package examples.Working_With_Files;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Utils;

public class Signature_Java_Signature_Java_Move_File {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Utils.AppSID, Utils.AppKey);
		try {

			MoveFileRequest request = new MoveFileRequest("Signaturedocs\\one-page1.docx", "Signaturedocs1\\one-page1.docx",
					Utils.MYStorage, Utils.MYStorage, null);
			apiInstance.moveFile(request);
			System.out.println(
					"Expected response type is Void: 'Signaturedocs/one-page1.docx' file moved to 'Signaturedocs1/one-page1.docx'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}