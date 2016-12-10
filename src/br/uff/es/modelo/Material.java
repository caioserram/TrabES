/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.es.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author felipe
 */
public class Material implements Serializable {

    private int id;
    private String nome;
    private String descricao;
    private double valorUnitario;

    public Material() {
    }

    public Material(String nome, String descricao, double valorUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.descricao);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valorUnitario) ^ (Double.doubleToLongBits(this.valorUnitario) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }

        return Objects.equals(this.descricao, other.descricao);
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", valorUnitario=" + valorUnitario + '}';
    }

}
