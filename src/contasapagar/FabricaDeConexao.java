package contasapagar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hj
 */
public class FabricaDeConexao {
    
    private static Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/contasapagar";
    private static String usuario ="root";
    private static String senha ="root";
    
    public static Connection getConexao() throws SQLException{
        if(conn == null){
            conn = DriverManager.getConnection(url,usuario, senha);
        }
        return conn;
    }
}
