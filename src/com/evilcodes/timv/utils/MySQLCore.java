package com.evilcodes.timv.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

public class MySQLCore implements DBCore
{	  
	
  private Logger log;
  private static Connection connection;
  private String host;
  private String username;
  private String password;
  private String database;

  public MySQLCore(String host, String database, String username, String password)
  {
    this.database = database;
    this.host = host;
    this.username = username;
    this.password = password;
    this.log = Bukkit.getLogger();
    
    initialize();
  }
    
  private void initialize()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      MySQLCore.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + "/" + this.database, this.username, this.password);
    }
    catch (ClassNotFoundException e)
    {
      this.log.severe("ClassNotFoundException! " + e.getMessage());
      this.log.info("Can not connect to MySQL Database!");
    }
    catch (SQLException e)
    {
      this.log.severe("SQLException! " + e.getMessage());
      this.log.info("Can not connect to MySQL Database!");
    }
  }

  public Connection getConnection()
  {
    try
    {
      if ((MySQLCore.connection == null) || (MySQLCore.connection.isClosed()))
      {
        initialize();
      }
    }
    catch (SQLException e)
    {
      initialize();
    }

    return MySQLCore.connection;
  }

  public Boolean checkConnection()
  {
    return Boolean.valueOf(getConnection() != null);
  }

  public void close()
  {
    try
    {
      if (MySQLCore.connection != null)
      {
        MySQLCore.connection.close();
      }
    }
    catch (Exception e)
    {
      this.log.severe("Failed to close database connection! " + e.getMessage());
    }
  }

  public ResultSet select(String query)
  {
    try
    {
      return getConnection().createStatement().executeQuery(query);
    }
    catch (SQLException ex)
    {
      this.log.severe("Error at SQL Query: " + ex.getMessage());
      this.log.severe("Query: " + query);
    }

    return null;
  }

  public void insert(String query)
  {
    try
    {
      getConnection().createStatement().executeUpdate(query);
    }
    catch (SQLException ex)
    {
      if (!ex.toString().contains("not return ResultSet"))
      {
        this.log.severe("Error at SQL INSERT Query: " + ex);
        this.log.severe("Query: " + query);
      }
    }
  }
  
  public static ResultSet executeQuery(String query, boolean modifies)
		    throws SQLException
		  {
		    Statement statement = MySQLCore.connection.createStatement();
		    if (modifies) {
		      statement.execute(query);
		      return null;
		    }
		    return statement.executeQuery(query);
		  }
  
  public static boolean mysqlExists(String query)
  {
    ResultSet result = null;
      try {
        result = MySQLCore.executeQuery(query, false);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    try
    {
      if ((result != null) && (result.next()))
        return true;
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public void update(String query)
  {
    try
    {
      getConnection().createStatement().executeUpdate(query);
    }
    catch (SQLException ex)
    {
      if (!ex.toString().contains("not return ResultSet"))
      {
        this.log.severe("Error at SQL UPDATE Query: " + ex);
        this.log.severe("Query: " + query);
      }
    }
  }

  public void delete(String query)
  {
    try
    {
      getConnection().createStatement().executeUpdate(query);
    }
    catch (SQLException ex)
    {
      if (!ex.toString().contains("not return ResultSet"))
      {
        this.log.severe("Error at SQL DELETE Query: " + ex);
        this.log.severe("Query: " + query);
      }
    }
  }

  public Boolean execute(String query)
  {
    try
    {
      getConnection().createStatement().execute(query);
      return Boolean.valueOf(true);
    }
    catch (SQLException ex)
    {
      this.log.severe(ex.getMessage());
      this.log.severe("Query: " + query);
    }return Boolean.valueOf(false);
  }

  public Boolean existsTable(String table)
  {
    try
    {
      ResultSet tables = getConnection().getMetaData().getTables(null, null, table, null);
      return Boolean.valueOf(tables.next());
    }
    catch (SQLException e)
    {
      this.log.severe("Failed to check if table '" + table + "' exists: " + e.getMessage());
    }return Boolean.valueOf(false);
  }

  public Boolean existsColumn(String tabell, String colum)
  {
    try
    {
      ResultSet colums = getConnection().getMetaData().getColumns(null, null, tabell, colum);
      return Boolean.valueOf(colums.next());
    }
    catch (SQLException e)
    {
      this.log.severe("Failed to check if colum '" + colum + "' exists: " + e.getMessage());
    }return Boolean.valueOf(false);
  }
  

  
  
  
  
}













