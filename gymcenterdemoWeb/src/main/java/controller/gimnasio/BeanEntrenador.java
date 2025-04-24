package controller.gimnasio;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.core.entities.Cliente;
import model.core.entities.Detfichaantropometrica;
import model.core.entities.Fichaantropometrica;
import model.gimnasio.managers.ManagerGimnasio;

@Named
@SessionScoped
public class BeanEntrenador implements Serializable {

	@EJB
	private ManagerGimnasio mGimnasio;
	private Fichaantropometrica nuevaFicha;
	private Detfichaantropometrica nuevoDetFicha;
	private List<Cliente> listaCliente;
	private List<Fichaantropometrica> listaFicha;
	private List<Detfichaantropometrica> listaDetFicha;
	private List<Detfichaantropometrica> listaDetFichaByFicha;
	
	private int IDCliente;
	
	
	public BeanEntrenador() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@PostConstruct
	public void inicializar() {
		nuevaFicha = new Fichaantropometrica();
		nuevoDetFicha = new Detfichaantropometrica();
		listaCliente = mGimnasio.findAllClientes();
		listaFicha = mGimnasio.findAllFichaantropometrica();
		listaDetFicha = mGimnasio.findAllDetfichaantropometrica();
	}
	
	public void insertarFicha() throws Exception {
		nuevaFicha.setCliente(mGimnasio.findClienteByID(IDCliente));
		mGimnasio.createFicha(nuevaFicha);
		nuevaFicha = new Fichaantropometrica();
	}
	
	public void insertarDetFicha(Fichaantropometrica Ficha) throws Exception {
		nuevoDetFicha.setFichaantropometrica(Ficha);
		nuevoDetFicha.setDetfFechadet(new Date());
		mGimnasio.createDetFicha(nuevoDetFicha);
		nuevoDetFicha = new Detfichaantropometrica();
	}
	
	public String selecionarFichaByCliente(Fichaantropometrica Ficha) throws Exception{
		for (int i = 0; i < listaDetFicha.size(); i++) {
			if (listaDetFicha.get(i).getFichaantropometrica() == Ficha) {
				listaDetFichaByFicha.add(listaDetFicha.get(i));
			}
		}
		return "detalleFicha";
	}

	public Fichaantropometrica getNuevaFicha() {
		return nuevaFicha;
	}

	public void setNuevaFicha(Fichaantropometrica nuevaFicha) {
		this.nuevaFicha = nuevaFicha;
	}

	public Detfichaantropometrica getNuevoDetFicha() {
		return nuevoDetFicha;
	}

	public void setNuevoDetFicha(Detfichaantropometrica nuevoDetFicha) {
		this.nuevoDetFicha = nuevoDetFicha;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public int getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}



	public List<Fichaantropometrica> getListaFicha() {
		return listaFicha;
	}



	public void setListaFicha(List<Fichaantropometrica> listaFicha) {
		this.listaFicha = listaFicha;
	}



	public List<Detfichaantropometrica> getListaDetFicha() {
		return listaDetFicha;
	}



	public void setListaDetFicha(List<Detfichaantropometrica> listaDetFicha) {
		this.listaDetFicha = listaDetFicha;
	}



	public List<Detfichaantropometrica> getListaDetFichaByFicha() {
		return listaDetFichaByFicha;
	}



	public void setListaDetFichaByFicha(List<Detfichaantropometrica> listaDetFichaByFicha) {
		this.listaDetFichaByFicha = listaDetFichaByFicha;
	}

	
	

}
