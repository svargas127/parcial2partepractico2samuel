package org.samuel_vargas.Main.Domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Canchas")
public class Gorra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo; // Ejemplo: fútbol, baloncesto, tenis

    @Column(nullable = false)
    private String ubicacion;

    @Column(nullable = false)
    private double precioPorHora;

    public Gorra(String nombre, String tipo, String ubicacion, double precioPorHora) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.precioPorHora = precioPorHora;
    }

    public Gorra() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gorra cancha = (Gorra) o;
        return id == cancha.id &&
                Double.compare(cancha.precioPorHora, precioPorHora) == 0 &&
                Objects.equals(nombre, cancha.nombre) &&
                Objects.equals(tipo, cancha.tipo) &&
                Objects.equals(ubicacion, cancha.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipo, ubicacion, precioPorHora);
    }

    @Override
    public String toString() {
        return "Cancha{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", precioPorHora=" + precioPorHora +
                '}';
    }
}
