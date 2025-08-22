package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import acc.Account;
import acc.SpecialAccount;

public class AccountDao extends DBConnection {
    public static void insert(Account account) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            String sql = "INSERT INTO account (id, name, balance, grade) values(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getId());
            pstmt.setString(2, account.getName());
            pstmt.setInt(3, account.getBalance());
            if (account instanceof SpecialAccount) {
                pstmt.setString(4, ((SpecialAccount) account).getGrade());
            } else {
                pstmt.setNull(4, java.sql.Types.VARCHAR);
            }
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(conn);
        }
    }

    public static Account select(String id) {
        Connection conn = null;
        Statement stmt = null;
        Account account = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM account WHERE id = '" + id + "'";
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                account = new Account(rs.getString("id"), rs.getString("name"), rs.getInt("balance"));
                if(rs.getString("grade") != null){
                    account = new SpecialAccount(rs.getString("id"), rs.getString("name"), rs.getInt("balance"), rs.getString("grade"));
                }    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(stmt);
            close(conn);
        }
        return account;
    }

    public static List<Account> selectList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Account> list = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM account";
            rs = stmt.executeQuery(sql);
            list = new ArrayList<Account>();
            while (rs.next()) {
                Account account = null;
                if(rs.getString("grade") == null){
                    account = new Account(rs.getString("id"), rs.getString("name"), rs.getInt("balance"));
                }else{
                    account = new SpecialAccount(rs.getString("id"), rs.getString("name"), rs.getInt("balance"), rs.getString("grade"));
                }
                list.add(account);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
        return list;
    }

    public static void update(Account account) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            String sql = "UPDATE account SET name = ?, balance = ?, grade = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.getName());
            pstmt.setInt(2, account.getBalance());
            if (account instanceof SpecialAccount) {
                pstmt.setString(3, ((SpecialAccount) account).getGrade());
            } else {
                pstmt.setNull(3, java.sql.Types.VARCHAR);
            }
            pstmt.setString(4, account.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(conn);
        }
    }

    public static void delete(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            String sql = "delete from account where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(conn);
        }
    }
}
