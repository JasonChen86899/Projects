package LPR;

import com.sap.db.jdbc.trace.ResultSet;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by I330347 on 7/29/2016.
 */
public class Controller {
    public static ResultSet LPR(String sql){
        ResultSet resultSet = HANA_Connection.excuteSQL(sql);
        return  resultSet;
    }

    public static ResultSet GPS(String sql){
        ResultSet resultSet = HANA_Connection.excuteSQL(sql);
        return resultSet;
    }

    public static void main(String[] args){
        String sql_LPR = "SELECT\n" +
                "    *\n" +
                "FROM \"SAP_ITRAFFIC_LPRDC\".\"sap.traffic.lprdc.s.db::FDD.RAW_LPR\"\n" +
                "WHERE\n" +
                "    TO_DATE(COLLECT_TIME) = '2016-05-08'\n" +
                "    AND\n" +
                "    PLATE_NUM = '苏A80370'";
        ResultSet resultSetLPR = LPR(sql_LPR);
        try {
            HashMap<Date,Object> time_statioinid = new HashMap<>();
            while (resultSetLPR!=null&&resultSetLPR.next()){
                int StationId = resultSetLPR.getInt(2);
                Date collect_time = resultSetLPR.getDate(7);
                time_statioinid.put(collect_time,StationId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql_GPS = "select\n" +
                "    GPS_TIME,\n" +
                "\tLAT,\n" +
                "\tLNG\n" +
                "from \"SAP_ITRAFFIC_LPRDC\".\"sap.traffic.lprdc.s.db::TAXI.RAW_TAXI\"\n" +
                "where\n" +
                "\tDEVID = '苏A80370'\n" +
                "\tAND\n" +
                "\tTO_DATE(GPS_TIME) = '2016-05-08'\n" +
                "\tAND\n" +
                "\tHOUR(GPS_TIME) BETWEEN "+" AND "+"13\n" +
                "\tORDER BY GPS_TIME\n" +
                "\t;";
        ResultSet resultSetGPS = GPS(sql_GPS);
    }
}
