/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.mycompany.proyectodocker.Usuarios;
import java.util.List;

/**
 *
 * @author joescalante
 */
public interface UsuarioDAO {
    
    public List<Usuarios> Listar();
    public Usuarios obtener(int id);
    public void insertar(String nm, String ed);
    public void actualizar(Usuarios u);
    public void eliminar(Usuarios u);
    
    
    
}
