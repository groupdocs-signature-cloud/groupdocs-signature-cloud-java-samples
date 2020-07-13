package examples.AdvancedUsage.Verify;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.VerifyTextOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class VerifyBarcode {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\signedBarcodeOne_page.docx");
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			VerifyBarcodeOptions options = new VerifyBarcodeOptions();
			options.setSignatureType(SignatureTypeEnum.BARCODE);

			options.setPage(1);
			options.setAllPages(true);
			
			PagesSetup pagesSetup = new PagesSetup();
			pagesSetup.setEvenPages(false);
			pagesSetup.setFirstPage(true);
			pagesSetup.setLastPage(false);
			pagesSetup.setOddPages(false);
			pagesSetup.addPageNumbersItem(1);
			options.setPagesSetup(pagesSetup);

			options.setBarcodeType("Code128");
			options.setText("123456789012");
			options.setMatchType(MatchTypeEnum.CONTAINS);

			VerifySettings verifySettings = new VerifySettings();
			verifySettings.setFileInfo(fileInfo);
			verifySettings.addOptionsItem(options);

			VerifySignaturesRequest request = new VerifySignaturesRequest(verifySettings);

			VerifyResult  response = apiInstance.verifySignatures(request);
			System.out.println("Expected response type is VerifyResult : IsSuccess = " + response.getIsSuccess());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}