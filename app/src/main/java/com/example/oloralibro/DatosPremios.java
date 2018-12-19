package com.example.oloralibro;

import org.json.JSONException;
import org.json.JSONObject;

public class DatosPremios {
    public String nombrePremio;
    public String descripcionPremio;
    public int costePremio;
    public int imagenPremio;

    public DatosPremios(String nombrePremio, String descripcionPremio, int costePremio, int imagenPremio) {
        this.nombrePremio = nombrePremio;
        this.descripcionPremio = descripcionPremio;
        this.costePremio = costePremio;
        this.imagenPremio = imagenPremio;
    }

    public String getNombrePremio() {
        return nombrePremio;
    }

    public void setNombrePremio(String nombrePremio) {
        this.nombrePremio = nombrePremio;
    }

    public String getDescripcionPremio() {
        return descripcionPremio;
    }

    public void setDescripcionPremio(String descripcionPremio) {
        this.descripcionPremio = descripcionPremio;
    }

    public int getCostePremio() {
        return costePremio;
    }

    public void setCostePremio(int costePremio) {
        this.costePremio = costePremio;
    }

    public int getImagenPremio() {
        return imagenPremio;
    }

    public void setImagenPremio(int imagenPremio) {
        this.imagenPremio = imagenPremio;
    }
}
