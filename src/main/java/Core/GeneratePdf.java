package Core;

import Dao.OperationDao;
import Model.OperationModel;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;


import java.io.FileNotFoundException;

public class GeneratePdf {

    public String dest;
    public PdfDocument pdf;
    public Document document;
    public PdfWriter writer;
    public OperationDao operationDao = new OperationDao();

    public GeneratePdf(int clickCount, String slug, int cptNum, String name, String surname, double currentBalance) {




        try {
            this.dest = "download/" + slug + "-" + clickCount + ".pdf";
            this.writer = new PdfWriter(this.dest);
            this.pdf = new PdfDocument(writer);
            this.document = new Document(pdf);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.add(new Paragraph("Relevé des opérations pour le compte " + cptNum));
        document.add(new Paragraph("Nom: " +name));
        document.add(new Paragraph("Prénom: " +surname));


        Table table = new Table(5);
        table.setMarginTop(30);
        table.addHeaderCell("Numéro Opération");
        table.addHeaderCell("Numéro de Compte");
        table.addHeaderCell("Type d'opération");
        table.addHeaderCell("Montant de l'opération");
        table.addHeaderCell("Date de l'opération");

        for(OperationModel opeList : this.operationDao.operationDetails(cptNum)) {

            table.addCell(String.valueOf(opeList.getOperationID()));
            table.addCell(String.valueOf(opeList.getOperationAccountNumber()));
            table.addCell(String.valueOf(opeList.getOperationType()));
            table.addCell(String.valueOf(opeList.getOperationAmount()));
            table.addCell(String.valueOf(opeList.getOperationDate()));
        }
        Table table1 = new Table(2);
        table1.setMarginTop(30);
        table1.addFooterCell("Solde du compte");
        table1.addFooterCell(String.valueOf(currentBalance));
        document.add(table);
        document.add(table1);
        document.close();

    }
}
