/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbviajepasajero;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbviajepasajeroFacadeLocal {

    void create(Tbviajepasajero tbviajepasajero);

    void edit(Tbviajepasajero tbviajepasajero);

    void remove(Tbviajepasajero tbviajepasajero);

    Tbviajepasajero find(Object id);

    List<Tbviajepasajero> findAll();

    List<Tbviajepasajero> findRange(int[] range);

    int count();
    //buscar pasajeros por idviaje
    List<Tbviajepasajero> buscarXIDviaje(Integer id);
}
