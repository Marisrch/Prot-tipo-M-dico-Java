
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

public class Atestado_DAO {
    public static void imprime()throws Exception {
 
        Document doc = null;
        OutputStream os = null;
       
    String x = JOptionPane.showInputDialog(null, "Digite o seu nome ?");
    String y = JOptionPane.showInputDialog(null, "Digite a data  ?"); 
    String z = JOptionPane.showInputDialog(null,"a sua doença ?");
    String a = JOptionPane.showInputDialog(null, "Digite a sua identidade ?");
    String b = JOptionPane.showInputDialog(null, "quantos dias de atestado ?");

 
  try {
      
 
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
 
            //cria a stream de saída
            os = new FileOutputStream("Relatorio1.pdf");
 
            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);
 
            //abre o documento
            doc.open();
 
             Paragraph p1= new Paragraph ("ATESTADO MEDICO");
             p1.setAlignment(Element.ALIGN_CENTER);
             
            //adiciona o texto ao PDF
            Paragraph par = new Paragraph("Atesto para " );
            par.setAlignment(Element.ALIGN_CENTER);
            Paragraph par3 = new Paragraph("que o SRº " + x + "Portador da identidade nº " + a +  " esteve sob cuidados medicos no dia " + y + " e deverá se afatar de suas atividades pelo periodo de " + " até " + b + " Por motivos de " + z  );
     
          
           
           doc.add(p1);
          
           doc.add(par);
           doc.add(par3);
           
           
           
        
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
        Desktop.getDesktop().open(new File("Relatorio1.pdf"));
    }
    
}
