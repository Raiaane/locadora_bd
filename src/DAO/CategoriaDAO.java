/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
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
public class CategoriaDAO extends ExecuteSQL{
     public CategoriaDAO(Connection con) {
        super(con);
    }
    public String InserirCategoria(Categoria c){
    
    String sql = "insert into categoria VALUES(0,?)";

    try {
       
        PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, c.getNome());
            
        if(ps.executeUpdate()>0){
        return "Cadastrado com sucesso";
        }else{
        return "Erro ao cadastrar";
        }
        
    } catch (SQLException e) {
        return e.getMessage();
    }
    } 
    //Alterar
    public String Alterar_Classificacao(Categoria c){
    String sql = "UPDATE Categoria SET nome=? WHERE idcategoria=?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setInt(2,c.getCodigo());
            
            if (ps.executeUpdate()>0) {
                return "Atualizado com sucesso";
            }else{
                return "Erro ao atualizar";
                       
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }       
}
    //testar
    public boolean Testar_Categoria(int cod){
        boolean result =false;
        try {
            String sql = "SELECT * FROM categoria WHERE idcategoria='"+cod+"'";
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
    //Capturar
    public List<Categoria> CapturarCategoria(int cod){
        String sql = "SELECT * FROM categoria WHERE idcategoria='"+cod+"'";
        List<Categoria> lista = new ArrayList<>();

        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Categoria c = new Categoria();
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
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
