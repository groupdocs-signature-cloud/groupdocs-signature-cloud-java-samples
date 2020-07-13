package examples.AdvancedUsage.Sign;

import com.groupdocs.cloud.signature.api.SignApi;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.FileInfo;
import com.groupdocs.cloud.signature.model.InfoSettings;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.Padding;
import com.groupdocs.cloud.signature.model.PagesSetup;
import com.groupdocs.cloud.signature.model.SaveOptions;
import com.groupdocs.cloud.signature.model.SignBarcodeOptions;
import com.groupdocs.cloud.signature.model.SignBarcodeOptions.CodeTextAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignResult;
import com.groupdocs.cloud.signature.model.SignSettings;
import com.groupdocs.cloud.signature.model.SignTextOptions.HorizontalAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.LocationMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.MarginMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.SizeMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.StretchEnum;
import com.groupdocs.cloud.signature.model.SignTextOptions.VerticalAlignmentEnum;
import com.groupdocs.cloud.signature.model.requests.CreateSignaturesRequest;

import examples.Constants;

public class BarcodeSignature {

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

			SignBarcodeOptions options = new SignBarcodeOptions();
			options.setSignatureType(SignatureTypeEnum.BARCODE);

			// set signature properties
			options.setText("123456789012");
			options.setBarcodeType("Code128");
			options.setCodeTextAlignment(CodeTextAlignmentEnum.NONE);

			// set signature position on a page
			options.setLeft(100);
			options.setTop(100);
			options.setWidth(300);
			options.setHeight(100);
			options.setLocationMeasureType(LocationMeasureTypeEnum.PIXELS);
			options.setSizeMeasureType(SizeMeasureTypeEnum.PIXELS);
			options.setStretch(StretchEnum.NONE);
			options.setRotationAngle(0);
			options.setHorizontalAlignment(HorizontalAlignmentEnum.NONE);
			options.setVerticalAlignment(VerticalAlignmentEnum.NONE);

			Padding padding = new Padding();
			padding.setAll(5);
			options.setMargin(padding);
			options.setMarginMeasureType(MarginMeasureTypeEnum.PIXELS);

			Color backgroundColor = new Color();
			backgroundColor.setWeb("DarkOrange");
			options.setBackgroundColor(backgroundColor);

			Padding innerMargins = new Padding();
			innerMargins.setAll(2);
			options.setInnerMargins(innerMargins);

			//set pages for signing (each of these page settings could be used singly)
			options.setPage(1);
			options.setAllPages(true);

			PagesSetup pagesSetup = new PagesSetup();
			pagesSetup.setEvenPages(false);
			pagesSetup.setFirstPage(true);
			pagesSetup.setLastPage(false);
			pagesSetup.setOddPages(false);
			pagesSetup.addPageNumbersItem(1);
			options.setPagesSetup(pagesSetup);

			SaveOptions saveOptions = new SaveOptions();
			saveOptions.setOutputFilePath("Signaturedocs\\signedBarcodeOne_page.docx");
			
			SignSettings signSettings = new SignSettings();
			signSettings.setFileInfo(fileInfo);
			signSettings.addOptionsItem(options);
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