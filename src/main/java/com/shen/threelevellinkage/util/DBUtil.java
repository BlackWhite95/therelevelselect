package com.shen.threelevellinkage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil{
  private static final String URL="jdbc:mysql://localhost:3306/threelevelselect",
  USERNAME="root",PASSWORD="root";

  static {
      init();
  }
  private static void init(){
    try{
      Class.forName("com.mysql.jdbc.Driver");
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  static public Connection getConnection()throws SQLException{
    Connection c=DriverManager.getConnection(URL,USERNAME,PASSWORD);
    c.setAutoCommit(false);
    return c;
  }

  public static void main(String ...aaa)throws Exception{
    System.out.println(getConnection());
  }
}
