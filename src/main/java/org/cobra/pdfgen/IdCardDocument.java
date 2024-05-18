package org.cobra.pdfgen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.cobra.models.CompanyDetails;
import org.cobra.models.EmpDetails;
import org.cobra.models.Library;
import org.cobra.ui.CustomErrorMessage;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.AreaBreakType;

public class IdCardDocument {

	public void getDocument(Library lib, String path, List<EmpDetails> employees, String validDate,CompanyDetails companyDetails) {

		try (PdfWriter writer = new PdfWriter(path)) {

			PdfDocument pdfDoc = new PdfDocument(writer);
			pdfDoc.addNewPage();
			pdfDoc.setDefaultPageSize(PageSize.A4.rotate());

			Document doc = new Document(pdfDoc);
			doc.setMargins(10, 5, 5, 10);
			Table col = new Table(new float[] { 305, 305 });
			int i=1;
			for (EmpDetails emp : employees) {
				
				Table main = new IdCardDesign().whiteBackgroundDesign(lib, path, emp, validDate, companyDetails);

				col.addCell(new Cell().add(main));
				if( i==employees.size()) {
					doc.add(col);
					break;
				}

				if (i % 6 == 0) {
					doc.add(col);
					System.out.println(i+" pagebreak");
					AreaBreak areaBreak = new AreaBreak(AreaBreakType.NEXT_PAGE);
					areaBreak.setPageSize(PageSize.A4);
					doc.add(new Cell().add(new Paragraph("_______________________")));
					doc.add(new Cell().add(new Paragraph("_______________________")));
					col = new Table(new float[] { 300, 300 });
					doc.add(areaBreak);
					
					
					
				}

				i++;
			}

			doc.close();
			CustomErrorMessage.showMessage("PDF genrated");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			CustomErrorMessage.showMessage(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CustomErrorMessage.showMessage(e.getMessage());
		}

	}

}
