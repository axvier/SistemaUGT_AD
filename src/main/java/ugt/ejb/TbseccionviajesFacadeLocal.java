/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbseccionviajes;

/**
 *
 * @author Usuario
 */
@Local
public interface TbseccionviajesFacadeLocal {

    void create(Tbseccionviajes tbseccionviajes);

    void edit(Tbseccionviajes tbseccionviajes);

    void remove(Tbseccionviajes tbseccionviajes);

    Tbseccionviajes find(Object id);

    List<Tbseccionviajes> findAll();

    List<Tbseccionviajes> findRange(int[] range);

    int count();
    
}
