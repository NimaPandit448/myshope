package com.myshope.myshope;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Doctopdf {
	
	public static void main(String[] args) {
		
	}

	
	  public void convertDocToPdf(String docFilePath, String pdfFilePath) throws IOException {
	        FileInputStream fis = new FileInputStream(new File(docFilePath));
	        XWPFDocument document = new XWPFDocument(fis);

	        FileOutputStream fos = new FileOutputStream(new File(pdfFilePath));
	        Document pdfDoc = new Document();
	        PdfWriter.getInstance(pdfDoc, fos);
	        pdfDoc.open();

	        document.write(pdfDoc);
	        pdfDoc.close();
	        fos.close();
	        fis.close();
	    }
	
}
