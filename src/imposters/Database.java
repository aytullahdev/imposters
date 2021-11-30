/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imposters;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Database {
        private Connection con;
        private Statement smt;
        ResultSet rs = null;
        void dbcon(){
            try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:database.db");
            con.setAutoCommit(false);
            //System.out.print("Database created");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("Database error plz check Database.java file");
            
            
        }
       }
       void insertData(String sql){
           try{
                smt = con.createStatement();
                smt.executeUpdate(sql);
                con.commit();
                System.out.println("Data is inserted sucessfully");
                
            
           }catch (SQLException e){
               System.out.println("Data is't insert plz try aganin");
           }
            
        
        }
       ResultSet getData(String sql){
           try{
                con.setAutoCommit(false);
                smt = con.createStatement();
                rs = smt.executeQuery(sql);
                con.commit();
               
           }catch(SQLException e){
               System.out.println("Data is't inserted plz check");
           }
             return rs;
       }
    
       public void close() throws SQLException{
           if(con != null){
               con.close();
           }
           if(smt != null){
               smt.close();
           }
           if(rs != null){
               rs.close();
           }
       }
    
}
