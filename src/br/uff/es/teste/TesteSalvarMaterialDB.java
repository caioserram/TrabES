/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.es.teste;

import br.uff.es.persistencia.MaterialPersistenteDB;
import br.uff.es.modelo.Material;

/**
 *
 * @author felipe
 */
public class TesteSalvarMaterialDB {

    public static void main(String[] args) {
        Material m1 = new Material("Tinta", "Tinta preta", 2.5);
        Material m2 = new Material("Tinta", "Tinta azul", 2.5);
        Material m3 = new Material("Tinta", "Tinta verde", 2.5);

        MaterialPersistenteDB mp = new MaterialPersistenteDB();
        //mp.criarTabelaMaterial();

        //mp.salvarObjeto(m1);
        //mp.salvarObjeto(m2);
        //mp.salvarObjeto(m3);
        Material mr = (Material) mp.recuperarObjeto(m1);
        System.out.println(mr);

        Material mrd = (Material) mp.recuperarMaterialDescricao("Tinta verde");
        System.out.println(mrd);

        for (Material m : mp.recuperarListaMaterialNome("Tinta")) {
            System.out.println(m);
        }

    }

}
