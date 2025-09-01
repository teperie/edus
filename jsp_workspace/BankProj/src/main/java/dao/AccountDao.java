package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Account;
import dto.SpecialAccount;

public class AccountDao extends DBConnection {
	public static void insert(Account acc) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql="insert into account values(?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			
			if(acc instanceof SpecialAccount) {
				pstmt.setString(4, ((SpecialAccount)acc).getGrade());
			} else {
				pstmt.setString(4, null);
			}
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public static void update(String id, Integer balance) {
		Connection conn = getConnection();
		PreparedStatement pstmt=null;
		String sql="update account set balance=? where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public static Account select(String id) {
		Account acc = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql="select * from account where id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rset=pstmt.executeQuery();
			if(rset!=null && rset.next()) {
				String rid=rset.getString("id");
				String name=rset.getString("name");
				Integer balance=rset.getInt("balance");
				String grade=rset.getString("grade");
				if(grade==null) {
					acc=new Account(rid,name,balance);
				} else {
					acc=new SpecialAccount(id,name,balance,grade);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return acc;
	}
	
	public static List<Account> selectList() {
		List<Account> accList = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt=null;
		ResultSet rset = null;
		String sql="select * from account";
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(sql);
			if(rset!=null) {
				while(rset.next()) {
					String id=rset.getString("id");
					String name=rset.getString("name");
					Integer balance=rset.getInt("balance");
					String grade=rset.getString("grade");
					if(grade==null) {
						accList.add(new Account(id,name,balance));
					} else {
						accList.add(new SpecialAccount(id,name,balance,grade));
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(conn);
		}
		return accList;
	}
}









