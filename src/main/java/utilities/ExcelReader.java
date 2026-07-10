package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    // IMPORTANT:
    // Your Excel file is directly inside src/test/resources
    private static final String EXCEL_PATH =
            System.getProperty("user.dir")
            + "/src/test/resources/testdata/testdata.xlsx";

    public static Object[][] getExcelData(String sheetName) {

        System.out.println("Reading Excel from: " + EXCEL_PATH);

        try (
            FileInputStream fileInputStream =
                    new FileInputStream(EXCEL_PATH);

            Workbook workbook =
                    new XSSFWorkbook(fileInputStream)
        ) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Excel sheet not found: "
                        + sheetName);
            }

            int totalRows =
                    sheet.getPhysicalNumberOfRows();

            if (totalRows <= 1) {
                throw new RuntimeException(
                        "No test data found in sheet: "
                        + sheetName);
            }

            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {
                throw new RuntimeException(
                        "Header row is missing in sheet: "
                        + sheetName);
            }

            int totalColumns =
                    headerRow.getLastCellNum();

            Object[][] data =
                    new Object[totalRows - 1][totalColumns];

            DataFormatter formatter =
                    new DataFormatter();

            for (int i = 1; i < totalRows; i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < totalColumns; j++) {

                    if (row == null) {

                        data[i - 1][j] = "";

                    } else {

                        Cell cell = row.getCell(
                                j,
                                Row.MissingCellPolicy
                                   .RETURN_BLANK_AS_NULL);

                        if (cell == null) {

                            data[i - 1][j] = "";

                        } else {

                            data[i - 1][j] =
                                    formatter
                                    .formatCellValue(cell)
                                    .trim();
                        }
                    }
                }
            }

            System.out.println(
                    "Excel data read successfully");

            System.out.println(
                    "Sheet name: " + sheetName);

            System.out.println(
                    "Data rows: " + (totalRows - 1));

            return data;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to read Excel file: "
                    + EXCEL_PATH,
                    e);
        }
    }
}