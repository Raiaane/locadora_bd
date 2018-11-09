/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Classificacao;
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
public class ClassificacaoDAO extends ExecuteSQL{ 
        
    public ClassificacaoDAO(Connection con){
    super(con);
    }
    //Inserir
    public String Inserir_Classificacao(Classificacao a){
        
        String sql = "insert into classificacao values (0,?,?)";
    
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
             ps.setString(1, a.getNome());
             ps.setString(2, a.getPreco());
              
              if(ps.executeUpdate() > 0){
              
                  return "Inserido com sucesso";
              
              } else {
              
                  return "Erro ao inserir";
            
              }
              
        } catch (SQLException e){
        
            return e.getMessage();
        
        }
    }
    //Testar
    public boolean Testar_Classificacao(int cod){
        boolean result =false;
        try {
            String sql = "SELECT * FROM classificacao WHERE idclassificacao='"+cod+"'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
               while(rs.next()){
                    result = true;
               }
            }else{
            
            }            
        } catch (SQLException ex) {
            ex.getMessage();
        }
    
        return result;
    }
    //Alterar
    public String Alterar_Classificacao(Classificacao c){
    String sql = "UPDATE classificacao SET nome=?, preco=? WHERE idclassificacao=?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setString(2,c.getPreco());
            ps.setInt(3,c.getCodigo());
            
            if (ps.executeUpdate()>0) {
                return "Atualizado com sucesso";
            }else{
                return "Erro ao atualizar";
                       
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }       
        
        
        
    }
    //capturar
     public List<Classificacao> CapturarClassificacao(int cod){
        String sql = "SELECT * FROM classificacao WHERE idclassificacao='"+cod+"'";
        List<Classificacao> lista = new ArrayList<>();

        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Classificacao c = new Classificacao();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setPreco(rs.getString(3));
                    lista.add(c);
                }
                return lista;
            }else{
                return null;
            }    
        }catch(SQLException ex){
            return null;
        }   
    
    }
      //Consultar
   public List<Classificacao> ListarClassificacao(){
   String sql = "SELECT * FROM classificacao";
   List<Classificacao> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Classificacao f = new Classificacao();
                f.setCodigo(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setPreco(rs.getString(3));
                lista.add(f);
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException ex) {
       return null;
       }
   }
   //listar
   public List<Classificacao> Pesquisar_Nome_Classificacao(String nome){
   String sql = "SELECT * FROM classificacao WHERE Nome LIKE '%"+nome+"%'";
   List<Classificacao> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                 Classificacao c = new Classificacao();
                c.setCodigo(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setPreco(rs.getString(3));
                lista.add(c);
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException ex) {
       return null;
       }
   }
   //listar
   public List<Classificacao> Pesquisar_Codigo_Classificacao(int cod){
   String sql = "SELECT * FROM classificacao WHERE idclassificacao ='"+cod+"'";
   List<Classificacao> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                 Classificacao c = new Classificacao();
                c.setCodigo(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setPreco(rs.getString(3));
                lista.add(c);
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException ex) {
       return null;
       }
   }
     //Excluir
  public String ExcluirClassificacao(Classificacao c){
   String sql = "DELETE FROM classificacao WHERE idclassificacao = ? AND Nome = ?";
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1,c.getCodigo());
           ps.setString(2,c.getNome());
           if(ps.executeUpdate()>0){
           return "Excluido com sucesso";
           }else{
           return "Erro ao excluir";
           }           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   }
  //Listar combo 
  public List<Classificacao> ListarComboClassificacao(){
    String sql = "Select Nome FROM classificacao";
    List<Classificacao> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
           while(rs.next()){
           Classificacao c = new Classificacao();
           c.setNome(rs.getString(1));
           lista.add(c);
           }
           
           }else{
           return null;
           }       
           return lista;
       } catch (SQLException ex) {
         return null;
       }
   
   }
   public List<Classificacao> ConsultaCodigoClassificacao(String nome){
    String sql = "SELECT idclassificacao FROM classificacao WHERE nome ='"+nome+"'";
    List<Classificacao> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while (rs.next()) {                
            Classificacao c = new Classificacao();
            c.setCodigo(rs.getInt(1));
            lista.add(c);            
            }
        }else{
        return null;
        }        
        return lista;
       } catch (SQLException ex) {
       return null;
       }
    
   }
   //ListarPRECO
   public List<Classificacao> ListarPrecoClassificacao(int cod){
   String sql = "SELECT preco FROM classificacao WHERE idclassificacao='"+cod+"'";
   List<Classificacao> lista = new ArrayList<>();
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
           while(rs.next()){
           Classificacao c = new Classificacao();
           c.setPreco(rs.getString(1));
           lista.add(c);
           }
           return lista;
           }else{
           return null;
           }
           
       } catch (Exception e) {
           return null;
       }
   }
  
}