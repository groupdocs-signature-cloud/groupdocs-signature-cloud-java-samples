package examples.AdvancedUsage.Delete;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class DeleteBarcode {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\signedBarcodeOne_page.docx");
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			SearchBarcodeOptions options = new SearchBarcodeOptions();
			options.setSignatureType(SignatureTypeEnum.BARCODE);
			options.setAllPages(true);
			SearchSettings searchSettings = new SearchSettings();
			searchSettings.setFileInfo(fileInfo);
			searchSettings.addOptionsItem(options);

			SearchSignaturesRequest request = new SearchSignaturesRequest(searchSettings);
			SearchResult  searchResult = apiInstance.searchSignatures(request);

			DeleteOptions deleteOptions = new DeleteOptions();
			deleteOptions.setSignatureType(DeleteOptions.SignatureTypeEnum.BARCODE);
			deleteOptions.setSignatureId(searchResult.getSignatures().get(0).getSignatureId());

			DeleteSettings deleteSettings = new DeleteSettings();
			deleteSettings.setFileInfo(fileInfo);
			deleteSettings.addOptionsItem(deleteOptions);			

			DeleteResult deleteResult = apiInstance.deleteSignatures(new DeleteSignaturesRequest(deleteSettings));

			System.out.println("Expected response type is DeleteResult : IsSuccess = " + (deleteResult.getSucceeded().size() > 0));
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}