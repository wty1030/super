package com.jdbc;
import java.sql.*;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	// ˽�л����캯��,��ֹ������new�����ʵ��
	private DBUtil() {}

	private static DataSource dataSource;

	static {
		dataSource = new ComboPooledDataSource("mysql");
	}

	// �õ�����,������Դ�õ�
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

	// ������Դ
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
				conn.close(); // ���������������,������ӷŻ����ӳ���,��Ϊ����DataSource�õ�������,��ʵ�����˴���, close() �Ѿ����ڲ���д��
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}