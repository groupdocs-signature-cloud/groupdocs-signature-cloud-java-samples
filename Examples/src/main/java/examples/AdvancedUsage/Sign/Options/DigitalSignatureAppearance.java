package examples.AdvancedUsage.Sign.Options;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.HorizontalAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.LocationMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.MarginMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.SizeMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.VerticalAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignatureAppearance.AppearanceTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import examples.Constants;

public class DigitalSignatureAppearance {

	public static void main(String[] args) {

		SignApi apiInstance = new SignApi(Constants.GetConfiguration());

        try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("Signaturedocs\\sample2.pdf");
			fileInfo.setPassword(null);
			fileInfo.setVersionId(null);
			fileInfo.setStorageName(Constants.MYStorage);
			
            InfoSettings infoSettings = new InfoSettings();
			infoSettings.setFileInfo(fileInfo);

			SignDigitalOptions options = new SignDigitalOptions();
			options.setSignatureType(SignatureTypeEnum.DIGITAL);
			
			// set signature properties
			options.setImageFilePath("Signaturedocs\\signature.jpg");
			options.setCertificateFilePath("Signaturedocs\\temp.pfx");
			options.setPassword("1234567890");

			// set signature position on a page
			options.setLeft(100);
			options.setTop(100);
			options.setWidth(200);
			options.setHeight(200);
			options.setLocationMeasureType(LocationMeasureTypeEnum.PIXELS);
			options.setSizeMeasureType(SizeMeasureTypeEnum.PIXELS);
			options.setRotationAngle(0);
			options.setHorizontalAlignment(HorizontalAlignmentEnum.NONE);
			options.setVerticalAlignment(VerticalAlignmentEnum.NONE);
			
			Padding padding = new Padding();
			padding.setAll(5);
			options.setMargin(padding);
			options.setMarginMeasureType(MarginMeasureTypeEnum.PIXELS);

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

			PdfDigitalSignatureAppearance appearance = new PdfDigitalSignatureAppearance();
			appearance.setAppearanceType(AppearanceTypeEnum.PDFTEXTSTICKER);
			appearance.setContactInfoLabel("info@groupdocs.cloud");
			options.setAppearance(appearance);

			SaveOptions saveOptions = new SaveOptions();
			saveOptions.setOutputFilePath("Signaturedocs\\signedDigital_sample2.pdf");
			
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