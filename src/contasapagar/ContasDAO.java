/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contasapagar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author hj
 */
public class ContasDAO {

    private Connection conn;
  
    public ContasDAO() throws SQLException {
        conn = FabricaDeConexao.getConexao();

    }

    public void AdicionarContas(Conta c) throws ParseException {
        String sql = "INSERT INTO contas(descricao,empresa,tipoconta,formaPagamento,emissao,valor,vencimento)VALUES(?,?,?,?,?,?,?)"; 
   
        try {

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getDescricao());
            stmt.setString(2, c.getEmpresa());
            stmt.setString(3, c.getTipoConta());
            stmt.setString(4, c.getFormaDePg());
            stmt.setDate(5, c.getEmissao());
            stmt.setDouble(6, c.getValorTotal());
            stmt.setDate(7, c.getVencimento());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

}
