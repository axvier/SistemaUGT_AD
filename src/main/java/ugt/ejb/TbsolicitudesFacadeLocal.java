/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbsolicitudes;
import ugt.solicitudes.Solicitudesfull;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbsolicitudesFacadeLocal {

    void create(Tbsolicitudes tbsolicitudes);

    void edit(Tbsolicitudes tbsolicitudes);

    void remove(Tbsolicitudes tbsolicitudes);

    Tbsolicitudes find(Object id);

    List<Tbsolicitudes> findAll();

    List<Tbsolicitudes> findRange(int[] range);

    int count();
    
    List<Tbsolicitudes> buscarallxcedula(String cedula);
    
    List<Tbsolicitudes> filtrarXestado(String estado);
}
