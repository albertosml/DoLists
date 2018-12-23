/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dolists;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class OperacionesPDF {
    
    public OperacionesPDF() {}
    
    public String generatePDFLista(ArrayList<String> datos, String directorio, String titulo) throws FileNotFoundException, DocumentException, ClassNotFoundException, SQLException {
        OperacionesBD o = new OperacionesBD();
        
        String ruta_pdf = directorio + "/" + titulo + ".pdf";

        try {
            Document doc = new Document(PageSize.A4);

            PdfWriter.getInstance(doc, new FileOutputStream(ruta_pdf));
            doc.open();

            doc.add(new Paragraph(" "));
            doc.add( Chunk.NEWLINE );
            
            Font f = new Font(Font.FontFamily.TIMES_ROMAN,24,Font.BOLD);

            Paragraph par = new Paragraph();
            par.setAlignment(Element.ALIGN_CENTER);
            par.setFont(f);
            par.add(titulo);
            doc.add(par);

            doc.add( Chunk.NEWLINE );
            doc.add( Chunk.NEWLINE );
 
            f = new Font(Font.FontFamily.TIMES_ROMAN, 13f);

            for(String p : datos) {
                par = new Paragraph();
                par.setFont(f);
                par.add("          " + p);
                doc.add(par);
            }
    
            doc.close();

            return "";
        } catch (DocumentException | FileNotFoundException e) {
            return "error";
        }
    }
}
