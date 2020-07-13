package examples.AdvancedUsage.Update;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class UpdateBarcode {

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

			UpdateOptions updateOptions = new UpdateOptions();
			updateOptions.setSignatureType(UpdateOptions.SignatureTypeEnum.BARCODE);
			updateOptions.setLeft(200);
			updateOptions.setTop(200);
			updateOptions.setWidth(300);
			updateOptions.setHeight(100);
			updateOptions.setIsSignature(true);
			updateOptions.setSignatureId(searchResult.getSignatures().get(0).getSignatureId());

			UpdateSettings updateSettings = new UpdateSettings();
			updateSettings.setFileInfo(fileInfo);
			updateSettings.addOptionsItem(updateOptions);			

			UpdateResult updateResult = apiInstance.updateSignatures(new UpdateSignaturesRequest(updateSettings));

			System.out.println("Expected response type is UpdateResult : IsSuccess = " + (updateResult.getSucceeded().size() > 0));
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}