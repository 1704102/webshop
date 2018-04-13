/*
package com.webshop.Database;


import java.sql.*;

*/
/*
 * Created by marti on 20-1-2017.
 *//*

public class DatabaseHelper {
    String host="159.65.202.137";                               //server host name
    String user="postgres";                                            //username
    String pass="";                                        //password
    String DBName="webshop";                                        //database name
    //make connection
    Connection con;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");;
            con = DriverManager
                    .getConnection("jdbc:postgresql://"+ host +"/" + DBName + "?"
                            + "user=" + user +"&password=" + pass);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet select(String query){
        ResultSet s = null;
        try {
            Statement st = con.createStatement();
            s = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public void execute(String query){
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
