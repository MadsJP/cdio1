/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pravien
 */
public class DAO {

    public boolean validUser(String username, String password) throws Exception{
        Connector con = new Connector();
        con.getConnection();

        PreparedStatement query = con.getConnection().prepareStatement(
         "select * from person where username = ? and password = ?");
      query.setString(1,username);
      query.setString(2, password);

      ResultSet res = query.executeQuery();
      int amountOfRow = 0;
      while(res.next()){
          amountOfRow++;
      }
         con.close();
         return amountOfRow > 0;
    }
}
