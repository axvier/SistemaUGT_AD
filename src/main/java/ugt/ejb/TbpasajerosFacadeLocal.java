/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbpasajeros;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbpasajerosFacadeLocal {

    void create(Tbpasajeros tbpasajeros);

    void edit(Tbpasajeros tbpasajeros);

    void remove(Tbpasajeros tbpasajeros);

    Tbpasajeros find(Object id);

    List<Tbpasajeros> findAll();

    List<Tbpasajeros> findRange(int[] range);

    int count();
    
}
