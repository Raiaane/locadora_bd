/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raiane
 */

    public class DVDDAO extends ExecuteSQL{
    public DVDDAO(Connection con){
    super(con);
    }
    //Cadastrar
   public String Inserir_DVD(DVD d){
   String sql = "INSERT INTO dvd VALUES (0,?,?,?,?)";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           //ps.setInt(1,d.getIdfilme());
           ps.setString(2,d.getSituacao());
           ps.setDouble(3,d.getPreco());
           ps.setString(4,d.getData_compra());
           if (ps.executeUpdate() >0) {
               return "DVD Inserido Com Sucesso";
           }else{
               return "Erro ao Inserir";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   } 
   //Alterar
   public boolean Testar_DVD(int cod){
   boolean result = false;
   
       try{
          String sql = "SELECT * FROM dvd WHERE iddvd = '"+cod+"'";
           
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs!= null){
          while(rs.next()){
          result = true;
          }
          }
          
       }catch(SQLException ex) {
          ex.getMessage();
       }
       return result;
   }
    
}
