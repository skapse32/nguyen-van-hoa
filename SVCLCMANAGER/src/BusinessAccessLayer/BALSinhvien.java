package BusinessAccessLayer;

import java.sql.ResultSet;

import DataAccessLayer.DataProvider;

public class BALSinhvien {

	DataProvider mProvider;

	public BALSinhvien() {
		super();
		mProvider = new DataProvider();
	}
	
	public ResultSet getData(){
		return mProvider.ExecuteQueryResultSet("SELECT * FROM danhsachsinhvien");
	}
}
