using System.IO;
using Excel;
using System.Data;
public class ExcelUtil{


	public static DataSet loadExcel(string path){
		FileStream m_Stream = File.Open(path, FileMode.Open, FileAccess.Read);
		//使用OpenXml读取Excel文件
		IExcelDataReader mExcelReader = ExcelReaderFactory.CreateOpenXmlReader(m_Stream);
		//将Excel数据转化为DataSet
		DataSet mResultSets = mExcelReader.AsDataSet();
		return mResultSets;
		
	}


}
