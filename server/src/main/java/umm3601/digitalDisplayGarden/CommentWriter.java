package umm3601.digitalDisplayGarden;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

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
    int rowCount;
    MongoClient mongoClient;
    MongoDatabase test;
    MongoCollection plants;

    public CommentWriter(OutputStream outputStream) throws IOException{
        this.outputStream = outputStream;

        this.workbook = new XSSFWorkbook();
        this.commentSheet = workbook.createSheet("Comments");

        this.mongoClient = new MongoClient();
        this.test = mongoClient.getDatabase("test");
        this.plants = test.getCollection("plants");

        Row row = commentSheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("#");



        cell = row.createCell(1);
        cell.setCellValue("cultivar");

        cell = row.createCell(2);
        cell.setCellValue("comment");

        cell = row.createCell(3);
        cell.setCellValue("timestamp");

        rowCount = 1;
    }

    /**
     * Adds the given information as a new row to the sheet.
     * @param id: plant ID number
     * @param comment: comment left by visitor
     * @param timestamp: time the user left the comment
     */
    public void writeComment(String id, String comment, Date timestamp){
        Row row = commentSheet.createRow(rowCount);

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

        rowCount++;
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
