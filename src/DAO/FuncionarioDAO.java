/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raiane
 */
public class FuncionarioDAO extends ExecuteSQL {
    
    public FuncionarioDAO(Connection con) {
        super(con);
    }
    public boolean Logar(String login, String senha){
         boolean finalResult = false;
         try{
         String consulta = "select login, senha from funcionario" + "where login = '"+login+ "' and senha = '" + senha +"'";
             PreparedStatement ps = getCon().prepareStatement(consulta);
             ResultSet rs = ps.executeQuery();
         
         if(rs != null){
             while (rs.next()){
                 Funcionario a = new Funcionario();
                 a.setLogin(rs.getString(1));
                 a.setSenha (rs.getString(2));
                 finalResult = true;
             }
         }
         
        } catch (SQLException ex){
            ex.getMessage();
            
        }
         return finalResult;
    }
    //Cadastrar
   public String Inserir_Funcionario(Funcionario f){
   String sql = "INSERT INTO funcionario VALUES (0,?,?,?)";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setString(1,f.getNome());
           ps.setString(2,f.getLogin());
           ps.setString(3,f.getSenha());
           
           if (ps.executeUpdate() > 0) {
               return "Funcionario Inserido Com Sucesso";
           }else{
               return "Erro ao Inserir";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   } 
   //testar
   public boolean Testar_funcionario(int cod){
   boolean result = false;
   
       try{
          String sql = "SELECT * FROM funcionario WHERE idfuncionario = '"+cod+"'";
           
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
   //capturar
    public List<Funcionario> CapturarFuncionario(int cod){
    String sql = "SELECT * FROM funcionario WHERE idfuncionario = '"+cod+"'";
    List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Funcionario f = new Funcionario();
                    f.setCod(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    lista.add(f);

                }
                return lista;
            }else{
                return null;
            }                    
        } catch (SQLException ex) {
            return null;
        }
    
    }   
    //Alterar
     public String Alterar_Funcionario(Funcionario f){
   String sql = "UPDATE funcionario SET nome = ? ,login = ? ,senha = ? WHERE idfuncionario = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setString(1,f.getNome());
           ps.setString(2,f.getLogin());
           ps.setString(3,f.getSenha());
           ps.setInt(4, f.getCod());
           
           if (ps.executeUpdate() >0) {
               return "Funcionario Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   
   }
}
    
    
    
    

