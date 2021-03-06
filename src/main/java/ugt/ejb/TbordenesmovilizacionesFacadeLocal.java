/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbordenesmovilizaciones;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbordenesmovilizacionesFacadeLocal {

    void create(Tbordenesmovilizaciones tbordenesmovilizaciones);

    void edit(Tbordenesmovilizaciones tbordenesmovilizaciones);

    void remove(Tbordenesmovilizaciones tbordenesmovilizaciones);

    Tbordenesmovilizaciones find(Object id);

    List<Tbordenesmovilizaciones> findAll();

    List<Tbordenesmovilizaciones> findRange(int[] range);

    int count();
    
    Tbordenesmovilizaciones filtrarOrdenXIdsol(Integer idsolicitud);
    
    Tbordenesmovilizaciones filtrarOrdenXIdsol(Integer idsolicitud,Date startDate, Date endDate);
    
    List<Tbordenesmovilizaciones> findAllOderby(String campo,String orden);
    
    List<Tbordenesmovilizaciones> findAllOderby(String campo,String orden, Date inicio, Date fin);
}
