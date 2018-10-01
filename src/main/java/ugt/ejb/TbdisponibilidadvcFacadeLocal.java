/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbdisponibilidadvc;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbdisponibilidadvcFacadeLocal {

    void create(Tbdisponibilidadvc tbdisponibilidadvc);

    void edit(Tbdisponibilidadvc tbdisponibilidadvc);

    void remove(Tbdisponibilidadvc tbdisponibilidadvc);

    Tbdisponibilidadvc find(Object id);

    List<Tbdisponibilidadvc> findAll();

    List<Tbdisponibilidadvc> findRange(int[] range);

    int count();
    
}
