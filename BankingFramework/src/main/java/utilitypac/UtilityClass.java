package utilitypac;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {


	public static void capture(WebDriver driver,int testid , String methodName) throws Exception {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date=new Date();
				String Datetime=sdf.format(date);
		
				String ScreenShotName=Datetime+" "+testid+" "+methodName;
			// To Screenshot Script
				
		TakesScreenshot ts= (TakesScreenshot)driver;	
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest="./test-output/Screenshots/"+ScreenShotName+".png";
		File destination=new File(dest);
		ImageIO.write(ImageIO.read(source),"png", destination);
		
	}
	
	 private static final String FILE_NAME="./src/main/resources/TestData/ExcelData.xlsx";
	 
	 public static String FetchData(String SheetName,int row,int cell) {

		String data=null;
		FileInputStream file=null;
		Workbook workbook=null;
		
		try {
			file=new FileInputStream(FILE_NAME);
			workbook=new XSSFWorkbook(file);
			Sheet sheet=workbook.getSheet(SheetName);
			Row rowobj=sheet.getRow(row);
			Cell cellobj=rowobj.getCell(cell);
			data=cellobj.getStringCellValue();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(data!=null) {
					file.close();
				}
				if(workbook !=null) {
					file.close();
				}
				if(file !=null) {
					file.close();
				}
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		 return data;
		 
		 
}
}