/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tblicencias;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TblicenciasFacadeLocal {

    void create(Tblicencias tblicencias);

    void edit(Tblicencias tblicencias);

    void remove(Tblicencias tblicencias);

    Tblicencias find(Object id);

    List<Tblicencias> findAll();

    List<Tblicencias> findRange(int[] range);

    int count();
    
}
