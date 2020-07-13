package examples.AdvancedUsage.Verify;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.VerifyTextOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class VerifyCollection {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\signedCollectionOne_page.docx");
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			VerifyBarcodeOptions barcodeOptions = new VerifyBarcodeOptions();
			barcodeOptions.setSignatureType(SignatureTypeEnum.BARCODE);

			barcodeOptions.setPage(1);
			barcodeOptions.setAllPages(true);
			
			PagesSetup pagesSetup = new PagesSetup();
			pagesSetup.setEvenPages(false);
			pagesSetup.setFirstPage(true);
			pagesSetup.setLastPage(false);
			pagesSetup.setOddPages(false);
			pagesSetup.addPageNumbersItem(1);
			barcodeOptions.setPagesSetup(pagesSetup);

			barcodeOptions.setBarcodeType("Code128");
			barcodeOptions.setText("123456789012");
			barcodeOptions.setMatchType(MatchTypeEnum.CONTAINS);

			VerifyDigitalOptions digitalOptions = new VerifyDigitalOptions();
			digitalOptions.setSignatureType(SignatureTypeEnum.DIGITAL);
			digitalOptions.setPage(1);
			digitalOptions.setAllPages(true);
			
			pagesSetup = new PagesSetup();
			pagesSetup.setEvenPages(false);
			pagesSetup.setFirstPage(true);
			pagesSetup.setLastPage(false);
			pagesSetup.setOddPages(false);
			pagesSetup.addPageNumbersItem(1);
			digitalOptions.setPagesSetup(pagesSetup);
		
			VerifySettings verifySettings = new VerifySettings();
			verifySettings.addOptionsItem(barcodeOptions);
			verifySettings.addOptionsItem(digitalOptions);
			verifySettings.setFileInfo(fileInfo);

			VerifySignaturesRequest request = new VerifySignaturesRequest(verifySettings);

			VerifyResult  response = apiInstance.verifySignatures(request);
			System.out.println("Expected response type is VerifyResult : IsSuccess = " + response.getIsSuccess());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}