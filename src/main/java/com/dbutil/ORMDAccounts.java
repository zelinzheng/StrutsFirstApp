package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.beans.Account;

public class ORMDAccounts {


	public static Connection getConnection() {

		return ORMDcon.getConnection();
	}

	public static ArrayList<Account> select(String sql)  {
		ArrayList<Account> result = new ArrayList<Account>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Account account = new Account(rs.getInt("acno"),
						rs.getString("un"), rs.getInt("balance"));

				// Account.print();
				result.add(account);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs = null;
				}
				if (stmt != null) {
					stmt = null;
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void insert(String un) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		// (un, pass,tranpass, email,acno)
		String sql = "insert into Accounts (" + "un " + ") values ('" + un
				+ "')";
		System.out.println(sql);
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Map<String, String> getAccount(String un) {
		Map<String, String> result = new HashMap();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from accounts where un ='" + un
					+ "'");
			while (rs.next()) {
				Account account = new Account(rs.getInt("acno"),
						rs.getString("un"), rs.getInt("balance"));

				// Account.print();
				result.put("acno", Integer.toString(account.getAcno()));
				result.put("balance", Integer.toString(account.getBalance()));
				result.put("un", account.getUn());
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs = null;
				}
				if (stmt != null) {
					stmt = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static boolean tranfer(String un, String targetun, String amount) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("update accounts set balance = balance - '" + amount+"' where un='" + un+"'");
			stmt.executeUpdate("update accounts set balance = balance + '" + amount+"' where un='" + targetun+"'");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null) {
					rs = null;
				}
				if (stmt != null) {
					stmt = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
