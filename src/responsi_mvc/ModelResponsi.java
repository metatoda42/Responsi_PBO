package responsi_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ModelResponsi {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    Connection koneksi;
    Statement statement;
    
    public ModelResponsi(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/responsi_perpus?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(ex+"Koneksi Gagal");
        }
    }
    
    
    //CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE
    public void create(String memberid, String membername, String bookid, String bookname){
        int jmlData=0;
        try {
           
           
           String query = "Select * from transactions WHERE MemberId=" + memberid; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
           
            if (jmlData==0) {
                query = "INSERT INTO transactions(MemberId, MemberName, BookId, BookName) VALUES ('"+memberid+"','"+membername+"','"+bookid+"','"+bookname+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    //READ READ READ READ READ READ READ READ READ READ READ
    
    public String[][] read(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][4];
            
            String query = "Select * from transactions"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("MemberId"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("MemberName");                
                data[jmlData][2] = resultSet.getString("BookId");
                data[jmlData][3] = resultSet.getString("BookName");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    
    //UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE
    
    public void update(String memberid, String membername, String bookid, String bookname){
        int jmlData=0;
         try {
           String query = "Select * from transactions WHERE MemberId=" + memberid; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE transactions SET MemberName='" + membername + "', BookId='" + bookid +"', BookName='" + bookname + "' WHERE MemberId=" + memberid;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    
    //DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE
    
    public void delete (String memberid) {
        try{
            String query = "DELETE FROM transactions WHERE MemberId = '"+memberid+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
}
