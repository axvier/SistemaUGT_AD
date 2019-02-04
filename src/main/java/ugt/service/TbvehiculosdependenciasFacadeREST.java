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
import javax.transaction.Transactional;
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
import ugt.entidades.Tbvehiculosdependencias;
import ugt.entidades.TbvehiculosdependenciasPK;

/**
 *
 * @author Xavy PC
 */
@Stateless
@Path("tbvehiculosdependencias")
public class TbvehiculosdependenciasFacadeREST extends AbstractFacade<Tbvehiculosdependencias> {

    @PersistenceContext(unitName = "Pu_ugt")
    private EntityManager em;

    private TbvehiculosdependenciasPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;iddependencia=iddependenciaValue;matricula=matriculaValue;fechainicio=fechainicioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        ugt.entidades.TbvehiculosdependenciasPK key = new ugt.entidades.TbvehiculosdependenciasPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> iddependencia = map.get("iddependencia");
        if (iddependencia != null && !iddependencia.isEmpty()) {
            key.setIddependencia(new java.lang.Integer(iddependencia.get(0)));
        }
        java.util.List<String> matricula = map.get("matricula");
        if (matricula != null && !matricula.isEmpty()) {
            key.setMatricula(matricula.get(0));
        }
        java.util.List<String> fechainicio = map.get("fechainicio");
        if (fechainicio != null && !fechainicio.isEmpty()) {
            key.setFechainicio(new java.util.Date(fechainicio.get(0)));
        }
        return key;
    }

    public TbvehiculosdependenciasFacadeREST() {
        super(Tbvehiculosdependencias.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbvehiculosdependencias ingresar(Tbvehiculosdependencias entity) {
        Tbvehiculosdependencias obj = new Tbvehiculosdependencias();
        super.create(entity);
        em.flush();
        obj = entity;
        return obj;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Transactional
    public Tbvehiculosdependencias modificar(@PathParam("id") PathSegment id, Tbvehiculosdependencias entity) {
        Tbvehiculosdependencias obj = new Tbvehiculosdependencias();
        super.edit(entity);
        em.flush();
        obj = entity;
        return obj;
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        ugt.entidades.TbvehiculosdependenciasPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Tbvehiculosdependencias find(@PathParam("id") PathSegment id) {
        ugt.entidades.TbvehiculosdependenciasPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbvehiculosdependencias> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Tbvehiculosdependencias> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
