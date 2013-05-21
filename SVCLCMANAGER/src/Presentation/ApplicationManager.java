package Presentation;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import BusinessAccessLayer.BALSinhvien;

public class ApplicationManager {

	public static void main(String[] args){
		BALSinhvien mSinhvien = new BALSinhvien();
		showResultSet(mSinhvien.getData());
	}
	
	public static void showResultSet(ResultSet mSet){
		try {
			ResultSetMetaData metaData = mSet.getMetaData();
			while (mSet.next()) {
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					switch (metaData.getColumnType(i)) {
					case Types.VARCHAR:
						System.out.print(mSet.getString(i) + " ");
						break;
					case Types.CHAR:
						System.out.print(mSet.getString(i) + " ");
						break;
					case Types.INTEGER:
						System.out.print(mSet.getInt(i) + " ");
						break;
					case Types.TINYINT:
						System.out.print(mSet.getInt(i) + " ");
						break;
					case Types.DECIMAL:
						System.out.print(mSet.getFloat(i) + " ");
						break;
					case Types.DATE:
						System.out.print(mSet.getDate(i) + " ");
						break;
					default:
						break;
					}
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
