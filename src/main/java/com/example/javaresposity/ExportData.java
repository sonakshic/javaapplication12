package com.example.javaresposity;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaentity.Users;

@Service
public class ExportData {

	@Autowired
	UserRepository userRepository;

	public void generateExcel(HttpServletResponse response) throws Exception {

		List<Users> courses = userRepository.findAll();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Courses Info");
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("Emp_id");
		row.createCell(1).setCellValue("FirstName");
		row.createCell(2).setCellValue("Email");
		row.createCell(2).setCellValue("Password");

		int dataRowIndex = 1;

		for (Users course : courses) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(course.getId());
			dataRow.createCell(1).setCellValue(course.getName());
			dataRow.createCell(2).setCellValue(course.getPassword());
			dataRow.createCell(2).setCellValue(course.getEmail());
			dataRowIndex++;
		}

		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();

	}

}
