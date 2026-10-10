package com.pasteleria.modelo;

public class Insumo {
    private int idInsumo;
    private String nombre;
    private String unidadMedida; // 'gramos', 'ml', 'unidad'
    private double stockActual;
    private double stockMinimo;
    private double costoUnitario;

    public Insumo() {}

    public Insumo(int idInsumo, String nombre, String unidadMedida, double stockActual, double stockMinimo, double costoUnitario) {
        this.idInsumo = idInsumo;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.costoUnitario = costoUnitario;
    }

    public Insumo(String nombre, String unidadMedida, double stockActual, double stockMinimo, double costoUnitario) {
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.costoUnitario = costoUnitario;
    }

    // Getters y Setters
    public int getIdInsumo() { return idInsumo; }
    public void setIdInsumo(int idInsumo) { this.idInsumo = idInsumo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    public double getStockActual() { return stockActual; }
    public void setStockActual(double stockActual) { this.stockActual = stockActual; }

    public double getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(double stockMinimo) { this.stockMinimo = stockMinimo; }

    public double getCostoUnitario() { return costoUnitario; }
    public void setCostoUnitario(double costoUnitario) { this.costoUnitario = costoUnitario; }

    public boolean esCritico() {
        return this.stockActual <= this.stockMinimo;
    }
}
