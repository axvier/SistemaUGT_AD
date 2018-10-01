/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbentidad;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbentidadFacadeLocal {

    void create(Tbentidad tbentidad);

    void edit(Tbentidad tbentidad);

    void remove(Tbentidad tbentidad);

    Tbentidad find(Object id);

    List<Tbentidad> findAll();

    List<Tbentidad> findRange(int[] range);

    int count();
    
}
