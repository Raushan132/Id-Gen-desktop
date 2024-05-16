package org.cobra.pdfgen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.cobra.models.EmpDetails;
import org.cobra.models.Library;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

public class IdCardDocument {
	
	public void getDocument(Library lib,String path,List<EmpDetails> employees,String validDate) {
		
		 try (PdfWriter writer = new PdfWriter(path)) {
			 
			 PdfDocument pdfDoc = new PdfDocument(writer);
	            pdfDoc.addNewPage();
	            pdfDoc.setDefaultPageSize(PageSize.A4.rotate());
	            
	            
	            Document doc = new Document(pdfDoc);
	            doc.setMargins(10, 10, 10, 10);
	            doc.close();
			 
			 
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
