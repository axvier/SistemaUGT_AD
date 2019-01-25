/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbregistros;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbregistrosFacadeLocal {

    void create(Tbregistros tbregistros);

    void edit(Tbregistros tbregistros);

    void remove(Tbregistros tbregistros);

    Tbregistros find(Object id);

    List<Tbregistros> findAll();

    List<Tbregistros> findRange(int[] range);

    int count();
    
    List<Tbregistros> findById_TablaDescFecha(String idtabla,String tabla);
    
}
