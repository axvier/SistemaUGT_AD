/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbseccionsolicitantes;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbseccionsolicitantesFacadeLocal {

    void create(Tbseccionsolicitantes tbseccionsolicitantes);

    void edit(Tbseccionsolicitantes tbseccionsolicitantes);

    void remove(Tbseccionsolicitantes tbseccionsolicitantes);

    Tbseccionsolicitantes find(Object id);

    List<Tbseccionsolicitantes> findAll();

    List<Tbseccionsolicitantes> findRange(int[] range);

    int count();
    
}
