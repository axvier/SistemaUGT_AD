/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbusuarios;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbusuariosFacadeLocal {

    void create(Tbusuarios tbusuarios);

    void edit(Tbusuarios tbusuarios);

    void remove(Tbusuarios tbusuarios);

    Tbusuarios find(Object id);

    List<Tbusuarios> findAll();

    List<Tbusuarios> findRange(int[] range);

    int count();
    
}
