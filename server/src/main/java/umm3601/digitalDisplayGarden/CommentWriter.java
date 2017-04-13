package umm3601.digitalDisplayGarden;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

public class CommentWriter {

    OutputStream outputStream;
    XSSFWorkbook workbook;
    XSSFSheet commentSheet;
    XSSFSheet metadataSheet;
    int rowCountComments;
    MongoClient mongoClient;
    MongoDatabase test;
    MongoCollection plants;
    int rowCountMeta;

    public CommentWriter(OutputStream outputStream) throws IOException{
        this.outputStream = outputStream;

        this.workbook = new XSSFWorkbook();
        this.commentSheet = workbook.createSheet("Comments");
        this.metadataSheet = workbook.createSheet("MetaData");

        this.mongoClient = new MongoClient();
        this.test = mongoClient.getDatabase("test");
        this.plants = test.getCollection("plants");

        Row rowComment = commentSheet.createRow(0);
        Cell cell = rowComment.createCell(0);
        cell.setCellValue("#");

        cell = rowComment.createCell(1);
        cell.setCellValue("cultivar");

        cell = rowComment.createCell(2);
        cell.setCellValue("comment");

        cell = rowComment.createCell(3);
        cell.setCellValue("timestamp");

        rowCountComments = 1;

        Row rowMeta = metadataSheet.createRow(0);
        cell = rowMeta.createCell(0);
        cell.setCellValue("#");

        cell = rowMeta.createCell(1);
        cell.setCellValue("cultivar");

        cell = rowMeta.createCell(2);
        cell.setCellValue("likes");

        cell = rowMeta.createCell(3);
        cell.setCellValue("dislikes");

        cell = rowMeta.createCell(4);
        cell.setCellValue("page views");

        rowCountMeta = 1;
    }

    /**
     * Adds the given information as a new row to the sheet.
     * @param id: plant ID number
     * @param comment: comment left by visitor
     * @param timestamp: time the user left the comment
     */
    public void writeComment(String id, String comment, Date timestamp){
        Row row = commentSheet.createRow(rowCountComments);

        Cell cell = row.createCell(0);
        cell.setCellValue(id);

        Document filter = new Document("id", id);
        FindIterable<Document> plantIter = plants.find(filter);
        Document plant = plantIter.first();
        cell = row.createCell(1);
        cell.setCellValue(plant.getString("cultivar"));

        cell = row.createCell(2);
        cell.setCellValue(comment);

        cell = row.createCell(3);
        cell.setCellValue(timestamp.toString());

        rowCountComments++;
    }

    public void writeMetadata(String id, String cultivar, Document metadataDoc){
        Row row = metadataSheet.createRow(rowCountMeta);

        Cell cell = row.createCell(0);
        cell.setCellValue(id);
        cell = row.createCell(1);
        cell.setCellValue(cultivar);

        cell = row.createCell(2);
        cell.setCellValue(countLikes(metadataDoc));

        rowCountMeta++;
    }

    public int countLikes(Document metadataDoc){
//        if (metadataDoc.containsKey("ratings")){
//            Map<String, Object> metadata = metadataDoc.get
//        }

        return 0;
    }

    /**
     * Writes the spreadsheet to the outputstream, then closes it.
     * @throws IOException
     */
    public void complete() throws IOException{
        workbook.write(outputStream);
        outputStream.close();
    }
}
