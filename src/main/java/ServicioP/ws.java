/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioP;

import ugt.ejb.*;
import ugt.entidades.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Ruben
 */
@Stateless
@Path("")
public class ws {

    @EJB
    private TbconductoresFacadeLocal conductorlocal;
    @EJB
    private TbvehiculosconductoresFacadeLocal vehiculoconductorlocal;
    @EJB
    private TbvehiculosFacadeLocal vehiculolocal;
    @EJB
    private TbusuariosentidadFacadeLocal usuarioentidadlocal;
    @EJB
    private TbrolesopcionesFacadeLocal rolesopcioneslocal;
    @EJB
    private TblicenciasFacadeLocal licenciaslocal;

    //<editor-fold defaultstate="collapsed" desc="Busqueda de marca segun el nombre">
//    @GET
//    @Path("marcanombre/{nombre}")
//    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
//    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
//    public Tbmarcas marcanombre(@PathParam("nombre") String nombre) {
//        Tbmarcas marca = new Tbmarcas();
////        marca = marcalocal.nombremarca(nombre);
////        if (marca.getNombre() == null) {
////            // MENSAJE SIN DATOS
////        }
//        return marca;
//    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Busqueda de conductor por nombre">
    @GET
    @Path("conductornombre/{nombre}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public Tbconductores conductornombre(@PathParam("nombre") String nombre) {
        Tbconductores conductor = new Tbconductores();
//        conductor = conductorlocal.nombreconductor(nombre);
        return conductor;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lista de conductor disponibles">
    @GET
    @Path("conductoresdisponibles")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbconductores> conductordisponible() {
        List<Tbconductores> conductor = new ArrayList<>();
        conductor = conductorlocal.disponibles();
        return conductor;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lista de conductor bloqueados">
    @GET
    @Path("conductoresbloqueados")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbconductores> conductoresbloqueados() {
        List<Tbconductores> conductor = new ArrayList<>();
        conductor = conductorlocal.bloqueados();
        return conductor;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Bloquea Conductor y cambia a vehiculo disponible, retorna lista conductores disponibles">
    @PUT
    @Path("bloquearconductor/{cedula}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public List<Tbconductores> bloquearconductor(@PathParam("cedula") String cedula, Tbconductores tbconductor) {
        List<Tbconductores> conductor = new ArrayList<>();
        if (conductorlocal.modconductor(tbconductor, cedula) > 0) {
            Tbvehiculosconductores autocond = vehiculoconductorlocal.buscarxcedula(cedula);
            if (autocond.getTbvehiculos() != null) {
                Calendar today = Calendar.getInstance();
                autocond.setFechafin(today.getTime());
                vehiculoconductorlocal.edit(autocond);
                Tbvehiculos vehiculo = autocond.getTbvehiculos();
                vehiculo.setEstado("Disponble");
                vehiculolocal.edit(vehiculo);
            }
            conductor = conductorlocal.disponibles();
        }
        return conductor;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Busqueda de Usuario-entidad-rol por cedula">
    @GET
    @Path("buscarusuarioentidadrol/{cedula}")
    @Produces({"application/json;  charset=utf-8;  charset=utf-8"})
    @Consumes({"application/json;  charset=utf-8;  charset=utf-8"})
    public List<Tbusuariosentidad> buscarusuarioentidadrol(@PathParam("cedula") String cedula) {
        List<Tbusuariosentidad> userentidad = new ArrayList<>();
        userentidad = usuarioentidadlocal.buscarusuarioentidad(cedula);
        return userentidad;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Busqueda de opciones por id Rol">
    @GET
    @Path("buscaropcionesrol/{id}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbopciones> buscaropcionesrol(@PathParam("id") int id) {
        List<Tbopciones> rolesopciones = new ArrayList<>();
        for (Tbrolesopciones rolopcion : rolesopcioneslocal.findAll()) {
            if (rolopcion.getIdrol().getIdrol().equals(id)) {
                rolesopciones.add(rolopcion.getIdopcion());
            }
        }
        return rolesopciones;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Busqueda de licencia por cedula">
    @GET
    @Path("buscarlicenciacedula/{cedula}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tblicencias> buscaropcionesrol(@PathParam("cedula") String cedula) {
        List<Tblicencias> result = new ArrayList<>();
        result = licenciaslocal.buascarLicencia(cedula);
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lista de conductor filtrado por estado">
    @GET
    @Path("conductoresestado/{estado}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbconductores> conductoresestado(@PathParam("estado") String estado) {
        List<Tbconductores> result = new ArrayList<>();
        for (Tbconductores conductor : conductorlocal.findAll()) {
            if (conductor.getEstado().equals(estado)) {
                result.add(conductor);
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lista de vehiculos filtrado por estado">
    @GET
    @Path("vehiculosestado/{estado}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbvehiculos> vehiculosestado(@PathParam("estado") String estado) {
        List<Tbvehiculos> result = new ArrayList<>();
        for (Tbvehiculos vehiculo : vehiculolocal.findAll()) {
            if (vehiculo.getEstado().equals(estado)) {
                result.add(vehiculo);
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Bloquea Conductor y cambia a vehiculo disponible, retorna lista conductores disponibles">
    @PUT
    @Path("bloquearvehiculo/{cedula}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public List<Tbvehiculos> bloquearVehiculo(@PathParam("cedula") String placa, Tbconductores vehiculo) {
        List<Tbvehiculos> vehiculos = new ArrayList<>();
        if (conductorlocal.modconductor(vehiculo, placa) > 0) {
            Tbvehiculosconductores autocond = vehiculoconductorlocal.buscarxplaca(placa);
            if (autocond.getTbconductores() != null) {
                Calendar today = Calendar.getInstance();
                autocond.setFechafin(today.getTime());
                vehiculoconductorlocal.edit(autocond);
                Tbconductores conductor = autocond.getTbconductores();
                conductor.setEstado("Disponble");
                conductorlocal.edit(conductor);
            }
            vehiculos = vehiculolocal.disponibles();
        }
        return vehiculos;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Busqueda de Vehiculo Conductor por placa">
    @GET
    @Path("btbvehiculosconductores/{tipopk}/{pktb}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public List<Tbvehiculosconductores> buscarvehiculoconductortipo(@PathParam("tipopk") String tipo, @PathParam("pktb") String pktb) {
        List<Tbvehiculosconductores> vehiculosconductores = new ArrayList<>();
        for (Tbvehiculosconductores vehiCond : vehiculoconductorlocal.findAll()) {
            if (tipo.equals("placa")) {
                if (vehiCond.getTbvehiculosconductoresPK().getMatricula().equals(pktb) && vehiCond.getFechafin() == null) {
                    vehiculosconductores.add(vehiCond);
                }
            } else if (tipo.equals("cedula")) {
                if (vehiCond.getTbvehiculosconductoresPK().getCedula().equals(pktb) && vehiCond.getFechafin() == null) {
                    vehiculosconductores.add(vehiCond);
                }
            }
        }
        return vehiculosconductores;
    }
    //</editor-fold>
}
