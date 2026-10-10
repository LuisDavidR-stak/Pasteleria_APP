package com.pasteleria.dao;

import com.pasteleria.conexion.conexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DashboardDAO {
    /**
     * Obtiene los tres indicadores principales para las tarjetas superiores del Dashboard.
     * Retorna un mapa con las claves: "insumosCriticos", "totalCajaHoy", "totalGastosMes".
     */
    public Map<String, Object> obtenerMetricasResumen() {
        Map<String, Object> metricas = new HashMap<>();

        // Valores por defecto
        metricas.put("insumosCriticos", 0);
        metricas.put("totalCajaHoy", 0.0);
        metricas.put("totalGastosMes", 0.0);

        String sqlInsumos = "SELECT COUNT(*) AS total FROM Insumos WHERE stock_actual <= stock_minimo";
        String sqlCaja = "SELECT ISNULL(SUM(total), 0) AS total FROM Ventas WHERE CAST(fecha_venta AS DATE) = CAST(GETDATE() AS DATE) AND estado = 'Completada'";
        String sqlGastos = "SELECT ISNULL(SUM(monto), 0) AS total FROM GastosOperativos WHERE MONTH(fecha_gasto) = MONTH(GETDATE()) AND YEAR(fecha_gasto) = YEAR(GETDATE())";

        try (Connection con = conexionDB.obtenerConexion()) {
            if (con == null) return metricas;

            // 1. Insumos Críticos
            try (PreparedStatement ps = con.prepareStatement(sqlInsumos);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    metricas.put("insumosCriticos", rs.getInt("total"));
                }
            }

            // 2. Caja de Hoy
            try (PreparedStatement ps = con.prepareStatement(sqlCaja);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    metricas.put("totalCajaHoy", rs.getDouble("total"));
                }
            }

            // 3. Gastos del Mes
            try (PreparedStatement ps = con.prepareStatement(sqlGastos);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    metricas.put("totalGastosMes", rs.getDouble("total"));
                }
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar métricas del Dashboard: " + e.getMessage());
        }

        return metricas;
    }
}
