package com.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

        //creating the header
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("age");

        //step 3 loop through the list
        int rowIndex =1;

        for(User user: users){

            Row row = sheet.createRow(rowIndex++);

            row.createCell(0).setCellValue(user.getName());
            row.createCell(1).setCellValue(user.getAge());
        }

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
