package examples.Signing_Documents;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.DocumentTypeEnum;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.SignQRCodeOptions.CodeTextAlignmentEnum;
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

public class Signature_Java_QRCode_Signature {

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

			SignTextOptions options = new SignTextOptions();
			options.setDocumentType(DocumentTypeEnum.WORDPROCESSING);
			options.setSignatureType(SignatureTypeEnum.QRCODE);

			// set signature properties
			options.setText("GroupDocs.Signature Cloud");
			options.setQrCodeType("Aztec");
			options.setCodeTextAlignment(CodeTextAlignmentEnum.NONE);

			// set signature position on a page
			options.setLeft(100);
			options.setTop(100);
			options.setWidth(200);
			options.setHeight(200);
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

			// set signature appearance
			Color foreColor = new Color();
			foreColor.setWeb("BlueViolet");
			options.setForeColor(foreColor);
			
			Color borderColor = new Color();
			borderColor.setWeb("DarkOrange");
			options.setBorderColor(borderColor);
			
			Color backgroundColor = new Color();
			backgroundColor.setWeb("DarkOrange");
			options.setBackgroundColor(backgroundColor);
			options.setOpacity(0.8);
			
			Padding innerMargins = new Padding();
			innerMargins.setAll(2);
			options.setInnerMargins(innerMargins);
			options.setBorderVisiblity(true);
			options.setBorderDashStyle(BorderDashStyleEnum.DASH);
			options.setBorderWeight(12.0);

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
			saveOptions.setOutputFilePath("Signaturedocs\\signedQRCode_one-page.docx");
			
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