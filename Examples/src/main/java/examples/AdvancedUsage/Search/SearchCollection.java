package examples.AdvancedUsage.Search;

import com.groupdocs.cloud.signature.api.SignApi;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.FileInfo;
import com.groupdocs.cloud.signature.model.InfoSettings;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.PagesSetup;
import com.groupdocs.cloud.signature.model.SearchBarcodeOptions;
import com.groupdocs.cloud.signature.model.SearchBarcodeOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.SearchDigitalOptions;
import com.groupdocs.cloud.signature.model.SearchResult;
import com.groupdocs.cloud.signature.model.SearchSettings;
import com.groupdocs.cloud.signature.model.requests.SearchSignaturesRequest;

import examples.Constants;

public class SearchCollection {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\signedCollectionOne_page.docx");
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			SearchBarcodeOptions barcodeOptions = new SearchBarcodeOptions();
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

			SearchDigitalOptions digitalOptions = new SearchDigitalOptions();
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
		
			SearchSettings searchSettings = new SearchSettings();
			searchSettings.addOptionsItem(barcodeOptions);
			searchSettings.addOptionsItem(digitalOptions);
			searchSettings.setFileInfo(fileInfo);

			SearchSignaturesRequest request = new SearchSignaturesRequest(searchSettings);

			SearchResult  response = apiInstance.searchSignatures(request);
			System.out.println("Expected response type is SearchResult : Length = " + response.getSignatures().size());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}