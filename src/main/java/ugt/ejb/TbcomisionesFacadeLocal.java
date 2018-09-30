/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbcomisiones;

/**
 *
 * @author Usuario
 */
@Local
public interface TbcomisionesFacadeLocal {

    void create(Tbcomisiones tbcomisiones);

    void edit(Tbcomisiones tbcomisiones);

    void remove(Tbcomisiones tbcomisiones);

    Tbcomisiones find(Object id);

    List<Tbcomisiones> findAll();

    List<Tbcomisiones> findRange(int[] range);

    int count();
    
}
