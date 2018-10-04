/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Usuario
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ServicioP.ws.class);
        resources.add(ugt.service.TbcomisionesFacadeREST.class);
        resources.add(ugt.service.TbconductoresFacadeREST.class);
        resources.add(ugt.service.TbdependenciasFacadeREST.class);
        resources.add(ugt.service.TbdisponibilidadvcFacadeREST.class);
        resources.add(ugt.service.TbentidadFacadeREST.class);
        resources.add(ugt.service.TbgrupovehiculosFacadeREST.class);
        resources.add(ugt.service.TblicenciasFacadeREST.class);
        resources.add(ugt.service.TbopcionesFacadeREST.class);
        resources.add(ugt.service.TbordenesmovilizacionesFacadeREST.class);
        resources.add(ugt.service.TbpasajerosFacadeREST.class);
        resources.add(ugt.service.TbpdfFacadeREST.class);
        resources.add(ugt.service.TbrevisionesmecanicasFacadeREST.class);
        resources.add(ugt.service.TbrolesFacadeREST.class);
        resources.add(ugt.service.TbrolesopcionesFacadeREST.class);
        resources.add(ugt.service.TbseccionmotivoFacadeREST.class);
        resources.add(ugt.service.TbseccionsolicitantesFacadeREST.class);
        resources.add(ugt.service.TbseccionviajesFacadeREST.class);
        resources.add(ugt.service.TbsolicitudesFacadeREST.class);
        resources.add(ugt.service.TbtipoentidadFacadeREST.class);
        resources.add(ugt.service.TbusuariosFacadeREST.class);
        resources.add(ugt.service.TbusuariosentidadFacadeREST.class);
        resources.add(ugt.service.TbvehiculosFacadeREST.class);
        resources.add(ugt.service.TbvehiculosconductoresFacadeREST.class);
        resources.add(ugt.service.TbvehiculosdependenciasFacadeREST.class);
        
    }
    
}
