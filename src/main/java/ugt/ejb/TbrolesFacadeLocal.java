/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbroles;

/**
 *
 * @author Usuario
 */
@Local
public interface TbrolesFacadeLocal {

    void create(Tbroles tbroles);

    void edit(Tbroles tbroles);

    void remove(Tbroles tbroles);

    Tbroles find(Object id);

    List<Tbroles> findAll();

    List<Tbroles> findRange(int[] range);

    int count();
    
}
