/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.es.persistencia;

/**
 *
 * @author felipe
 */
public interface IObjetoPersistente {

    public abstract boolean salvarObjeto(Object objeto);

    public abstract Object recuperarObjeto(Object objeto);

}
