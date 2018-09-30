/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbordenesmovilizaciones;

/**
 *
 * @author Usuario
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
    
}
