/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbgrupovehiculos;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbgrupovehiculosFacadeLocal {

    void create(Tbgrupovehiculos tbgrupovehiculos);

    void edit(Tbgrupovehiculos tbgrupovehiculos);

    void remove(Tbgrupovehiculos tbgrupovehiculos);

    Tbgrupovehiculos find(Object id);

    List<Tbgrupovehiculos> findAll();

    List<Tbgrupovehiculos> findRange(int[] range);

    int count();
    
}
