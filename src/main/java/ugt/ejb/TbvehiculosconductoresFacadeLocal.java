/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbvehiculosconductores;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbvehiculosconductoresFacadeLocal {

    void create(Tbvehiculosconductores tbvehiculosconductores);

    void edit(Tbvehiculosconductores tbvehiculosconductores);

    void remove(Tbvehiculosconductores tbvehiculosconductores);

    Tbvehiculosconductores find(Object id);

    List<Tbvehiculosconductores> findAll();

    List<Tbvehiculosconductores> findRange(int[] range);

    int count();
    
    //buscar por cedula
    
    List<Tbvehiculosconductores> buscarxcedula(String cedula);
    
    Tbvehiculosconductores buscarxplaca(String placa);
    
    Tbvehiculosconductores modificar(String cedula,String placa, String fecha, Tbvehiculosconductores objeto);
    
    List<Tbvehiculosconductores> findALLFechFinNull();
}
