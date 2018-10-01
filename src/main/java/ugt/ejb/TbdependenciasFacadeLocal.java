/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbdependencias;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbdependenciasFacadeLocal {

    void create(Tbdependencias tbdependencias);

    void edit(Tbdependencias tbdependencias);

    void remove(Tbdependencias tbdependencias);

    Tbdependencias find(Object id);

    List<Tbdependencias> findAll();

    List<Tbdependencias> findRange(int[] range);

    int count();
    
}
