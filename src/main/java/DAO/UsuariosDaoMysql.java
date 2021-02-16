/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.UsuarioDAO;
import com.mycompany.proyectodocker.Usuarios;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joescalante
 */
public class UsuariosDaoMysql implements UsuarioDAO {

    private Conexion cn;
    List<Usuarios> user;
    
    public UsuariosDaoMysql(){
        this.cn = Conexion.getConexion();
    }
    
    @Override
    public List<Usuarios> Listar() {
        String sql= "select * from usuarios";
               user= new ArrayList<Usuarios>();
               
               try{
                     ResultSet res=cn.query(sql);
                     while(res.next()){
                        Usuarios u=new Usuarios();
                        u.setId(res.getInt(1));
                        u.setNombre(res.getString(2));
                        u.setEdad(res.getString(3));
                        
                        user.add(u);
                     }
                     res.close();
               } catch (SQLException ex) {
                System.out.println("Err");
        }
               return user;
    }

    @Override
    public Usuarios obtener(int id) {
        try{
            ResultSet res=cn.query("SELECT * usuarios where id= "+id);
            while(res.next()){
            Usuarios u=new Usuarios();
            u.setId(res.getInt("id"));
            u.setNombre(res.getString("nombre"));
            u.setEdad(res.getString("edad"));
            
            return u;
        }
        res.close();
    }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void insertar(String nm, String ed) {
        try{
            String cs="INSERT INTO usuarios (nombre, edad) VALUES ('"+nm+"','"+ed+"')";
            cn.insert(cs);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());  
        }
    }

    @Override
    public void actualizar(Usuarios u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Usuarios u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
