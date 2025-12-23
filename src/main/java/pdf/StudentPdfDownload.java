package pdf;
/*
 * “Admin clicks download → servlet fetches student data from database → passes ResultSet to
 * a PDF utility class → iText library generates PDF → file is saved on system → user is 
 * redirected back to admin page.”
 * */
import java.io.FileOutputStream;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class StudentPdfDownload {

// this method is to download an student details 
	public static void generateStudentPdf(ResultSet rs, String path) {
		try {
			// empty document create kar to blank page PDF document create करतो (blank)
			Document doc = new Document();
			//specifys the location of the pdf where we want to save an pdf 
			// FileOutputStream to write the content in a file
			PdfWriter.getInstance(doc, new FileOutputStream(path));
			// open an document to write an content in it 
			doc.open();

		// specify the title in an pdf 
			Paragraph title = new Paragraph(
				"Student Report",
				new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD)
			);
			title.setAlignment(Element.ALIGN_CENTER);

			doc.add(title);
			doc.add(new Paragraph("\n"));

		//this class is used to create an table of 5 columns 
			PdfPTable table = new PdfPTable(5);
			table.addCell("ID");
			table.addCell("Name");
			table.addCell("Email");
			table.addCell("Contact");
			table.addCell("Department");

// it reads the data from the ResultSet line by line and each time single line read completely
// then one row completed i.e. one object created like that 
			while (rs.next()) {
				table.addCell(String.valueOf(rs.getInt("sid")));
				table.addCell(rs.getString("sname"));
				table.addCell(rs.getString("email"));
				table.addCell(rs.getString("contact"));
				table.addCell(rs.getString("dept"));
			}

			// this is used to add an table in a pdf
			doc.add(table);
			doc.close();

			System.out.println("PDF created at: " + path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// this method  is  to download an event pdf
    public static void generateEventPdf(ResultSet rs , String fileName){
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();

            Paragraph title = new Paragraph("Event Report",
                    new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);

            doc.add(title);
            doc.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(5);
            table.addCell("Event id");
            table.addCell("Event Name");
            table.addCell("Event Date");
            table.addCell("Event Venue");
            table.addCell("Event Capacity");

            while (rs.next()) {
                table.addCell(String.valueOf(rs.getInt("eid")));
                table.addCell(rs.getString("name"));
                table.addCell(rs.getString("edate"));
                table.addCell(rs.getString("venue"));
                table.addCell(rs.getString("capacity"));
            }

            doc.add(table);
            doc.close();

            System.out.println("\nPDF Created: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

// this method is to an download registered stuent details 
    
//  public static void generateregisteredStudentEventPdf(ResultSet rs , String fileName){
//	 try {
//	        Document doc = new Document();
//	        PdfWriter.getInstance(doc, new FileOutputStream(fileName));
//	        doc.open();
//
//	        Paragraph title = new Paragraph("Event Report",
//	                new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
//	        title.setAlignment(Element.ALIGN_CENTER);
//
//	        doc.add(title);
//	        doc.add(new Paragraph("\n"));
//
//	        PdfPTable table = new PdfPTable(5);
//	        table.addCell("ID");
//	        table.addCell("Name");
//	        table.addCell("Email");
//	        table.addCell("Contact");
//	        table.addCell("Department");
//
//	        while (rs.next()) {
//	            table.addCell(String.valueOf(rs.getInt("sid")));
//	            table.addCell(rs.getString("sname"));
//	            table.addCell(rs.getString("email"));
//	            table.addCell(rs.getString("contact"));
//	            table.addCell(rs.getString("dept"));
//	        }
//
//	        doc.add(table);
//	        doc.close();
//
//	        System.out.println("\nPDF Created: " + fileName);
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//}
}
