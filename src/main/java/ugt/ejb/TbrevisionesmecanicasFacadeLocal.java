/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbrevisionesmecanicas;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbrevisionesmecanicasFacadeLocal {

    void create(Tbrevisionesmecanicas tbrevisionesmecanicas);

    void edit(Tbrevisionesmecanicas tbrevisionesmecanicas);

    void remove(Tbrevisionesmecanicas tbrevisionesmecanicas);

    Tbrevisionesmecanicas find(Object id);

    List<Tbrevisionesmecanicas> findAll();

    List<Tbrevisionesmecanicas> findRange(int[] range);

    int count();
    
}
