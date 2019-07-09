package examples.Search_Signatures;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.client.Configuration;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.DocumentTypeEnum;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.SearchBarcodeOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import java.util.List;
import examples.Utils;

public class Signature_Java_Search_Barcode_Signature {

	public static void main(String[] args) {

		Configuration configuration = new Configuration(Utils.AppSID, Utils.AppKey);
		SignApi apiInstance = new SignApi(configuration);

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\one-page.docx");
			fileInfo.setPassword(null);
			fileInfo.setVersionId(null);
			fileInfo.setStorageName(Utils.MYStorage);
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			SearchBarcodeOptions options = new SearchBarcodeOptions();
			options.setDocumentType(DocumentTypeEnum.WORDPROCESSING);
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

			options.setBarcodeType("Code39Standard");
			options.setText("123456789012");
			options.setMatchType(MatchTypeEnum.CONTAINS);

			SearchSettings searchSettings = new SearchSettings();
			searchSettings.setFileInfo(fileInfo);
			searchSettings.addOptionsItem(options);

			SearchSignaturesRequest request = new SearchSignaturesRequest(searchSettings);

			SearchResult  response = apiInstance.searchSignatures(request);
			System.out.println("Expected response type is SearchResult : Length = " + response.getSignatures());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}