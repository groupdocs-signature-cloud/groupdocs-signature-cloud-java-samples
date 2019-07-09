package examples.Signing_Documents;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.client.Configuration;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.DocumentTypeEnum;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.HorizontalAlignmentEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.LocationMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.MarginMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.SizeMeasureTypeEnum;
import com.groupdocs.cloud.signature.model.SignImageOptions.VerticalAlignmentEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import java.util.List;
import examples.Utils;

public class Signature_Java_Stamp_Signature {

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

			SignStampOptions options = new SignStampOptions();
			options.setDocumentType(DocumentTypeEnum.WORDPROCESSING);
			options.setSignatureType(SignatureTypeEnum.STAMP);

			Color cornflowerBlueColor = new Color();
			cornflowerBlueColor.setWeb("CornflowerBlue");
			
			Color goldColor = new Color();
			goldColor.setWeb("Gold");
			
			Color blueVioletColor = new Color();
			blueVioletColor.setWeb("BlueViolet");
			
			Color darkOrangeColor = new Color();
			darkOrangeColor.setWeb("DarkOrange");
			
			Color oliveDrabColor = new Color();
			oliveDrabColor.setWeb("OliveDrab");
			
			Color ghostWhiteColor = new Color();
			ghostWhiteColor.setWeb("GhostWhite");

			// set signature properties
			options.setImageGuid("Signaturedocs\\signature.jpg");

			// set signature position on a page
			options.setLeft(100);
			options.setTop(100);
			options.setWidth(300);
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

			// set signature appearance
			options.setBackgroundColor(cornflowerBlueColor);
			options.setBackgroundColorCropType(SignStampOptions.BackgroundColorCropTypeEnum.INNERAREA);
			options.setBackgroundImageCropType(SignStampOptions.BackgroundImageCropTypeEnum.MIDDLEAREA);
			options.setOpacity(0.8);

			//Outer line
			StampLine outerLine = new StampLine();
			outerLine.setText("John Smith");
			
			SignatureFont outerLineFont = new SignatureFont();
			outerLineFont.setFontFamily("Arial");
			outerLineFont.setFontSize(12.0);
			outerLineFont.setBold(true);
			outerLineFont.setItalic(true);
			outerLineFont.setUnderline(true);
			outerLine.setFont(outerLineFont);
			outerLine.setTextBottomIntent(5);
			outerLine.setTextColor(goldColor);
			outerLine.setTextRepeatType(StampLine.TextRepeatTypeEnum.FULLTEXTREPEAT);
			outerLine.setBackgroundColor(blueVioletColor);
			outerLine.setHeight(20);

			BorderLine outerLineInnerBorder = new BorderLine();
			outerLineInnerBorder.setColor(darkOrangeColor);
			outerLineInnerBorder.setStyle(BorderLine.StyleEnum.LONGDASH);
			outerLineInnerBorder.setTransparency(0.5);
			outerLineInnerBorder.setWeight(1.2);
			outerLine.setInnerBorder(outerLineInnerBorder);

			BorderLine outerLineOuterBorder = new BorderLine();
			outerLineOuterBorder.setColor(darkOrangeColor);
			outerLineOuterBorder.setStyle(BorderLine.StyleEnum.LONGDASHDOT);
			outerLineOuterBorder.setTransparency(0.7);
			outerLineOuterBorder.setWeight(1.4);
			outerLine.setOuterBorder(outerLineOuterBorder);

			outerLine.setVisible(true);
			options.addOuterLinesItem(outerLine);

			//Inner line
			StampLine innerLine = new StampLine();
			innerLine.setText("John Smith");
			
			SignatureFont innerLineFont = new SignatureFont();
			innerLineFont.setFontFamily("Times New Roman");
			innerLineFont.setFontSize(20.0);
			innerLineFont.setBold(true);
			innerLineFont.setItalic(true);
			innerLineFont.setUnderline(true);
			innerLine.setFont(innerLineFont);
			innerLine.setTextBottomIntent(3);
			innerLine.setTextColor(goldColor);
			innerLine.setTextRepeatType(StampLine.TextRepeatTypeEnum.NONE);
			innerLine.setBackgroundColor(cornflowerBlueColor);
			innerLine.setHeight(30);

			BorderLine innerLineInnerBorder = new BorderLine();
			innerLineInnerBorder.setColor(oliveDrabColor);
			innerLineInnerBorder.setStyle(BorderLine.StyleEnum.LONGDASH);
			innerLineInnerBorder.setTransparency(0.5);
			innerLineInnerBorder.setWeight(1.2);
			innerLine.setInnerBorder(innerLineInnerBorder);

			BorderLine innerLineOuterBorder = new BorderLine();
			innerLineOuterBorder.setColor(ghostWhiteColor);
			innerLineOuterBorder.setStyle(BorderLine.StyleEnum.DOT);
			innerLineOuterBorder.setTransparency(0.4);
			innerLineOuterBorder.setWeight(1.4);
			innerLine.setOuterBorder(innerLineOuterBorder);

			innerLine.setVisible(true);
			options.addInnerLinesItem(innerLine);

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
			saveOptions.setOutputFilePath("Signaturedocs\\signedStamp_one-page.docx");
			
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