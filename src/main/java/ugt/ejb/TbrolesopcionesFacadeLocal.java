/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbrolesopciones;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbrolesopcionesFacadeLocal {

    void create(Tbrolesopciones tbrolesopciones);

    void edit(Tbrolesopciones tbrolesopciones);

    void remove(Tbrolesopciones tbrolesopciones);

    Tbrolesopciones find(Object id);

    List<Tbrolesopciones> findAll();

    List<Tbrolesopciones> findRange(int[] range);

    int count();
    
}
