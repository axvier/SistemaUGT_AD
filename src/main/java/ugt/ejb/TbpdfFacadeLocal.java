/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.ejb;

import java.util.List;
import javax.ejb.Local;
import ugt.entidades.Tbpdf;

/**
 *
 * @author Xavy PC
 */
@Local
public interface TbpdfFacadeLocal {

    void create(Tbpdf tbpdf);

    void edit(Tbpdf tbpdf);

    void remove(Tbpdf tbpdf);

    Tbpdf find(Object id);

    List<Tbpdf> findAll();

    List<Tbpdf> findRange(int[] range);

    int count();
    
}
