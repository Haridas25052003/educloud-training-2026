package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCreateDemo {
       public static void main(String[]args) throws IOException {
            
        //step 1 create sample use data
        List<User> users = new ArrayList<>();
        users.add(new User("haridas",22));
        users.add(new User("suresh",25));
        users.add(new User("sneha",19));
        users.add(new User("varun",32)); 
        users.add(new User("david",28));
        users.add(new User("priyanka",25));
        users.add(new User("steven",32));
        

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");

        //create font
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        //create cell style
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //add border 
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        //creating the header
        Row headerRow = sheet.createRow(0);

        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("Name");
        headerCell1.setCellStyle(headerStyle);

        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Age");
        headerCell2.setCellStyle(headerStyle);

        //step 3 loop through the list
        int rowIndex =1;

        for(User user: users){

            Row row = sheet.createRow(rowIndex++);

            row.createCell(0).setCellValue(user.getName());
            row.createCell(1).setCellValue(user.getAge());
        }

        //atuo-size columns
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        
        try{
            FileOutputStream fileOut = new FileOutputStream("users.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

            System.out.println("excel file created successfully");

        }
        catch(IOException e){
            e.printStackTrace();
        }

       }
}
