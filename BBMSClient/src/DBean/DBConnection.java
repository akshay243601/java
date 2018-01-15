package DBean;
import java.sql.Connection;
import java.sql.DriverManager;

import Logger.BBMSLogger;
import Utility.Constant;


public class DBConnection 
{
	public Connection conn;
	public DBConnection() 
	{
		try
		{
			if(conn == null)
			{
				Class.forName(Constant.DRIVERCLASS);
				conn = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBPASSWORD);
				System.out.println("Conection Created Successfully");
			}
		}
		catch(Exception ex)
		{
			BBMSLogger.LogError(ex);
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
}

