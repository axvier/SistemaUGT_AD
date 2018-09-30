/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ugt.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import ugt.entidades.Tbvehiculosconductores;
import ugt.entidades.TbvehiculosconductoresPK;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("tbvehiculosconductores")
public class TbvehiculosconductoresFacadeREST extends AbstractFacade<Tbvehiculosconductores> {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    private TbvehiculosconductoresPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;matricula=matriculaValue;cedula=cedulaValue;fechainicio=fechainicioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ugt.entidades.TbvehiculosconductoresPK key = new ugt.entidades.TbvehiculosconductoresPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> matricula = map.get("matricula");
        if (matricula != null && !matricula.isEmpty()) {
            key.setMatricula(matricula.get(0));
        }
        java.util.List<String> cedula = map.get("cedula");
        if (cedula != null && !cedula.isEmpty()) {
            key.setCedula(cedula.get(0));
        }
        java.util.List<String> fechainicio = map.get("fechainicio");
        if (fechainicio != null && !fechainicio.isEmpty()) {
            key.setFechainicio(new java.util.Date(fechainicio.get(0)));
        }
        return key;
    }

    public TbvehiculosconductoresFacadeREST() {
        super(Tbvehiculosconductores.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Tbvehiculosconductores entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Tbvehiculosconductores entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ugt.entidades.TbvehiculosconductoresPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tbvehiculosconductores find(@PathParam("id") PathSegment id) {
        ugt.entidades.TbvehiculosconductoresPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbvehiculosconductores> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbvehiculosconductores> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
