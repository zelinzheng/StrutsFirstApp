package com.dbutil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.User;




public class ORMDUsers {

	public static Connection getConnection()  {
        return ORMDcon.getConnection();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ORMDUsers ou = new ORMDUsers();
		try {
			//ou.getConnection();
			User user = new User("testuser", "testpass", "testemail","testtrpa");
			
				ou.insert(user);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//If exists, return false
	public static boolean userCheck(String un) {
		boolean flag =true;
		Connection conn = getConnection();
        try {
            String sql1 = "select count(0) from users where un='" + un + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery(sql1);
            if (rs1.next()) {
                int userCount = rs1.getInt(1);
                if (0 != userCount) {
                    flag = false;

                    rs1 = null;
                    stmt = null;
             }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
            return flag;
     }
	
	public static boolean tranpassCheck(String un, String tranpass) {
		boolean flag =false;
		Connection conn = getConnection();
        try {
            String sql1 = "select count(0) from users where un='" + un + "' and tranpass = '" + tranpass + "'" ;
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery(sql1);
            if (rs1.next()) {
                int userCount = rs1.getInt(1);
                if (0 != userCount) {
                    flag = true;

                    rs1 = null;
                    stmt = null;
             }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
            return flag;
     }
	
	public static boolean passCheck(String un, String pass) {
		boolean flag =false;
		Connection conn = getConnection();
        try {
            String sql1 = "select count(0) from users where un='" + un + "' and pass='" +pass + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery(sql1);
            if (rs1.next()) {
                int userCount = rs1.getInt(1);
                if (0 != userCount) {
                    flag = true;

                    rs1 = null;
                    stmt = null;
             }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
            return flag;
     }
	
	
	public static void insert(User user) throws Exception {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        //(un, pass,tranpass, email,acno)
        String sql = "insert into Users ("
               +"un, "+"pass, "+"tranpass, "+"email" +") values ('"+ 
        		user.getUn() +"','"+
                user.getPass()+"','"+
                user.getTranpass()+"','"+
                user.getEmail() + "')";
        System.out.println(sql);
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ORMDAccounts.insert(user.getUn());
        } catch(SQLException sqle) {
            throw new Exception("insert data exception:" + sqle.getMessage());
        } finally {
              try {
                if(ps!=null){
                    ps = null;
                }
            } catch (Exception e) {
                   throw new Exception("connection close exception"+e.getMessage());
            } 
        }
    }
}
