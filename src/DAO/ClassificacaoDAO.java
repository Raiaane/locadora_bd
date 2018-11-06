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
    public String InserirClassificacao(Classificacao c){
    String sql = "INSERT INTO classificacao VALUES(0,?,?)";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1,c.getNome());
            ps.setDouble(2,c.getPreco());
            
            if(ps.executeUpdate()>0){
            return "Cadastrado com sucesso";
            }else{
                return "Erro ao cadastrar";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
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
            ps.setDouble(2,c.getPreco());
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
                    c.setPreco(rs.getDouble(3));
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
}