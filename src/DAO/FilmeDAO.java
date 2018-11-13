/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Filme;
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
public class FilmeDAO extends ExecuteSQL {
    public FilmeDAO(Connection con){
    super(con);
    }
    
    public String InserirFilme(Filme f){
      String sql = "INSERT INTO filme VALUES (0,?,?,?,?,?,?)";  
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,f.getTitulo());
            ps.setInt(2,f.getAno());
            ps.setString(3,f.getDuracao());
            ps.setInt(4,f.getCod_categoria());
            ps.setInt(5,f.getCod_classificacao());
            ps.setString(6,f.getCapa());
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
   public boolean Testar_Filme(int cod){
   boolean result = false;
   
       try{
          String sql = "SELECT * FROM filme WHERE idfilme = '"+cod+"'";
           
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
    public List<Filme> CapturarFilme(int cod){
    String sql = "SELECT * FROM filme WHERE idfilme = '"+cod+"'";
    List<Filme> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
                    f.setTitulo(rs.getString(2));
                    f.setAno(rs.getShort(3));
                    f.setDuracao(rs.getString(4));
                    f.setCod_categoria(rs.getInt(5));
                    f.setCod_classificacao(rs.getInt(6));
                    f.setCapa(rs.getString(7));
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
     public String Alterar_Filme(Filme f){
   String sql = "UPDATE filme SET titulo = ? ,ano = ? ,duracao = ?, idcategoria = ? ,idclassificacao = ? ,capa = ? WHERE idfilme = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setString(1,f.getTitulo());
           ps.setInt(2,f.getAno());
           ps.setString(3,f.getDuracao());
           ps.setInt(4, f.getCod_categoria());
           ps.setInt(5, f.getCod_classificacao());
           ps.setString(6,f.getCapa());
           ps.setInt(7,f.getCodigo());
           if (ps.executeUpdate() >0) {
               return "Filme Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   
   }
   //Consultar
   public List<Filme> ListarFilme(){
   String sql = "SELECT * FROM filme";
   List<Filme> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Filme f = new Filme();
                f.setCodigo(rs.getInt(1));
                f.setTitulo(rs.getString(2));
                f.setAno(rs.getInt(3));
                f.setDuracao(rs.getString(4));
                f.setCod_categoria(rs.getInt(5));
                f.setCod_classificacao(rs.getInt(6));
                f.setCapa(rs.getString(7));
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
   public List<Filme> Listar_Nome_Filme(String nome){
   String sql = "SELECT * FROM filme WHERE titulo LIKE '%"+nome+"%'";
   List<Filme> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Filme f = new Filme();
                f.setCodigo(rs.getInt(1));
                f.setTitulo(rs.getString(2));
                f.setAno(rs.getInt(3));
                f.setDuracao(rs.getString(4));
                f.setCod_categoria(rs.getInt(5));
                f.setCod_classificacao(rs.getInt(6));
                f.setCapa(rs.getString(7));
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
   public List<Filme> Listar_Codigo_Filme(int cod){
   String sql = "SELECT * FROM filme WHERE idfilme ='"+cod+"'";
   List<Filme> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Filme f = new Filme();
                f.setCodigo(rs.getInt(1));
                f.setTitulo(rs.getString(2));
                f.setAno(rs.getInt(3));
                f.setDuracao(rs.getString(4));
                f.setCod_categoria(rs.getInt(5));
                f.setCod_classificacao(rs.getInt(6));
                f.setCapa(rs.getString(7));
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
   public List<Filme> ListarComboFilme(){
   String sql = "SELECT titulo FROM filme";
   List<Filme> lista = new ArrayList<>();
   
       try {
           PreparedStatement pr = getCon().prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           if(rs!= null){
            while(rs.next()){
                Filme f = new Filme();
                f.setTitulo(rs.getString(1));
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
   public List<Filme> ConsultaCodigoFilme(String nome){
   String sql = "SELECT idfilme FROM filme WHERE titulo = '"+nome+"'";
   List<Filme> lista = new ArrayList<>();
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!= null){
                while(rs.next()){
                    Filme f = new Filme();
                    f.setCodigo(rs.getInt(1));
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
   public String ExcluirFilme(Filme f){
   String sql = "DELETE FROM filme WHERE idfilme = ? AND titulo = ?";
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, f.getCodigo());
           ps.setString(2,f.getTitulo());
           if(ps.executeUpdate()>0){
                return "Excluido com sucesso!";
           }else{
                return "Erro ao excluir!";
           }
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   }
   public List<Filme> PesquisarCodFilme(int cod){
   String sql = "SELECT idfilme,titulo,ano,duracao,idcategoria,idclassificacao,capa FROM filme WHERE idfilme='"+cod+"'";
   List<Filme> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
           while(rs.next()){
           Filme f = new Filme();
                f.setCodigo(rs.getInt(1));
                f.setTitulo(rs.getString(2));
                f.setAno(rs.getInt(3));
                f.setDuracao(rs.getString(4));
                f.setCod_categoria(rs.getInt(5));
                f.setCod_classificacao(rs.getInt(6));
                f.setCapa(rs.getString(7));
                lista.add(f);         
           
           }
           return lista;
           }else{
           return null;
           }
           
       } catch (SQLException e) {
       return null;
       }
   
   }
  
}

