/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbusuariosentidad;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbusuariosentidadFacadeLocal {

    void create(Tbusuariosentidad tbusuariosentidad);

    void edit(Tbusuariosentidad tbusuariosentidad);

    void remove(Tbusuariosentidad tbusuariosentidad);

    Tbusuariosentidad find(Object id);

    List<Tbusuariosentidad> findAll();

    List<Tbusuariosentidad> findRange(int[] range);

    int count();
    
    List<Tbusuariosentidad> buscarusuarioentidad(String cedula);
    
    List<Tbusuariosentidad> totalusuarioentidad(String cedula);
    
    Tbusuariosentidad bentidadusuario(String cedula, String idrol);
}
