/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbvehiculos;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbvehiculosFacadeLocal {

    void create(Tbvehiculos tbvehiculos);

    void edit(Tbvehiculos tbvehiculos);

    void remove(Tbvehiculos tbvehiculos);

    Tbvehiculos find(Object id);

    List<Tbvehiculos> findAll();

    List<Tbvehiculos> findRange(int[] range);

    int count();
    
    int modconductor(Tbvehiculos tbvehiculo, String placa);
    
    List<Tbvehiculos> disponibles();
    
}
