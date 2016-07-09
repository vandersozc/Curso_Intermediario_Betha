/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplobanco;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Vando
 */
public class ExemploBanco {
    
    public static void main(String[] args) throws SQLException {
         Connection conn = Conexao.getConexao().getConn();
         
         Statement stm = conn.createStatement();
         String sql = "select * from totais_por_cliente";
         ResultSet rs = stm.executeQuery(sql);
         
         while (rs.next()) {
            String codigo = rs.getString("codigo");
            String nome = rs.getString("nome");
            BigDecimal valorTotal = rs.getBigDecimal("valor_total");
            Date ultimaCompra = rs.getDate("ultima_compra");
            
             System.out.println(String.format("%s|%s|%.2f|%s|",
                     codigo, nome,valorTotal,ultimaCompra));
        }
    }
    
}
