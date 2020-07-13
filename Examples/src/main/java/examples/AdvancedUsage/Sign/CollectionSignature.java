package examples.AdvancedUsage.Sign;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.SignBarcodeOptions.CodeTextAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.*;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class CollectionSignature {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\one-page.docx");
			fileInfo.setPassword(null);
			fileInfo.setVersionId(null);
			fileInfo.setStorageName(Constants.MYStorage);
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			SignBarcodeOptions barcodeOptions = new SignBarcodeOptions();
			barcodeOptions.setSignatureType(SignatureTypeEnum.BARCODE);

			// set signature properties
			barcodeOptions.setText("123456789012");
			barcodeOptions.setBarcodeType("Code128");
			barcodeOptions.setCodeTextAlignment(CodeTextAlignmentEnum.NONE);

			// set signature position on a page
			barcodeOptions.setLeft(100);
			barcodeOptions.setTop(100);
			barcodeOptions.setWidth(300);
			barcodeOptions.setHeight(100);
			barcodeOptions.setLocationMeasureType(LocationMeasureTypeEnum.PIXELS);
			barcodeOptions.setSizeMeasureType(SizeMeasureTypeEnum.PIXELS);
			barcodeOptions.setStretch(StretchEnum.NONE);
			barcodeOptions.setRotationAngle(0);
			barcodeOptions.setHorizontalAlignment(HorizontalAlignmentEnum.NONE);
			barcodeOptions.setVerticalAlignment(VerticalAlignmentEnum.NONE);

			Padding padding = new Padding();
			padding.setAll(5);
			barcodeOptions.setMargin(padding);
			barcodeOptions.setMarginMeasureType(MarginMeasureTypeEnum.PIXELS);

			Color backgroundColor = new Color();
			backgroundColor.setWeb("DarkOrange");
			barcodeOptions.setBackgroundColor(backgroundColor);

			Padding innerMargins = new Padding();
			innerMargins.setAll(2);
			barcodeOptions.setInnerMargins(innerMargins);

			//set pages for signing (each of these page settings could be used singly)
			barcodeOptions.setPage(1);
			barcodeOptions.setAllPages(true);

			PagesSetup pagesSetup = new PagesSetup();
			pagesSetup.setEvenPages(false);
			pagesSetup.setFirstPage(true);
			pagesSetup.setLastPage(false);
			pagesSetup.setOddPages(false);
			pagesSetup.addPageNumbersItem(1);
			barcodeOptions.setPagesSetup(pagesSetup);
			barcodeOptions.setTop(0);

			SignTextOptions textOptions = new SignTextOptions();
			textOptions.setSignatureType(SignatureTypeEnum.TEXT);

			// set signature properties
			textOptions.setText("John Smith");

			// set signature position on a page
			textOptions.setLeft(100);
			textOptions.setTop(100);
			textOptions.setWidth(100);
			textOptions.setHeight(100);
			textOptions.setLocationMeasureType(LocationMeasureTypeEnum.PIXELS);
			textOptions.setSizeMeasureType(SizeMeasureTypeEnum.PIXELS);
			textOptions.setStretch(StretchEnum.NONE);
			textOptions.setRotationAngle(0);
			textOptions.setHorizontalAlignment(HorizontalAlignmentEnum.NONE);
			textOptions.setVerticalAlignment(VerticalAlignmentEnum.NONE);
			
			padding = new Padding();
			padding.setAll(5);
			textOptions.setMargin(padding);
			textOptions.setMarginMeasureType(MarginMeasureTypeEnum.PIXELS);
			
			
			backgroundColor = new Color();
			backgroundColor.setWeb("DarkOrange");
			textOptions.setBackgroundColor(backgroundColor);

			//set pages for signing (each of these page settings could be used singly)
			textOptions.setPage(1);
			textOptions.setAllPages(true);
			
			pagesSetup = new PagesSetup();
			pagesSetup.setEvenPages(false);
			pagesSetup.setFirstPage(true);
			pagesSetup.setLastPage(false);
			pagesSetup.setOddPages(false);
			pagesSetup.addPageNumbersItem(1);
			textOptions.setPagesSetup(pagesSetup);

			SaveOptions saveOptions = new SaveOptions();
			saveOptions.setOutputFilePath("Signaturedocs\\signedCollectionOne_page.docx");
			
			SignSettings signSettings = new SignSettings();
			signSettings.setFileInfo(fileInfo);
			signSettings.addOptionsItem(barcodeOptions);
			signSettings.addOptionsItem(textOptions);
			signSettings.setSaveOptions(saveOptions);
			
			CreateSignaturesRequest request = new CreateSignaturesRequest(signSettings);

			SignResult response = apiInstance.createSignatures(request);
			System.out.println("Expected response type is SignResult: FilePath = " + response.getFileInfo().getFilePath());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}