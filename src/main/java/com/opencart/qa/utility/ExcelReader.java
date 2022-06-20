package com.opencart.qa.utility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    private static Workbook book;
    private static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        Object data[][] = null;



        try {
            FileInputStream ip = new FileInputStream(Constants.TEST_DATA_SHEET_PATH);
            Workbook   book = WorkbookFactory.create(ip);
            Sheet  sheet = book.getSheet(sheetName);

            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                    System.out.println(data[i][j]);
                }
            }
            System.out.println("outside for");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;

    }

}

