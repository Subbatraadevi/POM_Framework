package com.aliexpress.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/***
 * To keep excel related methods
 * 
 * @author manikandamani
 *
 * 
 */
public class ExcelUtils {
	// private XSSFSheet workSheet;
	// private XSSFWorkbook workBook;

	static Workbook workBook;
	static Sheet workSheet;

	private static String path;

	/***
	 * constructor to initate the excel sheet
	 * 
	 * @param path      excel file path
	 * @param sheetName sheet name need to access
	 */
	public ExcelUtils(String path, String sheetName) {

		this.path = path;

		try {
			FileInputStream file = new FileInputStream(new File(path));
			workBook = WorkbookFactory.create(file);
			workSheet = workBook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}

	}

	/***
	 * To get Rowcount
	 * 
	 * @param sheetName sheet name need to check
	 * @return row count
	 */

	public static int getRowCount(String sheetName) {

		int index = workBook.getSheetIndex(sheetName);

		if (index == -1)

			return 0;

		else {

			workSheet = workBook.getSheetAt(index);

			int number = workSheet.getLastRowNum() + 1;

			return number;

		}

	}

	/***
	 * To get the cell value
	 * 
	 * @param rowNum row number
	 * @param colNum column number
	 * @return cell value
	 */
	public static String getCellData(int rowNum, int colNum) {

		Cell cell;
		String cellData = "";
		try {

			cell = workSheet.getRow(rowNum).getCell(colNum);

			if (cell != null) {
				cellData = cell.toString();
			}
			return cellData;

		} catch (Exception e) {

			e.printStackTrace();

			return "";

		}

	}

	/***
	 * To list all columns name
	 * 
	 * @return all column names
	 */
	public static List<String> getColumnsNames() {
		List<String> columns = new ArrayList<String>();
		Row row = workSheet.getRow(0);
		for (Cell cell : row) {
			columns.add(cell.toString());
		}
		return columns;

	}

	/***
	 * To set the value to specific cell
	 * 
	 * @param value  need to write on excel
	 * @param rowNum row number
	 * @param colNum column number
	 */
	public static void setCellData(String value, int rowNum, int colNum) {
		Cell cell;
		Row row;

		try {
			row = workSheet.getRow(rowNum);
			if (row == null) {
				row = workSheet.createRow(rowNum);
			}
			cell = row.getCell(colNum);

			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			FileOutputStream fileOut = new FileOutputStream(path);
			workBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/***
	 * 
	 * @param rowNum
	 * @param colNum
	 * @return
	 */
	public static Cell getCell(int rowNum, int colNum) {
		Cell cell;
		Row row;
		try {
			row = workSheet.getRow(rowNum);

			if (row == null) {

				row = workSheet.createRow(rowNum);
				cell = row.createCell(colNum);

				return cell;
			}

			cell = row.getCell(colNum);
			return cell;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/***
	 * 
	 * @param value
	 * @param columnName
	 * @param row
	 */
	public static void setCellData(String value, String columnName, int row) {
		int column = getColumnsNames().indexOf(columnName);
		setCellData(value, row, column);
	}

	/***
	 * To retrieve column count
	 * 
	 * @return column count
	 */
	public static int columnCount() {
		return workSheet.getRow(0).getLastCellNum();

	}

	/***
	 * To retrieve row count
	 * 
	 * @return row count
	 */

	public static int rowCount() {
		return workSheet.getPhysicalNumberOfRows();

	}

	/***
	 * To get the current date
	 * 
	 * @return current date in string format
	 */
	public static String currentdate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 0);
		dt = c.getTime();

		return (formatter.format(dt));
	}

}
