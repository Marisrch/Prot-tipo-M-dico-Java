
package Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;


public class Receituario_DAO {
     public static void imprime()throws Exception {
 
        Document doc = null;
        OutputStream os = null;
        Paragraph p1= new Paragraph ("Receituário");
        String x = JOptionPane.showInputDialog(null, "Digite o seu nome ?");
        String y = JOptionPane.showInputDialog(null, "Digite o CRM  ?"); 
        String w = JOptionPane.showInputDialog(null, "qual o nome do paciente ?");
        
         
 
  try {
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Relatorio2.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
 
            //adiciona o texto ao PDF
            
            Paragraph par = new Paragraph("Nome : "+ x +"  \n" + "CRM:  " + y );
            doc.add(par);
            
             Paragraph p2= new Paragraph ("Receituário");
             p2.setAlignment(Element.ALIGN_CENTER);
             doc.add(p2);
            Paragraph par1 = new Paragraph("Paciente : " + w);
            doc.add(par1);
 
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
        Desktop.getDesktop().open(new File("Relatorio2.pdf"));
    }
    
}
