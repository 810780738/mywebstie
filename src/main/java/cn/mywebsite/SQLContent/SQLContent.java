package cn.mywebsite.SQLContent;

import java.sql.Types;

public final class SQLContent {
	
	/**
	 * ClassName:用户相关的SQL
	 * ClassDescription:
	 * @author Administrator
	 * @Data 2017年10月25日 上午10:13:13
	 */
	public static class User{
		public final static String INSERT_USER = "INSERT INTO USERINFO (USERINFO_ID,USERNAME,LOGINNAME,EMAIL,ABOUTUSER,USERPASSWORD,CREATETIME) VALUES(?,?,?,?,?,?,?)";
		public final static int[] INSERT_USER_TYPES = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
		
		public final static String MODIFI_USER = "";
		
		public final static String CHECK_USER = "SELECT * FROM USERINFO WHERE LOGINNAME=? AND USERPASSWORD=?";
		public final static int[] CHECK_USER_TYPES = {Types.VARCHAR,Types.VARCHAR};
		
		public final static String FINDUSERBYID = "SELECT * FROM USERINFO WHERE USERINFO_ID=#{ID}";
		
	}
}
