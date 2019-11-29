package Test.Screen;

import java.io.File;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Readimage {
@Test
public void getImgText() {
//	captureScreenshot(filePath);
//	TessBaseAPI api = new TessBaseAPI();
//	api.Init("‪D:/eng","eng");
//	PIX image = lept.pixRead("C:\\HaudAPI\\CombineFramework\\Andriodscreenshot\\toastmessage1.png");
    // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

	File imageFile = new File("C:\\HaudAPI\\CombineFramework\\Andriodscreenshot\\toastmessage1.png");

        Tesseract tesseract = new Tesseract(); 
        try { 
  
            tesseract.setDatapath("‪‪D:/eng (1)"); 
  
            // the path of your tess data folder 
            // inside the extracted file 
            String text 
                = tesseract.doOCR(imageFile); 
  
            // path of your image file 
            System.out.print(text); 
        } 
        catch (TesseractException e) { 
            e.printStackTrace(); 
        } 
    } 
}

