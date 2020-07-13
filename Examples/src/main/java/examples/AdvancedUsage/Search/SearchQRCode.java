package examples.AdvancedUsage.Search;

import com.groupdocs.cloud.signature.api.SignApi;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.FileInfo;
import com.groupdocs.cloud.signature.model.InfoSettings;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.PagesSetup;
import com.groupdocs.cloud.signature.model.SearchQRCodeOptions;
import com.groupdocs.cloud.signature.model.SearchQRCodeOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.SearchResult;
import com.groupdocs.cloud.signature.model.SearchSettings;
import com.groupdocs.cloud.signature.model.requests.SearchSignaturesRequest;

import examples.Constants;

public class SearchQRCode {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\signedQRCode_one-page.docx");
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			SearchQRCodeOptions options = new SearchQRCodeOptions();
			options.setSignatureType(SignatureTypeEnum.QRCODE);

			options.setPage(1);
			options.setAllPages(true);
			PagesSetup pagesSetup = new PagesSetup();
			
			pagesSetup.setEvenPages(false);
			pagesSetup.setFirstPage(true);
			pagesSetup.setLastPage(false);
			pagesSetup.setOddPages(false);
			pagesSetup.addPageNumbersItem(1);
			options.setPagesSetup(pagesSetup);

			options.setQrCodeType("Aztec");
			options.setText("John Smith");
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