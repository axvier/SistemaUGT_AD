/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServicioP;

import ugt.ejb.*;
import ugt.entidades.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import ugt.solicitudes.Solicitudesfull;
import ugt.solicitudes.SolicitudesfullLista;

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
    @EJB
    private TbvehiculosdependenciasFacadeLocal vehiculosdependenciaslocal;
    @EJB
    private TbsolicitudesFacadeLocal solicitudeslocal;
    @EJB
    private TbseccionsolicitantesFacadeLocal solicitanteslocal;
    @EJB
    private TbseccionmotivoFacadeLocal motivolocal;
    @EJB
    private TbseccionviajesFacadeLocal viajelocal;
    @EJB
    private TbpasajerosFacadeLocal pasajeroslocal;
    @EJB
    private TbviajepasajeroFacadeLocal viajepasajerolocal;

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
            List<Tbvehiculosconductores> listaVehiculosCond = vehiculoconductorlocal.buscarxcedula(cedula);
            for (Tbvehiculosconductores autoCond : listaVehiculosCond) {
                Calendar today = Calendar.getInstance();
                autoCond.setFechafin(today.getTime());
                vehiculoconductorlocal.edit(autoCond);
                Tbvehiculos vehiculo = autoCond.getTbvehiculos();
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

    //<editor-fold defaultstate="collapsed" desc="Busqueda de Vehiculo Conductor por placa o cedula">
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

    //<editor-fold defaultstate="collapsed" desc="Busqueda de vehiculo conductor por id pcompuestos">
    @GET
    @Path("vehiculosconductores/cedula/{cedula}/matricula/{matricula}/fecha/{date}")
    @Produces({"application/json;  charset=utf-8;  charset=utf-8"})
    @Consumes({"application/json;  charset=utf-8;  charset=utf-8"})
    @Transactional
    public Tbvehiculosconductores vehiculoconductormatrixID(@PathParam("cedula") String cedula, @PathParam("matricula") String matricula, @PathParam("date") String fecha) {
        Tbvehiculosconductores result = new Tbvehiculosconductores();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        for (Tbvehiculosconductores search : vehiculoconductorlocal.findAll()) {
            try {
                Date compare = sdf.parse(fecha);
                if (search.getTbvehiculosconductoresPK().getCedula().equals(cedula) && search.getTbvehiculosconductoresPK().getMatricula().equals(matricula) && search.getTbvehiculosconductoresPK().getFechainicio().equals(compare)) {
                    result = search;
                    break;
                }
            } catch (Exception e) {
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lista de vehiculos diferente a un estado">
    @GET
    @Path("vehiculosnoestado/{estado}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbvehiculos> vehiculosnoigualestado(@PathParam("estado") String estado) {
        List<Tbvehiculos> result = new ArrayList<>();
        for (Tbvehiculos vehiculo : vehiculolocal.findAll()) {
            if (!vehiculo.getEstado().equals(estado)) {
                result.add(vehiculo);
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lista de conductores diferente a un estado">
    @GET
    @Path("conductoresnoestado/{estado}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbconductores> conductoresnoigualestado(@PathParam("estado") String estado) {
        List<Tbconductores> result = new ArrayList<>();
        for (Tbconductores conductor : conductorlocal.findAll()) {
            if (!conductor.getEstado().equals(estado)) {
                result.add(conductor);
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Modificar Vehiculo Conductor">
    @PUT
    @Path("vehiculosconductores/{cedula}/{placa}/{fecha}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Consumes({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public Tbvehiculosconductores vehiculoconductormod(@PathParam("cedula") String cedula, @PathParam("placa") String placa, @PathParam("fecha") String fecha, Tbvehiculosconductores objeto) {
        Tbvehiculosconductores result = new Tbvehiculosconductores();
        result = vehiculoconductorlocal.modificar(cedula, placa, fecha, objeto);
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Terminar todas las asinaciones de rol-usuario-entidad con la fecha final">
    @PUT
    @Path("terminarallusuarioentidad/{cedula}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public List<Tbusuariosentidad> terminarUsuarioEntidad(@PathParam("cedula") String cedula) {
        List<Tbusuariosentidad> result = new ArrayList<>();
        for (Tbusuariosentidad userentity : usuarioentidadlocal.buscarusuarioentidad(cedula)) {
            Calendar today = Calendar.getInstance();
            userentity.setFechafin(today.getTime());
            usuarioentidadlocal.edit(userentity);
            result.add(userentity);
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Lista total de Usuario-entidad-rol x cedula">
    @GET
    @Path("totalusuarioentidadrol/{cedula}")
    @Produces({"application/json;  charset=utf-8;  charset=utf-8"})
    @Consumes({"application/json;  charset=utf-8;  charset=utf-8"})
    public List<Tbusuariosentidad> totalusuarioentidadrol(@PathParam("cedula") String cedula) {
        List<Tbusuariosentidad> userentidad = new ArrayList<>();
        userentidad = usuarioentidadlocal.totalusuarioentidad(cedula);
        return userentidad;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="buscar en tbroles opcions con rol y con opcion">
    @GET
    @Path("btbrolesopciones/{idrol}/{idopcion}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public Tbrolesopciones buscartbrolesopciones(@PathParam("idrol") String idrol, @PathParam("idopcion") String idopcion) {
        Tbrolesopciones result = new Tbrolesopciones();
        for (Tbrolesopciones search : rolesopcioneslocal.findAll()) {
            if (search.getIdrol().getIdrol().equals(idrol) && search.getIdopcion().getIdopcion().equals(idopcion)) {
                result = search;
                break;
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="eliminar las opcuiones anexadas a un rol">
    @DELETE
    @Path("deletetbrolesopciones/{idrol}")
    @Transactional
    public String deletetbrolesopciones(@PathParam("idrol") int idrol) {
        String result = "";
        for (Tbrolesopciones search : rolesopcioneslocal.findAll()) {
            if (search.getIdrol().getIdrol().equals(idrol)) {
                try {
                    rolesopcioneslocal.remove(search);
                    result = "OK";
                } catch (Exception e) {
                    System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
                    result = "KO";
                }
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Buscar un vehiculo dependencia con un ids">
    @GET
    @Path("vehiculosdependencias/{iddependencias}/{matricula}/{fechainicio}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public Tbvehiculosdependencias vehiculosdependencias(@PathParam("iddependencias") int iddependencias, @PathParam("matricula") String matricula, @PathParam("fechainicio") String fechainicio) throws ParseException {
        Tbvehiculosdependencias result = new Tbvehiculosdependencias();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date compare = sdf.parse(fechainicio);
        for (Tbvehiculosdependencias vehiculodependencia : vehiculosdependenciaslocal.findAll()) {
            if (vehiculodependencia.getTbvehiculosdependenciasPK().getFechainicio().equals(compare)
                    && vehiculodependencia.getTbvehiculosdependenciasPK().getIddependencia() == iddependencias
                    && vehiculodependencia.getTbvehiculosdependenciasPK().getMatricula().equals(matricula)) {
                result = vehiculodependencia;
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Busqueda de Vehiculo dependencia por placa o identidad">
    @GET
    @Path("btbvehiculosdependencias/{tipo}/{pktb}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public Tbvehiculosdependencias btbvehiculosdependencias(@PathParam("pktb") String pktb, @PathParam("tipo") String tipo) {
        Tbvehiculosdependencias result = new Tbvehiculosdependencias();
        for (Tbvehiculosdependencias vehiCond : vehiculosdependenciaslocal.findAll()) {
            if (tipo.equals("matricula")) {
                if (vehiCond.getTbvehiculosdependenciasPK().getMatricula().equals(pktb) && vehiCond.getFechafin() == null) {
                    result = vehiCond;
                }
            }
            if (tipo.equals("dependencia")) {
                int compare;
                compare = Integer.parseInt(pktb);
                if (vehiCond.getTbvehiculosdependenciasPK().getIddependencia() == compare && vehiCond.getFechafin() == null) {
                    result = vehiCond;
                }
            }
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="busqueda de solicitudes full por cedula solicitante">
    @GET
    @Path("bsolicitudesfullcedula/{cedula}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public SolicitudesfullLista bsolicitudesfullcedula(@PathParam("cedula") String cedula) {
        SolicitudesfullLista res = new SolicitudesfullLista();
        List<Solicitudesfull> result1 = new ArrayList<>();
        for (Tbsolicitudes solcitud : solicitudeslocal.buscarallxcedula(cedula)) {
            Solicitudesfull full = new Solicitudesfull();
            full.setSolicitud(solcitud);// se ingresan las colecciones disponibles en la tabla solcitudes: solicitud, solicitante, motivo, viaje
            if (solcitud.getTbseccionmotivoCollection().size() > 0) {//conseguir motivo
                full.setMotivo((Tbseccionmotivo) solcitud.getTbseccionmotivoCollection().toArray()[0]);
            } else {
                Tbseccionmotivo motivoAux = motivolocal.buscarXIDsolicitud(solcitud.getNumero());
                if (motivoAux.getIdmotivo() != null) {
                    full.setMotivo(motivoAux);
                }
            }
            if (solcitud.getTbseccionsolicitantesCollection().size() > 0) {// congeguir solicitante
                full.setSolicitante((Tbseccionsolicitantes) solcitud.getTbseccionsolicitantesCollection().toArray()[0]);
            } else {
                Tbseccionsolicitantes solicitanteAux = new Tbseccionsolicitantes();
                solicitanteAux = solicitanteslocal.buscarxidsolicitud(solcitud.getNumero().toString());
                if (solicitanteAux.getIdsolicitante() != null) {
                    full.setSolicitante(solicitanteAux);
                }
            }
            if (solcitud.getTbseccionviajesCollection().size() > 0) {//conseguir viaje
                full.setViaje((Tbseccionviajes) solcitud.getTbseccionviajesCollection().toArray()[0]);
            } else {
                Tbseccionviajes viajeAux = new Tbseccionviajes();
                viajeAux = viajelocal.buscaridS(solcitud.getNumero().toString()); // buscar seccion viaje con id de solicitud
                if (viajeAux.getIdviaje() != null) {
                    full.setViaje(viajeAux);//set seccion viaje en solicitud completa
                }
            }
            if (full.getViaje() != null) {
                if (full.getViaje().getTbviajepasajeroCollection().size() > 0) {//conseguir pasajeros
                    List<Tbviajepasajero> viajepasajeroList = new ArrayList<>();
                    for (Tbviajepasajero aux : full.getViaje().getTbviajepasajeroCollection()) {
                        viajepasajeroList.add(aux);
                    }
                    if (viajepasajeroList.size() > 0) {
                        full.setPasajeros(viajepasajeroList);
                    }
                } else {
                    List<Tbviajepasajero> viajepasajeroList = viajepasajerolocal.buscarXIDviaje(full.getViaje().getIdviaje()); // lista de pasajeros de la tabla tbviajepasajero segun idviaje
                    if (viajepasajeroList.size() > 0) {
                        full.setPasajeros(viajepasajeroList);
                    }
                }
            }
            result1.add(full);
        }
        if (result1.size() > 0) {
            res.setLista(result1);
        }
        return res;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="busqueda de solicitudes full por id">
    @GET
    @Path("bsolicitudesfullid/{id}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public Solicitudesfull bsolicitudesfullid(@PathParam("id") Integer numero) {
        Solicitudesfull full = new Solicitudesfull();
        Tbsolicitudes solicitud;
        solicitud = solicitudeslocal.find(numero);
        if (solicitud != null) {
            full.setSolicitud(solicitud);// se ingresan las colecciones disponibles en la tabla solcitudes: solicitud, solicitante, motivo, viaje
            if (solicitud.getTbseccionmotivoCollection().size() > 0) {//conseguir motivo
                full.setMotivo((Tbseccionmotivo) solicitud.getTbseccionmotivoCollection().toArray()[0]);
            } else {
                Tbseccionmotivo motivoAux = motivolocal.buscarXIDsolicitud(solicitud.getNumero());
                if (motivoAux.getIdmotivo() != null) {
                    full.setMotivo(motivoAux);
                }
            }
            if (solicitud.getTbseccionsolicitantesCollection().size() > 0) {//conseguir solicitante
                full.setSolicitante((Tbseccionsolicitantes) solicitud.getTbseccionsolicitantesCollection().toArray()[0]);
            } else {
                Tbseccionsolicitantes solicitanteAux = new Tbseccionsolicitantes();
                solicitanteAux = solicitanteslocal.buscarxidsolicitud(solicitud.getNumero().toString());
                if (solicitanteAux.getIdsolicitante() != null) {
                    full.setSolicitante(solicitanteAux);
                }
            }
            if (solicitud.getTbseccionviajesCollection().size() > 0) {//conseguir viaje
                full.setViaje((Tbseccionviajes) solicitud.getTbseccionviajesCollection().toArray()[0]);
            } else {
                Tbseccionviajes viajeAux = new Tbseccionviajes();
                viajeAux = viajelocal.buscaridS(solicitud.getNumero().toString()); // buscar seccion viaje con id de solicitud
                if (viajeAux.getIdviaje() != null) {
                    full.setViaje(viajeAux);//set seccion viaje en solicitud completa
                }
            }
            if (full.getViaje() != null) {
                if (full.getViaje().getTbviajepasajeroCollection().size() > 0) {//conseguir pasajeros
                    List<Tbviajepasajero> viajepasajeroList = new ArrayList<>();
                    for (Tbviajepasajero aux : full.getViaje().getTbviajepasajeroCollection()) {
                        viajepasajeroList.add(aux);
                    }
                    if (viajepasajeroList.size() > 0) {
                        full.setPasajeros(viajepasajeroList);
                    }
                } else {
                    List<Tbviajepasajero> viajepasajeroList = viajepasajerolocal.buscarXIDviaje(full.getViaje().getIdviaje()); // lista de pasajeros de la tabla tbviajepasajero segun idviaje
                    if (viajepasajeroList.size() > 0) {
                        full.setPasajeros(viajepasajeroList);
                    }
                }
            }
        }
        return full;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Insertar las demas secciones de la solicitud">
    @POST
    @Path("insertsolicitudcomponentes")
    @Produces({"application/json; charset=utf-8"})
    @Consumes({"application/json; charset=ISO-8859-1;  charset=utf-8"})
    @Transactional
    public Solicitudesfull insertsolicitudcomponentes(Solicitudesfull solicitudfull) {
        Solicitudesfull result = new Solicitudesfull();
        try {
            //inicio insertar solcitante
            if (solicitudfull.getSolicitante() != null) {
                //insertar solicitud en la clase solicitante
//            Tbseccionsolicitantes solicitante = solicitud.getSolicitante();
                solicitudfull.getSolicitante().setSolicitud(solicitudfull.getSolicitud());
                //insertar solicitante por medio del EJB
                solicitanteslocal.create(solicitudfull.getSolicitante());
            }
            //fin inserrar solicitante
//        inicio insertar motivo
            if (solicitudfull.getMotivo() != null) {
                //insertar soliciutd en clase motivo
                solicitudfull.getMotivo().setSolicitud(solicitudfull.getSolicitud());
                //insertar motivo con EJB
                motivolocal.create(solicitudfull.getMotivo());
            }
//        fin insertar motivo
//        inicio insertar viaje
            if (solicitudfull.getViaje() != null) {
                //insertar soliciutd en clase viaje
//                Tbseccionviajes viajeAux = solicitudfull.getViaje();
//                viajeAux.setSolicitud(solicitudfull.getSolicitud());
                solicitudfull.getViaje().setSolicitud(solicitudfull.getSolicitud());
                //insertar viaje con EJB
                viajelocal.create(solicitudfull.getViaje());
                //set datos viaje con id de solicitud
//                solicitudfull.setViaje(viajelocal.buscaridS(solicitudfull.getSolicitud().getNumero().toString()));
            }
//        fin insertar viaje
//          inicio insertar Pasajeros
            if (solicitudfull.getPasajeros().size() > 0) {
                for (Tbviajepasajero viajePasajero : solicitudfull.getPasajeros()) {
                    if (viajePasajero.getTbpasajeros() != null) {
                        Tbpasajeros pasajeroAux = viajePasajero.getTbpasajeros();
                        Tbpasajeros existe = pasajeroslocal.find(pasajeroAux.getCedula()); //ver si el pasajero existe
                        if (existe == null) {
                            //insertar pasajeros con EJB, una vez insertado
                            pasajeroslocal.create(pasajeroAux);
                        }
                    }
                }
            }
//          fin insertar Pasajeros
//            inicio insertar viaje pasajeros
            if (solicitudfull.getViaje().getIdviaje() != null) {
                if (solicitudfull.getViaje().getIdviaje() != 0) { // ver si se inserto en la persistencia
                    for (Tbviajepasajero viajePasajeroAux : solicitudfull.getPasajeros()) { // listar a los pasajeros uno a uno
                        viajePasajeroAux.setTbseccionviajes(solicitudfull.getViaje());// insertar los datos del viaje en los pasajeros
                        try {
                            viajepasajerolocal.create(viajePasajeroAux); // crear nuevo viaje pasajero
                        } catch (Exception e) {
                            Logger.getAnonymousLogger().log(Level.SEVERE, "problemas en insertar viaje pasajero ", e.getClass().getName() + "****" + e.getMessage());
                            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
                        }
                    }
                }
            }
            result = solicitudfull;
        } catch (Exception e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "problemas en insrtar los componentes del PDF ", e.getClass().getName() + "****" + e.getMessage());
            System.err.println("ERROR: " + e.getClass().getName() + "***" + e.getMessage());
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Buscar termino en id cedula dentro de tbpasajeros">
    @GET
    @Path("termpasajero/{term}")
    @Produces({"application/json;  charset=ISO-8859-1;  charset=utf-8"})
    public List<Tbpasajeros> termpasajero(@PathParam("term") String term) {
        List<Tbpasajeros> result = new ArrayList<>();
        result = pasajeroslocal.buscarXtermpasajero(term);
        return result;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Busqueda de Usuario-entidad-rol por cedula y rol">
    @GET
    @Path("bentidadusuario/{cedula}/{rol}")
    @Produces({"application/json;  charset=utf-8;  charset=utf-8"})
    public Tbusuariosentidad bentidadusuario(@PathParam("cedula") String cedula,@PathParam("rol") String idrol) {
        Tbusuariosentidad userentidad = new Tbusuariosentidad();
        userentidad = usuarioentidadlocal.bentidadusuario(cedula,idrol);
        return userentidad;
    }
    //</editor-fold>
}
