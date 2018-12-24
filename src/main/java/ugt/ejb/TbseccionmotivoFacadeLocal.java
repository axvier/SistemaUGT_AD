/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbseccionmotivo;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbseccionmotivoFacadeLocal {

    void create(Tbseccionmotivo tbseccionmotivo);

    void edit(Tbseccionmotivo tbseccionmotivo);

    void remove(Tbseccionmotivo tbseccionmotivo);

    Tbseccionmotivo find(Object id);

    List<Tbseccionmotivo> findAll();

    List<Tbseccionmotivo> findRange(int[] range);

    int count();
    
    //buscar motivo por id de solicitud
    Tbseccionmotivo buscarXIDsolicitud(int id);
}
