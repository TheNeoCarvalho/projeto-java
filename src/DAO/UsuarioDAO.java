package DAO;
import Factory.ConnectionFactory;
import java.sql.*;
import Modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    private Connection connection;
    
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void AdicionaUsuario(Usuario usuario){
    
        String sql = "INSERT INTO usuario (nome, cpf, email, telefone) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
