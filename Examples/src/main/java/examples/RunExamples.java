package examples;

import examples.BasicUsage.*;
import examples.AdvancedUsage.Sign.*;
import examples.AdvancedUsage.Update.*;
import examples.AdvancedUsage.Delete.*;
import examples.AdvancedUsage.Search.*;
import examples.AdvancedUsage.Verify.*;

public class RunExamples {

	public static void main(String[] args) {

		// Upload files
		UploadResources.main(args);

		// Basic usage examples

		GetSupportedFormats.main(args);
		GetDocumentInfo.main(args);
		GetDocumentPreview.main(args);
		GetSupportedBarcodeTypes.main(args);
		GetSupportedQrCodeTypes.main(args);

		// Advanced examples
		
		BarcodeSignature.main(args);
		SearchBarcode.main(args);
		VerifyBarcode.main(args);
		UpdateBarcode.main(args);
		DeleteBarcode.main(args);

		CollectionSignature.main(args);
		SearchCollection.main(args);
		VerifyCollection.main(args);

		QRCodeSignature.main(args);
		SearchQRCode.main(args);
		VerifyQRCode.main(args);	
		UpdateQRCode.main(args);
		DeleteQRCode.main(args);
		
		DigitalSignature.main(args);
		SearchDigital.main(args);
		VerifyDigital.main(args);	
		
		TextSignature.main(args);		
		VerifyText.main(args);	
		
		ImageSignature.main(args);
		StampSignature.main(args);

		System.out.println("Completed");
	}	
}