/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Aluguel;
import Modelo.Cliente;
import Modelo.DVD;
import java.sql.Array;
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

 public class AluguelDAO extends ExecuteSQL{
  public AluguelDAO(Connection con){
  super(con);
  }
   
    public String InserirAluguel(Aluguel f){
      String sql = "INSERT INTO aluguel VALUES (0,?,?,?,?,?)";  
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1,f.getCoddvd());
            ps.setInt(2,f.getCodcliente());
            ps.setString(3,f.getHorario());
            ps.setString(4,f.getData_aluguel());
            ps.setString(5,f.getData_devolucao());
            if(ps.executeUpdate()>0){
            return "iInserido com sucesso";            
            }else{
            return "Erro ao inserir";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
   //Alterar
   public boolean Testar_Aluguel(int cod){
   boolean result = false;
   
       try{
          String sql = "SELECT * FROM aluguel WHERE idaluguel = '"+cod+"'";
           
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
   //Alterar
    public List<Aluguel> CapturarAluguel(int cod){
    String sql = "SELECT * FROM aluguel WHERE idaluguel = '"+cod+"'";
    List<Aluguel> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Aluguel f = new Aluguel();
                    f.setCod(rs.getInt(1));
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
     public String Alterar_Aluguel(Aluguel f){
   String sql = "UPDATE aluguel SET titulo = ? ,ano = ? ,duracao = ?, idcategoria = ? ,idclassificacao = ? ,capa = ? WHERE idaluguel = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           if (ps.executeUpdate() >0) {
               return "Aluguel Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   
   }
   //Consultar
   public List<Aluguel> ListarAluguel(){
   String sql = "SELECT * FROM aluguel";
   List<Aluguel> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Aluguel f = new Aluguel();
                f.setCod(rs.getInt(1));
                f.setCoddvd(rs.getInt(2));
                f.setCodcliente(rs.getInt(3));
                f.setHorario(rs.getString(4));
                f.setData_aluguel(rs.getString(5));  
                f.setData_devolucao(rs.getString(6));
                        
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
   //Consultar
   public List<Aluguel> Listar_Nome_Aluguel(String nome){
   String sql = "SELECT * FROM aluguel WHERE titulo LIKE '%"+nome+"%'";
   List<Aluguel> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Aluguel f = new Aluguel();
              
                f.setCod(rs.getInt(1));
                f.setCoddvd(rs.getInt(2));
                f.setCodcliente(rs.getInt(3));
                f.setHorario(rs.getString(4));
                f.setData_aluguel(rs.getString(5));  
                f.setData_devolucao(rs.getString(6));
                
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
   //Consultar
   public List<Aluguel> Listar_Codigo_Aluguel(int cod){
   String sql = "SELECT * FROM aluguel WHERE idaluguel ='"+cod+"'";
   List<Aluguel> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Aluguel f = new Aluguel();
                f.setCod(rs.getInt(1));
                f.setCoddvd(rs.getInt(2));
                f.setCodcliente(rs.getInt(3));
                f.setHorario(rs.getString(4));
                f.setData_aluguel(rs.getString(5));  
                f.setData_devolucao(rs.getString(6));
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
    public List<Aluguel> Listar_Codigo_DVD(int cod){
   String sql = "SELECT * FROM aluguel WHERE iddvd ='"+cod+"'";
   List<Aluguel> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Aluguel f = new Aluguel();
                f.setCod(rs.getInt(1));
                f.setCoddvd(rs.getInt(2));
                f.setCodcliente(rs.getInt(3));
                f.setHorario(rs.getString(4));
                f.setData_aluguel(rs.getString(5));  
                f.setData_devolucao(rs.getString(6));
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
     public List<Aluguel> Listar_Codigo_Cliente(int cod){
   String sql = "SELECT * FROM aluguel WHERE idcliente ='"+cod+"'";
   List<Aluguel> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Aluguel f = new Aluguel();
                f.setCod(rs.getInt(1));
                f.setCoddvd(rs.getInt(2));
                f.setCodcliente(rs.getInt(3));
                f.setHorario(rs.getString(4));
                f.setData_aluguel(rs.getString(5));  
                f.setData_devolucao(rs.getString(6));
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
   //Excluir
   public List<Aluguel> ListarComboAluguel(){
   String sql = "SELECT titulo FROM aluguel";
   List<Aluguel> lista = new ArrayList<>();
   
       try {
           PreparedStatement pr = getCon().prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           if(rs!= null){
            while(rs.next()){
                Aluguel f = new Aluguel();
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
   //Excluir
   public List<Aluguel> ConsultaCodigoCliente(String nome){
   String sql = "SELECT idaluguel FROM aluguel WHERE titulo = '"+nome+"'";
   List<Aluguel> lista = new ArrayList<>();
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!= null){
                while(rs.next()){
                    Aluguel f = new Aluguel();
                    f.setCod(rs.getInt(1));
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
   
   //Excluir
   public String ExcluirAluguel(Aluguel a){
   String sql = "DELETE FROM aluguel WHERE idaluguel = ?";
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, a.getCod());
           if(ps.executeUpdate()>0){
                return "Excluido com sucesso!";
           }else{
                return "Erro ao excluir!";
           }
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   }
  
  public  List<Cliente> ConsultaTable(String nome){
  String sql = "SELECT idcliente FROM cliente WHERE nome = '"+nome+"'";
  List<Cliente> lista = new ArrayList();    
  try {
      PreparedStatement ps = getCon().prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      if(rs!=null){
      while(rs.next()){
      Cliente c = new Cliente();
      c.setCodigo(rs.getInt(1));
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
  public List<Aluguel> AtualizaAluguel(int code){
  String sql = "SELECT * FROM aluguel WHERE idcliente = '"+code+"'";
  List<Aluguel> lista = new ArrayList<>();
  try{   
      PreparedStatement ps = getCon().prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      if(rs!=null){
      while(rs.next()){
      Aluguel a = new Aluguel();
      a.setCod(rs.getInt(1));
      a.setCoddvd(rs.getInt(2));
      a.setCodcliente(rs.getInt(3));
      a.setHorario(rs.getString(4));
      a.setData_aluguel(rs.getString(5));
      a.setData_devolucao(rs.getString(6));
      lista.add(a);
      }
      return lista;
      }else{
      return null;
      }
      } catch (Exception e) {
      return null;
      }
  } 
   public String  AlterarSituacao(String situacao,int code){
  String sql = "UPDATE dvd SET situacao = ? WHERE iddvd = ?";
  
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
       
           ps.setString(1,situacao);
           ps.setInt(2,code);
           
           if (ps.executeUpdate() >0) {
               return "DVD Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
  }
    public String  AlterarSituacaoDevolver(String situacao,int code){
  String sql = "UPDATE dvd SET situacao = ? WHERE iddvd = ?";
  
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
       
           ps.setString(1,situacao);
           ps.setInt(2,code);
           
           if (ps.executeUpdate() >0) {
               return "DVD Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
  }
}
   

