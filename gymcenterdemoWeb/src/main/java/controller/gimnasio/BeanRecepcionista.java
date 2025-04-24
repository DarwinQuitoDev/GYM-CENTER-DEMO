package controller.gimnasio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.core.entities.Cliente;
import model.core.entities.ComprobanteDePago;
import model.core.entities.Membresia;
import model.core.entities.Promocione;
import model.core.entities.Servicio;
import model.gimnasio.managers.ManagerGimnasio;
import model.core.utils.*;

@Named
@SessionScoped
public class BeanRecepcionista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ManagerGimnasio mGimnasio;
	
	private List<Cliente> listaCliente;
	private List<Servicio> listaServicio;
	private List<Membresia> listaMembresia;
	private List<Promocione> listaPromociones;
	private Cliente nuevoCliente;
	private Cliente editarCliente;
	private Membresia nuevaMembresia;
	private Promocione nuevaPromocion;
	private ComprobanteDePago nuevoComprobante;
	
	private int IDCliente;
	private int IDServicio;
	private int IDPromocion;
	private String Descripcion;
	private Date FechaInicio;
	
	private ModelUtil mUtil;
	
	
	public BeanRecepcionista() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaCliente = mGimnasio.findAllClientes();
		listaServicio = mGimnasio.findAllServicio();
		listaMembresia = mGimnasio.findAllMmebresia();
		listaPromociones = mGimnasio.findAllPromocione();
		nuevoCliente = new Cliente();
		nuevaMembresia = new Membresia();
		nuevaPromocion = new Promocione();
		nuevoComprobante = new ComprobanteDePago();
		
		mUtil = new ModelUtil();
		FechaInicio = new Date();
	}
	
	public void insertarCliente() throws Exception {
		mGimnasio.createCliente(nuevoCliente);
		listaCliente = mGimnasio.findAllClientes();
		nuevoCliente = new Cliente();
	}
	
	public void actualizarCliente() throws Exception {
		mGimnasio.actualizarCliente(editarCliente);
		listaCliente = mGimnasio.findAllClientes();
		editarCliente = new Cliente();
	}
	
	public void seleccionarCliente(Cliente cliente) {
		editarCliente=cliente;
	}
	
	public void insertarMembresia() throws Exception{
		double totalComprobante;
		double Precio;
		double Promocion;
		
		nuevaMembresia.setCliente(mGimnasio.findClienteByID(IDCliente));
		nuevaMembresia.setServicio(mGimnasio.findServicioByID(IDServicio));
		nuevaMembresia.setMemFechaIni(FechaInicio);
		nuevaMembresia.setMemFechaFin(ModelUtil.addDays(FechaInicio, (int)(nuevaMembresia.getServicio().getSerDuracion())));
		mGimnasio.createMembresia(nuevaMembresia);
		nuevaPromocion = mGimnasio.findPromocionByID(IDPromocion);
		
		nuevoComprobante.setMembresia(nuevaMembresia);
		nuevoComprobante.setPromocione(nuevaPromocion);
		nuevoComprobante.setComFecha(new Date());
		nuevoComprobante.setComDescripcion(Descripcion);
		Precio = nuevaMembresia.getServicio().getSerPrecio().doubleValue();
		Promocion = nuevaPromocion.getPromDescuento().doubleValue();
		totalComprobante = (Precio-(Precio*Promocion/100));
		nuevoComprobante.setComTotal(new BigDecimal(totalComprobante));
		mGimnasio.createComprobante(nuevoComprobante);
		
		listaMembresia = mGimnasio.findAllMmebresia();
		nuevaMembresia = new Membresia();
		IDCliente = 0;
		IDServicio = 0;
		IDPromocion = 0;
		Descripcion = "";
		totalComprobante = 0;
		Precio = 0;
		Promocion = 0;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Cliente getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(Cliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

	public List<Servicio> getListaServicio() {
		return listaServicio;
	}

	public void setListaServicio(List<Servicio> listaServicio) {
		this.listaServicio = listaServicio;
	}
	
	public List<Membresia> getListaMembresia() {
		return listaMembresia;
	}

	public void setListaMembresia(List<Membresia> listaMembresia) {
		this.listaMembresia = listaMembresia;
	}

	public Membresia getNuevaMembresia() {
		return nuevaMembresia;
	}

	public void setNuevaMembresia(Membresia nuevaMembresia) {
		this.nuevaMembresia = nuevaMembresia;
	}

	public ModelUtil getmUtil() {
		return mUtil;
	}

	public void setmUtil(ModelUtil mUtil) {
		this.mUtil = mUtil;
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}

	public int getIDServicio() {
		return IDServicio;
	}

	public void setIDServicio(int iDServicio) {
		IDServicio = iDServicio;
	}

	public Date getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public Cliente getEditarCliente() {
		return editarCliente;
	}

	public void setEditarCliente(Cliente editarCliente) {
		this.editarCliente = editarCliente;
	}

	public List<Promocione> getListaPromociones() {
		return listaPromociones;
	}

	public void setListaPromociones(List<Promocione> listaPromociones) {
		this.listaPromociones = listaPromociones;
	}

	public Promocione getNuevaPromocion() {
		return nuevaPromocion;
	}

	public void setNuevaPromocion(Promocione nuevaPromocion) {
		this.nuevaPromocion = nuevaPromocion;
	}

	public ComprobanteDePago getNuevoComprobante() {
		return nuevoComprobante;
	}

	public void setNuevoComprobante(ComprobanteDePago nuevoComprobante) {
		this.nuevoComprobante = nuevoComprobante;
	}

	public int getIDPromocion() {
		return IDPromocion;
	}

	public void setIDPromocion(int iDPromocion) {
		IDPromocion = iDPromocion;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	

}
