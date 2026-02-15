package com.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadDemo {

    public static void main(String[] args) {

        try {

            // Step 1: Open existing Excel file
            FileInputStream file = new FileInputStream("users.xlsx");

            // Step 2: Create Workbook
            Workbook workbook = new XSSFWorkbook(file);

            // Step 3: Get Sheet
            Sheet sheet = workbook.getSheet("Users");

            if (sheet == null) {
                System.out.println("Sheet not found!");
                return;
            }

            // Step 4: Get total rows
            int totalRows = sheet.getLastRowNum();

            // Step 5: Loop through rows
            for (int i = 0; i <= totalRows; i++) {

                Row row = sheet.getRow(i);

                if (row == null) continue;

                Cell nameCell = row.getCell(0);
                Cell ageCell = row.getCell(1);

                String name = "";
                int age = 0;

                // Read Name (String)
                if (nameCell != null && nameCell.getCellType() == CellType.STRING) {
                    name = nameCell.getStringCellValue();
                }

                // Read Age (Numeric)
                if (ageCell != null && ageCell.getCellType() == CellType.NUMERIC) {
                    age = (int) ageCell.getNumericCellValue(); // convert double → int
                }

                System.out.println("Name: " + name + " | Age: " + age);
            }

            // Step 6: Close resources
            workbook.close();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
