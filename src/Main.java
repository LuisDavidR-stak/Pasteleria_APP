import java.sql.Connection;
import java.util.Map;

import com.pasteleria.conexion.conexionDB;
import com.pasteleria.dao.DashboardDAO;

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
        DashboardDAO dao = new DashboardDAO();
        Map<String, Object> datos = dao.obtenerMetricasResumen();

        System.out.println("--- PRUEBA DE MÉTRICAS DASHBOARD ---");
        System.out.println("Insumos Críticos: " + datos.get("insumosCriticos"));
        System.out.println("Caja de Hoy (S/): " + datos.get("totalCajaHoy"));
        System.out.println("Gastos del Mes (S/): " + datos.get("totalGastosMes"));
    }
}