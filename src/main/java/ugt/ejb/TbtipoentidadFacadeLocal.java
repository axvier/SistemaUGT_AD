/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbtipoentidad;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbtipoentidadFacadeLocal {

    void create(Tbtipoentidad tbtipoentidad);

    void edit(Tbtipoentidad tbtipoentidad);

    void remove(Tbtipoentidad tbtipoentidad);

    Tbtipoentidad find(Object id);

    List<Tbtipoentidad> findAll();

    List<Tbtipoentidad> findRange(int[] range);

    int count();
    
}
