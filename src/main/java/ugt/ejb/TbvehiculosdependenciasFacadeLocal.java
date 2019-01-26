/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbvehiculosdependencias;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbvehiculosdependenciasFacadeLocal {

    void create(Tbvehiculosdependencias tbvehiculosdependencias);

    void edit(Tbvehiculosdependencias tbvehiculosdependencias);

    void remove(Tbvehiculosdependencias tbvehiculosdependencias);

    Tbvehiculosdependencias find(Object id);

    List<Tbvehiculosdependencias> findAll();

    List<Tbvehiculosdependencias> findRange(int[] range);

    int count();
    
    Tbvehiculosdependencias findByPlaca(String placa);
}
