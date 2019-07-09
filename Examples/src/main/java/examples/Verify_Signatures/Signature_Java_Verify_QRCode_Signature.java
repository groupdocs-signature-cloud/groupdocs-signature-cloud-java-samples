package examples.Verify_Signatures;

import com.groupdocs.cloud.signature.api.*;
import com.groupdocs.cloud.signature.client.ApiException;
import com.groupdocs.cloud.signature.client.Configuration;
import com.groupdocs.cloud.signature.model.*;
import com.groupdocs.cloud.signature.model.OptionsBase.DocumentTypeEnum;
import com.groupdocs.cloud.signature.model.OptionsBase.SignatureTypeEnum;
import com.groupdocs.cloud.signature.model.VerifyTextOptions.MatchTypeEnum;
import com.groupdocs.cloud.signature.model.requests.*;
import java.util.List;
import examples.Utils;

public class Signature_Java_Verify_QRCode_Signature {

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

			VerifyQRCodeOptions options = new VerifyQRCodeOptions();
			options.setDocumentType(DocumentTypeEnum.WORDPROCESSING);
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

			VerifySettings verifySettings = new VerifySettings();
			verifySettings.setFileInfo(fileInfo);
			verifySettings.addOptionsItem(options);

			VerifySignaturesRequest request = new VerifySignaturesRequest(verifySettings);

			VerifyResult  response = apiInstance.verifySignatures(request);
			System.out.println("Expected response type is VerifyResult : IsSuccess = " + response.getIsSuccess());
        } catch (ApiException e) {
            System.err.println("Exception while calling SignApi:");
            e.printStackTrace();
        }
	}
}