package exemplobanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vando
 */
public class Conexao {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection conn;
    private String url;
    private String usuario;
    private String senha;

    private final Conexao INSTANCIA;
    
    public Conexao() {
        
         try {
            url = "jdbc:postgresql://localhost:5432/pedidos";
            usuario = "postgres";
            senha = "postgres";
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Conexao getConexao(){
        if(INSTANCIA == null) {
            INSTANCIA = new Conexao();
            return INSTANCIA;
        }
    }

}
