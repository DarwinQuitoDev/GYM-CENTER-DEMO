package model.gimnasio.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.core.entities.Bitacora;
import model.core.entities.Cliente;
import model.core.entities.ComprobanteDePago;
import model.core.entities.Detbitacora;
import model.core.entities.Detfichaantropometrica;
import model.core.entities.Fichaantropometrica;
import model.core.entities.InventarioPk;
import model.core.entities.Membresia;
import model.core.entities.Promocione;
import model.core.entities.Servicio;
import model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerGimnasio
 */
@Stateless
@LocalBean
public class ManagerGimnasio {

	@EJB
	private ManagerDAO mDAO;
	
    /**
     * Default constructor. 
     */
    public ManagerGimnasio() {
    }
    
    public List<Cliente> findAllClientes(){
    	return mDAO.findAll(Cliente.class);
    }
    
    public Cliente findClienteByID(int ID) throws Exception {
    	return (Cliente) mDAO.findById(Cliente.class, ID);
    }
    
    public void createCliente(Cliente Cli) throws Exception {
    	mDAO.insertar(Cli);
    }
    
    public List<Servicio> findAllServicio(){
    	return mDAO.findAll(Servicio.class);
    }
    
    public void actualizarCliente(Cliente Cli) throws Exception {
    	mDAO.actualizar(Cli);
    }
    
    public Servicio findServicioByID(int ID) throws Exception{
    	return (Servicio) mDAO.findById(Servicio.class, ID);
    }
    
    public void createServicio(Servicio Ser) throws Exception {
    	mDAO.insertar(Ser);
    }
    
    public void actualizarServicio(Servicio Ser) throws Exception {
    	mDAO.actualizar(Ser);
    }
    
    public void activarDesactivarServicio(int idServicio) throws Exception {
    	Servicio servicio=(Servicio) mDAO.findById(Servicio.class, idServicio);
    	servicio.setSerEstado(!servicio.getSerEstado());
    	System.out.println("activar/desactivar "+servicio.getSerEstado());
    	mDAO.actualizar(servicio);
    }
    
    public List<Promocione> findAllPromocione(){
    	return mDAO.findAll(Promocione.class);
    }
    
    public Promocione findPromocionByID(int ID) throws Exception{
    	return (Promocione) mDAO.findById(Promocione.class, ID);
    }
    
    public void createPromociones(Promocione Prom) throws Exception {
    	mDAO.insertar(Prom);
    }
    
    public void actualizarPromocion(Promocione Prom) throws Exception {
    	mDAO.actualizar(Prom);
    }
    
    public void activarDesactivarPromocion(int idPromocion) throws Exception {
    	Promocione promocion=(Promocione) mDAO.findById(Promocione.class, idPromocion);
    	promocion.setPromEstado(!promocion.getPromEstado());
    	System.out.println("activar/desactivar "+promocion.getPromEstado());
    	mDAO.actualizar(promocion);
    }
    
    public List<ComprobanteDePago> findAllComprobante(){
    	return mDAO.findAll(ComprobanteDePago.class);
    }
    
    public void createComprobante(ComprobanteDePago Com) throws Exception {
    	mDAO.insertar(Com);
    }
    
    public List<Membresia> findAllMmebresia(){
    	return mDAO.findAll(Membresia.class);
    }
    
    public void createMembresia( Membresia mem) throws Exception{
    	mDAO.insertar(mem);
    }
    
    public List<Fichaantropometrica> findAllFichaantropometrica(){
    	return mDAO.findAll(Fichaantropometrica.class);
    }
    
    public void createFicha(Fichaantropometrica Fich) throws Exception {
    	mDAO.insertar(Fich);
    }
    
    public List<Detfichaantropometrica> findAllDetfichaantropometrica(){
    	return mDAO.findAll(Detfichaantropometrica.class);
    }
    
    public void createDetFicha(Detfichaantropometrica Fich) throws Exception {
    	mDAO.insertar(Fich);
    }
    
    
    public List<Bitacora> findAllBitacora(){
    	return mDAO.findAll(Bitacora.class);
    }
    
    public List<Detbitacora> findAllDetbitacora(){
    	return mDAO.findAll(Detbitacora.class);
    }

    public List<InventarioPk> findAllInventarioPk(){
    	return mDAO.findAll(InventarioPk.class);
    }
    
    public void createInventario(InventarioPk Inv) throws Exception {
    	mDAO.insertar(Inv);
    }
    
    public void actualizarInventario(InventarioPk Inv) throws Exception {
    	mDAO.actualizar(Inv);
    }
    
    public void activarDesactivarArticulo(int idArticulo) throws Exception {
    	InventarioPk articulo=(InventarioPk) mDAO.findById(InventarioPk.class, idArticulo);
    	articulo.setInvEstado(!articulo.getInvEstado());
    	System.out.println("activar/desactivar "+articulo.getInvEstado());
    	mDAO.actualizar(articulo);
    }
    
}
