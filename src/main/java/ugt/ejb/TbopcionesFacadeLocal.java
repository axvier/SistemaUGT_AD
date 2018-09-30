/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbopciones;

/**
 *
 * @author Usuario
 */
@Local
public interface TbopcionesFacadeLocal {

    void create(Tbopciones tbopciones);

    void edit(Tbopciones tbopciones);

    void remove(Tbopciones tbopciones);

    Tbopciones find(Object id);

    List<Tbopciones> findAll();

    List<Tbopciones> findRange(int[] range);

    int count();
    
}
