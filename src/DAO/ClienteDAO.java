/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
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
public class ClienteDAO extends ExecuteSQL {

    public ClienteDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Cliente(Cliente a){
        
        String sql = "insert into cliente values (0,?,?,?,?,?,?,?,?,?,?)";
    
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
             ps.setString(1, a.getNome());
             ps.setString(2, a.getNascimento());
             ps.setString(3, a.getRG());
             ps.setString(4, a.getCPF());
             ps.setString(5, a.getEmail());
             ps.setString(6, a.getTelefone());
             ps.setString(7, a.getBairro());
             ps.setString(8, a.getRua());
             ps.setInt(9, a.getNumero());
             ps.setString(10, a.getCEP());
              
              if(ps.executeUpdate() > 0){
              
                  return "Inserido com sucesso";
              
              } else {
              
                  return "Erro ao inserir";
            
              }
              
        } catch (SQLException e){
        
            return e.getMessage();
        
        }
    }

    
    //Listar
    
    public List<Cliente> ListarCliente(){
        String sql = "select idcliente, nome, rg, cpf, telefone, email from cliente";
        List <Cliente> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  Cliente a = new Cliente();
                  a.setCodigo(rs.getInt(1));
                  a.setNome(rs.getString(2));
                  a.setRG(rs.getString(3));
                  a.setCPF(rs.getString(4));
                  a.setTelefone(rs.getString(5));
                  a.setEmail(rs.getString (6));
                  
                  lista.add(a);
                  
              }
              return lista;
          }else{
              return null;
          }
          
 
        }catch (SQLException e){
            return null;
        
        }
    }
    
    //pesquisar cliente 
    
    public List<Cliente> Pesquisar_Nome_Cliente(String nome){
        String sql = "select idcliente, nome, RG, CPF, Telefone, Email"+
                "from cliente where nome Like '"+nome+ "%'";
         List <Cliente> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  Cliente a = new Cliente();
                  a.setCodigo(rs.getInt(1));
                  a.setNome(rs.getString(2));
                  a.setRG(rs.getString(3));
                  a.setCPF(rs.getString(4));
                  a.setTelefone(rs.getString(5));
                  a.setEmail(rs.getString (6));
                  
                  lista.add(a);
                  
              }
              return lista;
          }else{
              return null;
          }
          
 
        }catch (SQLException e){
            return null;
        
        }
    
    }
    
    //testar cliente 
    
    public boolean Testar_Cliente (int cod){
       boolean Resultado = false;
       try{
           String sql = "select * from  cliente where idcliente = "+cod+"";
            PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if(rs != null){
                 while(rs.next()){
                     Resultado = true;
                     
                 }
             }
       } catch (SQLException ex){
           ex.getMessage();   
       }
       return Resultado;
    }
    
    
    //Capturar cliente
    public List<Cliente> CapturarCliente(int cod){
    String sql = "SELECT * FROM cliente WHERE idcliente = '"+cod+"'";
    List<Cliente> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Cliente c = new Cliente();
                    PreparedStatement ps = getCon().prepareStatement(sql);
                    c.setCodigo(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setNascimento(rs.getString(3));
                    c.setRG(rs.getString(4));
                    c.setCPF(rs.getString(5));
                    c.setEmail(rs.getString(6));
                    c.setTelefone(rs.getString(7));
                    c.setBairro(rs.getString(8));
                    c.setRua(rs.getString(9));
                    c.setNumero(rs.getInt(10));
                    c.setCEP(rs.getString(11));
                    lista.add(c);

                }
                return lista;
            }else{
                return null;
            }                    
        } catch (SQLException e) {
            return null;
        }
    }
       //Alterar
     public String Alterar_Cliente(Cliente c){
   String sql = "UPDATE cliente SET Nome = ?, data_nasc=?, rg=?, cpf=?, email=?, telefone=?, bairro=?, rua=?, numero=?, cep=?  WHERE idcliente = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
                    ps.setString(1,c.getNome());
                    ps.setString(2,c.getNascimento());
                    ps.setString(3,c.getRG());
                    ps.setString(4,c.getCPF());
                    ps.setString(5,c.getEmail());
                    ps.setString(6,c.getTelefone());
                    ps.setString(7,c.getBairro());
                    ps.setString(8,c.getRua());
                    ps.setInt(9,c.getNumero());
                    ps.setString(10,c.getCEP());
                    ps.setInt(11,c.getCodigo());
           
           if (ps.executeUpdate() > 0) {
               return "Cliente Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException e) {
           return e.getMessage();
       }
     }
   //ListarCombo Cliente
   public List<Cliente> ListarComboCliente(){
   String sql = "select nome from cliente order by nome";
   List<Cliente> lista = new ArrayList<>();
   
       try {
           PreparedStatement pr = getCon().prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           if(rs!= null){
            while(rs.next()){
                Cliente c = new Cliente();
                c.setNome(rs.getString(1));
                lista.add(c);
            }        
            return lista;
           }else{
            return null;
           }           
       } catch (SQLException ex) {
       return null;
       }
   
   }
   
   //Consultar
   public List<Cliente> Listar_Codigo_Cliente(int cod){
   String sql = "SELECT * FROM cliente WHERE idcliente ='"+cod+"'";
   List<Cliente> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Cliente a = new Cliente();
                a.setCodigo(rs.getInt(1));
                lista.add(a);
                
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException e) {
       return null;
       }
   }
   //Excluir
   public String ExcluirCliente(Cliente f){
   String sql = "DELETE FROM cliente WHERE idcliente = ? AND Nome = ?";
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, f.getCodigo());
           ps.setString(2,f.getNome());
           if(ps.executeUpdate()>0){
                return "Excluido com sucesso!";
           }else{
                return "Erro ao excluir!";
           }
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   }
   }

