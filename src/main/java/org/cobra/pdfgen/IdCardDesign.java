package org.cobra.pdfgen;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.*;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;

import org.cobra.models.CompanyDetails;
import org.cobra.models.EmpDetails;
import org.cobra.models.Library;
import org.cobra.services.UserTable;
import org.cobra.ui.CustomErrorMessage;

import java.io.IOException;

import java.net.URL;

public class IdCardDesign {
	public Table whiteBackgroundDesign(Library lib, String path, EmpDetails emp, String validDate,
			CompanyDetails company) {

		try {
			// add Logo
			ImageData data = ImageDataFactory.create(lib.getLogoPath());
			Image logo = new Image(data);
			logo.setWidth(50);
			logo.setHeight(50);

			// emp images
			String empImage = emp.getPhotoUrl() == null ? lib.getFramePath() : emp.getPhotoUrl();
			ImageData profile = ImageDataFactory.create(empImage);
			Image pic = new Image(profile);
			logo.setWidth(50);
			logo.setHeight(50);

			// add gradient
			ImageData gradients = ImageDataFactory.create(lib.getGradientPath());
			Image gradientImage = new Image(gradients);

			// add paragraph
			// company Details;
			String companyName = company.getCompanyName() + "\n";
			String companyLocation = company.getCompanyLocation() + "\n";
			String companyMob = company.getCompanyMob() + "\n";
			String companyReg = company.getCompanyReg() + "\n";

			// Signature Texts
			String[] sign = { "Employee's Signature", "Valid Up To", "Authorised Signatory" };

			// global style variables
			PdfFont boldTxt = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
//            PdfFont regRobotoFont= PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
			PdfFont regRobotoFont = PdfFontFactory.createFont(lib.getFont());
//            PdfFont title_sedan_font= PdfFontFactory.createFont(title_SedanFontPath);
			int fontSize = 9;
//            Color color_deep_blue =  CalRgb.createColorWithColorSpace(new float[]{0f,0f,250f});
			Color color_deep_blue = new DeviceRgb(0, 0, 102);
//            Color color_red =  CalRgb.createColorWithColorSpace(new float[]{255f,0f,0f});
			Color color_red = new DeviceRgb(255, 0, 0);

			// style the company text

			Text companyNameTxt = new Text(companyName.toUpperCase()).setFont(boldTxt).setFontSize(fontSize)
					.setFontColor(color_deep_blue);
			Text companyLocationTxt = new Text(companyLocation).setFont(boldTxt).setFontSize(fontSize - 2)
					.setFontColor(color_deep_blue);
			Text companyMobTxt = new Text(companyMob).setFont(boldTxt).setFontSize(fontSize - 2)
					.setFontColor(color_deep_blue);
			Text companyRegTxt = new Text(companyReg).setFont(regRobotoFont).setFontSize(fontSize - 2)
					.setFontColor(color_red);
			// sign

			Text empSignTxt = new Text(sign[0]).setFont(boldTxt).setFontSize(fontSize - 1)
					.setFontColor(color_deep_blue);
			Text validToTxt = new Text(validDate + "\n" + sign[1]).setFont(boldTxt).setFontSize(fontSize - 1)
					.setFontColor(color_red);
			Text authSignTxt = new Text(sign[2]).setFont(boldTxt).setFontSize(fontSize - 1)
					.setFontColor(color_deep_blue);

			Paragraph companyDetails = new Paragraph(companyNameTxt);
			companyDetails.add(companyLocationTxt);
			companyDetails.add(companyMobTxt);
			companyDetails.add(companyRegTxt);

			Paragraph empSignPara = new Paragraph().add(empSignTxt);
			Paragraph validPara = new Paragraph().add(validToTxt);
			Paragraph authSignPara = new Paragraph().add(authSignTxt);

//            PdfDocument pdfDoc = new PdfDocument(writer);
//            pdfDoc.addNewPage();
//            pdfDoc.setDefaultPageSize(PageSize.A4.rotate());
//            
//            
//            Document doc = new Document(pdfDoc);
//            doc.setMargins(10, 10, 10, 10);

			Table companyHeadTable = new Table(new float[] { 50f, 250f });
			companyHeadTable.addCell(new Cell().add(logo).setBorder(Border.NO_BORDER));
			companyHeadTable.addCell(
					new Cell().add(companyDetails).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));

			// test employee table with data
			Table employeeTable = employeeDetailTable(emp, gradientImage, boldTxt, fontSize, color_deep_blue);

			Table companyBodyTable = new Table(new float[] { 220f, 80f });
			companyBodyTable.addCell(new Cell().add(employeeTable).setBorder(Border.NO_BORDER));

			companyBodyTable.addCell(new Cell().add(pic.scaleToFit(60, 80)).setBorder(Border.NO_BORDER));

			Table companyFooterTable = new Table(new float[] { 100, 100, 100 });
			companyFooterTable.addCell(new Cell().add(empSignPara).setPaddingTop(20)
					.setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
			companyFooterTable.addCell(new Cell().add(validPara).setPaddingTop(5).setTextAlignment(TextAlignment.CENTER)
					.setBorder(Border.NO_BORDER));
			companyFooterTable.addCell(new Cell().add(authSignPara).setPaddingTop(20)
					.setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));

//            doc.add(companyHeadTable);
//            doc.add(companyBodyTable);
//            doc.add(companyFooterTable);

			// Main table with box
			Table main = new Table(new float[] { 300 });
			main.addCell(new Cell().add(companyHeadTable).setBorderBottom(Border.NO_BORDER));
			main.addCell(
					new Cell().add(companyBodyTable).setBorderBottom(Border.NO_BORDER).setBorderTop(Border.NO_BORDER));
			main.addCell(new Cell().add(companyFooterTable).setBorderTop(Border.NO_BORDER));
			main.setBackgroundColor(lib.getMain_background_color());

//            doc.add(main);
//            doc.add(TestingTable);
//            doc.close();

			System.out.println("pdf created");
			return main;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    catch (IOException e) {
//        	  CustomErrorMessage.showMessage(e.getMessage());
//            throw new RuntimeException(e);
//  }
//        catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	catch (Exception e) {
//            CustomErrorMessage.showMessage(e.getMessage());
//		}
		return null;

	}

	private Table employeeDetailTable(EmpDetails emp, Image gradientImage, PdfFont boldTxt, int fontSize,
			Color color_deep_blue) {
		// employee Details no. of character is 50.

		UserTable employeeTables = new UserTable();

		Table empDetailsTable = new Table(new float[] { 220 });
		empDetailsTable
				.addCell(new Cell().add(employeeTables.getEmpNameAndAddress(emp, boldTxt, fontSize, color_deep_blue))
						.setBorder(Border.NO_BORDER));
		empDetailsTable.addCell(new Cell().add(employeeTables.getEmpPost(emp, boldTxt, fontSize, color_deep_blue))
				.setBorder(Border.NO_BORDER));
		empDetailsTable
				.addCell(new Cell().add(employeeTables.getDobAndBloodGroup(emp, boldTxt, fontSize, color_deep_blue))
						.setBorder(Border.NO_BORDER));

		Table employeeTable = new Table(new float[] { 220 });
		Cell test_cell = new Cell().add(empDetailsTable).setBorder(Border.NO_BORDER);
		test_cell.setNextRenderer(new ImageBackgroundCellRenderer(test_cell, gradientImage));
		employeeTable.addCell(test_cell);

		return employeeTable;
	}

	private static class ImageBackgroundCellRenderer extends CellRenderer {
		protected Image img;

		public ImageBackgroundCellRenderer(Cell modelElement, Image img) {
			super(modelElement);
			this.img = img;
		}

		// If a renderer overflows on the next area, iText uses #getNextRenderer()
		// method to create a new renderer for the overflow part.
		// If #getNextRenderer() isn't overridden, the default method will be used and
		// thus the default rather than the custom
		// renderer will be created
		@Override
		public IRenderer getNextRenderer() {
			return new ImageBackgroundCellRenderer((Cell) modelElement, img);
		}

		@Override
		public void draw(DrawContext drawContext) {
			img.scaleToFit(getOccupiedAreaBBox().getWidth(), getOccupiedAreaBBox().getHeight());
			drawContext.getCanvas().addXObjectFittedIntoRectangle(img.getXObject(), getOccupiedAreaBBox());
			super.draw(drawContext);
		}
	}

	protected static String createImageIcon(String path) {
		URL imgURL = IdCardDesign.class.getResource(path);
		if (imgURL != null) {
			return imgURL.getPath();
		} else {
			CustomErrorMessage.showMessage("line - 232");
			return null;
		}
	}
}
