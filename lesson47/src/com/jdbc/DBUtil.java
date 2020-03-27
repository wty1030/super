package com.jdbc;
import java.sql.*;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	// 私有化构造函数,防止其他人new本类的实例
	private DBUtil() {}

	private static DataSource dataSource;

	static {
		dataSource = new ComboPooledDataSource("mysql");
	}

	// 得到连接,从数据源得到
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;
	}

	// 清理资源
	public static void close(ResultSet rs, Statement stm, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close(); // 不会真的销毁连接,会把连接放回连接池中,因为经过DataSource得到的连接,其实经过了代理, close() 已经在内部重写了
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}