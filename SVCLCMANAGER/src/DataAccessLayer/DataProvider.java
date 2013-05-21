package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataProvider {

	Connection cnn;
	ResultSet mResultSet;
	Statement mStatement;
	
	public DataProvider() {
		super();
		try {
			cnn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8888/sinhvienclc","root","root");
			mStatement = cnn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet ExecuteQueryResultSet(String cmd){
		try {
			mResultSet = mStatement.executeQuery(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mResultSet;
	}
}
