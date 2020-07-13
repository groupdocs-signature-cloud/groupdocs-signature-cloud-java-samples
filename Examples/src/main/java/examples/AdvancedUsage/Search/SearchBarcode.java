package examples.AdvancedUsage.Search;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.SearchBarcodeOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class SearchBarcode {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\signedBarcodeOne_page.docx");
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			SearchBarcodeOptions options = new SearchBarcodeOptions();
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

			SearchSettings searchSettings = new SearchSettings();
			searchSettings.setFileInfo(fileInfo);
			searchSettings.addOptionsItem(options);

			SearchSignaturesRequest request = new SearchSignaturesRequest(searchSettings);

			SearchResult  response = apiInstance.searchSignatures(request);
			System.out.println("Expected response type is SearchResult : Length = " + response.getSignatures().size());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}