package examples.Search_Signatures;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.client.Configuration;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.DocumentTypeEnum;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.SearchBarcodeOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.SignBarcodeOptions.CodeTextAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.BorderDashStyleEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.HorizontalAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.LocationMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.MarginMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.SizeMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.StretchEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.VerticalAlignmentEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import java.util.List;
import examples.Utils;

public class Signature_Java_Search_Collection_Signature {

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

			SearchBarcodeOptions barcodeOptions = new SearchBarcodeOptions();
			barcodeOptions.setDocumentType(DocumentTypeEnum.WORDPROCESSING);
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

			barcodeOptions.setBarcodeType("Code39Standard");
			barcodeOptions.setText("123456789012");
			barcodeOptions.setMatchType(MatchTypeEnum.CONTAINS);

			SearchDigitalOptions digitalOptions = new SearchDigitalOptions();
			digitalOptions.setDocumentType(DocumentTypeEnum.WORDPROCESSING);
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
			System.out.println("Expected response type is SearchResult : Length = " + response.getSignatures());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}