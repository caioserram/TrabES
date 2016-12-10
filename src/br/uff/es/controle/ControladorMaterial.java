/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.es.controle;

import br.uff.es.modelo.Material;
import br.uff.es.persistencia.MaterialPersistenteDB;
import java.util.List;

/**
 *
 * @author felipe
 */
public class ControladorMaterial {

    private static final MaterialPersistenteDB MPDB = new MaterialPersistenteDB();

    public static boolean inserirMaterial(String nome, String descricao, Double valorUnitario) {
        return MPDB.salvarObjeto(new Material(nome, descricao, valorUnitario));
    }

    public static Material recuperarMaterialPorDescricao(String descricao) {
        return (Material) MPDB.recuperarMaterialDescricao(descricao);
    }

    public static List<Material> recuperarListaMaterialPorNome(String nome) {
        return MPDB.recuperarListaMaterialNome(nome);
    }
    
    public static List<Material> recuperarListaMaterial() {
        return MPDB.recuperarMateriais();
    }

}
