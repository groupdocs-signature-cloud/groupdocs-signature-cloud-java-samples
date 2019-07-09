package examples.Working_With_Storage;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Utils;

public class Signature_Java_Storage_Exist {

	public static void main(String[] args) {

		StorageApi apiInstance = new StorageApi(Utils.AppSID, Utils.AppKey);
		try {
			StorageExistsRequest request = new StorageExistsRequest(Utils.MYStorage);
			StorageExist response = apiInstance.storageExists(request);
			System.out.println("Expected response type is StorageExist: " + response.getExists());
		} catch (ApiException e) {
			System.err.println("Exception while calling StorageApi:");
			e.printStackTrace();
		}
	}
}