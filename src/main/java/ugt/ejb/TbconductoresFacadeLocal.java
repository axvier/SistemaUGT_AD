/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbconductores;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbconductoresFacadeLocal {

    void create(Tbconductores tbconductores);

    void edit(Tbconductores tbconductores);

    void remove(Tbconductores tbconductores);

    Tbconductores find(Object id);

    List<Tbconductores> findAll();

    List<Tbconductores> findRange(int[] range);

    int count();
    
    //nuevo
    List<Tbconductores> disponibles();
    
    List<Tbconductores> bloqueados();
    
    int modconductor(Tbconductores tbconductores, String cedula);
    
    List<Tbconductores> findAllOrden(String forma,String campo);
}
