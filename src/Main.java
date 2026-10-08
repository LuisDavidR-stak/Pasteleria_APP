import java.sql.Connection;
import com.pasteleria.conexion.conexionDB;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection con = conexionDB.obtenerConexion();
        if (con != null) {
            System.out.println("✅ ¡Conexión exitosa a SQL Server!");
        } else {
            System.out.println("❌ No se pudo conectar.");
        }
    }
}