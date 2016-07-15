package com.example;

import javax.persistence.*;


@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String marca;
    private String modelo;
    private Integer año;
    private Double precio;
    private String matricula;
    @ManyToOne //Una persona puede tener mñás de un coche
    private Persona propietario;

    public Coche(String marca, String modelo, Integer año, Double precio, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
        this.matricula = matricula;
    }

    public Coche() {
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coche coche = (Coche) o;

        if (!getId().equals(coche.getId())) return false;
        if (!getMarca().equals(coche.getMarca())) return false;
        if (!getModelo().equals(coche.getModelo())) return false;
        if (!getAño().equals(coche.getAño())) return false;
        if (!getPrecio().equals(coche.getPrecio())) return false;
        return getMatricula().equals(coche.getMatricula());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getMarca().hashCode();
        result = 31 * result + getModelo().hashCode();
        result = 31 * result + getAño().hashCode();
        result = 31 * result + getPrecio().hashCode();
        result = 31 * result + getMatricula().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", precio=" + precio +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
