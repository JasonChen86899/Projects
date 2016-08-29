package LPR;



import com.sap.db.jdbc.trace.*;
import com.sap.db.jdbc.trace.ResultSet;
import com.sap.db.vsp001.DateTimeFormat;

import java.sql.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by I330347 on 7/29/2016.
 */
public class HANA_Connection {
    private static Connection getDBConnection(){
        String RL = "jdbc:sap://10.128.184.142:30015";
        String username = "I330347";
        String password = "Sap12345";
        try{
            Class.forName("com.sap.db.jdbc.Driver");
            return DriverManager.getConnection(RL,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void CallSQLScript() {
        String sql = "call \"VVV\"(?,?,?,?,?)";
        com.sap.db.jdbc.trace.Connection conn = (com.sap.db.jdbc.trace.Connection)getDBConnection();  // establish connection to database using jdbc//
        com.sap.db.jdbc.trace.CallableStatement  cSt = null;
        com.sap.db.jdbc.trace.ResultSet rs = null;
        if(conn==null)
            return ;
        try {
            cSt = (com.sap.db.jdbc.trace.CallableStatement)conn.prepareCall(sql);
            if (cSt == null) {
                System.out.println("error preparing call: " + sql);
                return;
            }
            cSt.setDate(1, java.sql.Date.valueOf("2016-05-08"));
            cSt.setInt(2, 6022);
            cSt.setInt(3, 2);
            cSt.setInt(4,8);
            cSt.setInt(5,9);
            boolean res = cSt.execute();
            System.out.println("result: " + res);
            do {
                rs =(com.sap.db.jdbc.trace.ResultSet) cSt.getResultSet();
                while (rs != null && rs.next()) {
                    System.out.println("row: " + rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
                }
            } while (cSt.getMoreResults());
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cSt != null)
                try {
                    cSt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void ExcuteSQl(String sql){
        /**String sql = "select\n" +
                "    GPS_TIME,\n" +
                "\tLAT,\n" +
                "\tLNG\n" +
                "from \"SAP_ITRAFFIC_LPRDC\".\"sap.traffic.lprdc.s.db::TAXI.RAW_TAXI\"\n" +
                "where\n" +
                "\tDEVID = '苏A80370'\n" +
                "\tAND\n" +
                "\tTO_DATE(GPS_TIME) = '2016-05-08'\n" +
                "\tAND\n" +
                "\tHOUR(GPS_TIME) BETWEEN 12 AND 13\n" +
                "\tORDER BY GPS_TIME ";
         **/
        com.sap.db.jdbc.trace.Connection conn = (com.sap.db.jdbc.trace.Connection)getDBConnection();
        com.sap.db.jdbc.trace.PreparedStatement  cSt = null;
        com.sap.db.jdbc.trace.ResultSet rs = null;
        if(conn==null)
            return ;
        try {
            cSt = (com.sap.db.jdbc.trace.PreparedStatement)conn.prepareStatement(sql);
            if (cSt == null) {
                System.out.println("error preparing call: " + sql);
                return;
            }
            //cSt.setFloat(1, 1.5f);
            //cSt.setString(2, "'EUR'");
            //cSt.setString(3, "books");
            boolean res = cSt.execute();
            System.out.println("result: " + res);
            do {
                rs =(com.sap.db.jdbc.trace.ResultSet) cSt.getResultSet();
                while (rs != null && rs.next()) {
                    System.out.println("row: " + rs.getString(1) + ", " + rs.getString(2));
                }
            } while (cSt.getMoreResults());
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (cSt != null)
                try {
                    cSt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public static com.sap.db.jdbc.trace.ResultSet excuteSQL(String sql){
        com.sap.db.jdbc.trace.Connection conn = (com.sap.db.jdbc.trace.Connection)getDBConnection();
        com.sap.db.jdbc.trace.PreparedStatement  cSt = null;
        com.sap.db.jdbc.trace.ResultSet rs = null;
        if(conn==null)
            return null;
        try {
            cSt = (com.sap.db.jdbc.trace.PreparedStatement) conn.prepareStatement(sql);
            if (cSt == null) {
                System.out.println("error preparing call: " + sql);
                return null;
            }
            //cSt.setFloat(1, 1.5f);
            //cSt.setString(2, "'EUR'");
            //cSt.setString(3, "books");
            boolean res = cSt.execute();
            System.out.println("result: " + res);
            return rs = (com.sap.db.jdbc.trace.ResultSet) cSt.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        String sql = "SELECT\n" +
                "\tLAT,\n" +
                "\tLNG\n" +
                "FROM \"SAPCD_ITRAFFIC\".\"sapcd.itraffic.dp.s.db::FDD.STATION_INFO\"\n" +
                "WHERE\n" +
                "\tSTATION_NO = 6057";
        //ExcuteSQl(sql);
        //CallSQLScript();
        //ResultSet rs =tets(sql);
        /**try {
            while (rs!=null&&rs.next()){
                System.out.println(rs.getString(1)+rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

}
