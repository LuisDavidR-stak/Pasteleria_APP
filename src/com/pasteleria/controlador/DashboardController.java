package com.pasteleria.controlador;

import com.pasteleria.dao.DashboardDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML private Label lblInsumosCriticos;
    @FXML private Label lblCajaHoy;
    @FXML private Label lblGastosMes;

    private final DashboardDAO dashboardDAO = new DashboardDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarMetricas();
    }

    @FXML
    public void cargarMetricas() {
        Map<String, Object> metricas = dashboardDAO.obtenerMetricasResumen();

        int criticos = (int) metricas.getOrDefault("insumosCriticos", 0);
        double caja = (double) metricas.getOrDefault("totalCajaHoy", 0.0);
        double gastos = (double) metricas.getOrDefault("totalGastosMes", 0.0);

        lblInsumosCriticos.setText(String.valueOf(criticos));
        lblCajaHoy.setText(String.format("S/ %.2f", caja));
        lblGastosMes.setText(String.format("S/ %.2f", gastos));
    }
}
