
package Controller;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;


public class Comparecimento_DAO {
     public static void imprime()throws Exception {
 
        Document doc = null;
        OutputStream os = null;
        Paragraph p3= new Paragraph ("Comparecimento");
        
        String a = JOptionPane.showInputDialog(null, "Para que fim essa declaração será feita?");
        String b = JOptionPane.showInputDialog(null, "Digite seu nome  ?");  
        String c = JOptionPane.showInputDialog(null, "Data do comparecimento  ?");  
        String d = JOptionPane.showInputDialog(null, "Hora de chegada ?"); 
        String e = JOptionPane.showInputDialog(null, "Hora de saída ?"); 
 
  try {
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Relatorio3.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
 
            //adiciona o texto ao PDF
            Paragraph p2= new Paragraph ("DECLARAÇÃO DE COMPARECIMENTO");
             p2.setAlignment(Element.ALIGN_CENTER);
             doc.add(p2);
             
             
            Paragraph par = new Paragraph("Declaro para fins " + a +"  que o(a) Sr.(a). " + b + " esteve em consulta odontológica no dia"+ c + " durante o período "+ d + " e "+ e);
            doc.add(par);
           
 
        } finally {
 
            if (doc != null) {
 
                //fechamento do documento
                doc.close();
            }
 
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
        Desktop.getDesktop().open(new File("Relatorio3.pdf"));
    }
    
}
