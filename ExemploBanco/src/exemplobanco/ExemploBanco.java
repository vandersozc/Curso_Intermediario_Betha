package exemplobanco;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vando
 */
public class ExemploBanco {

    public static void main(String[] args) {
        try {
            Connection conn = Conexao.get().getConn();
            Statement stm = conn.createStatement();
            String sql = "select * from totais_por_clientes";
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()){
                String codigo = rs.getString("codigo");
                String nome = rs.getString("nome");
                BigDecimal valorTotal = rs.getBigDecimal("valor_total");
                Date ultimaCompra = rs.getDate("ultima_compra");
                
                System.out.println(String.format("%s|%s|%.2f|%s", 
                        codigo, nome, valorTotal, ultimaCompra));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExemploBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
