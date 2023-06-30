package Common_API_Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Iterator;
//import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Write Data in NotePad File
public class Dynamic_Common_Utility_Method {
	//Write Data in NotePad File
	public static void EvidenceCreator(String Filename, String RequestBody ,String ResponseBody 
			,int statusCode) throws IOException
	{
		File TextFile = new File("E:\\File\\EvidenceFile\\" +Filename+".txt");
		System.out.println("New blank text file of name :" + TextFile.getName());
		
		FileWriter dataWrite = new FileWriter(TextFile);
		
		dataWrite.write("Request Body is :" +RequestBody + "\n\n");
		dataWrite.write("Status Code is : "+statusCode + "\n\n");
		dataWrite.write("Response Body is :" +ResponseBody + "\n\n");
		
		dataWrite.close();		
		System.out.println("Data is entered in Text File :" +TextFile.getName());
			
	}
	
	//Data Read from Excel Format Data Driven
	public static ArrayList<String> ReadDataExcel(String sheetname,String TestCaseName) throws IOException
	{
		ArrayList<String> arrData = new ArrayList<String>();//Why Created ArrayList
		
		//Step 1 :Create the object of file input stream to Locate the Excel File
		FileInputStream fis = new FileInputStream("E:\\All Notes\\API Notes\\Data_Driven_API\\DataDrivenRestAssuredAll.xlsx");
		//Step 2 :Open the Excel File by creating the Object XSSFWorkBook
		XSSFWorkbook WorkBook = new XSSFWorkbook(fis);
		//Step 3 :Open the Desired Sheet
		int CountOfSheet = WorkBook.getNumberOfSheets();
		for(int i=0 ; i<CountOfSheet ; i++)//Step 3.1 : workBook get No of Sheet
		{
			String SheetName = WorkBook.getSheetName(i);
			//System.out.println(SheetName);
			//Step 3.2 : Access the Desired Sheet
			if(SheetName.equalsIgnoreCase(sheetname)) 
			{
				//Use XSSFSheet to Save the into variable
				XSSFSheet Sheet = WorkBook.getSheetAt(i);
					
				Iterator<Row> Rows = Sheet.iterator();
				Row FirstRow = Rows.next();
				
				Iterator<Cell> CellsOfFirstRows = FirstRow.cellIterator();
				int k=0;
				int TC_column = 0;
				while(CellsOfFirstRows.hasNext())
				{
					Cell CellValue = CellsOfFirstRows.next();
					if(CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName"))
					{
						TC_column = k;
						//System.out.println("Expected Column for TestCase Name:" +k);
						break;						
					}
					k++;							
				}
				//Verify the row where the desired TestCase is found and fetch entire row
				while(Rows.hasNext())//read the row Values
				{
					Row DataRow = Rows.next();//go to next row
					String TCName = DataRow.getCell(TC_column).getStringCellValue();
					if(TCName.equalsIgnoreCase(TestCaseName))//Compare the argument parameter and DataRow
					{
						Iterator<Cell> CellValues = DataRow.cellIterator();
						while(CellValues.hasNext())//Read Cells Values individual
						{
							
							String Data = "";
							//System.out.println(Data);
							Cell CurrentCell = CellValues.next();
							try
							{
								String StringData = CurrentCell.getStringCellValue();
								Data = StringData;
							}
							catch(IllegalStateException e)
							{
								double doubledata = CurrentCell.getNumericCellValue();
								Data = Double.toString(doubledata);
							}
							
							arrData.add(Data);
						} 
						break;
					}
				}	
				
			}
			
		}
		
		return arrData;
	}
	

}
