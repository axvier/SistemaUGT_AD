/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbcargos;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbcargosFacadeLocal {

    void create(Tbcargos tbcargos);

    void edit(Tbcargos tbcargos);

    void remove(Tbcargos tbcargos);

    Tbcargos find(Object id);

    List<Tbcargos> findAll();

    List<Tbcargos> findRange(int[] range);

    int count();
    
}
