package controller.gimnasio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.*;

import controller.JSFUtil;
import model.core.entities.InventarioPk;
import model.core.entities.Promocione;
import model.core.entities.Servicio;
import model.gimnasio.managers.ManagerGimnasio;

@Named
@SessionScoped
public class BeanGerente implements Serializable {

	@EJB
	private ManagerGimnasio mGimnasio;

	private List<InventarioPk> listaInventario;
	private List<Servicio> listaServicio;
	private List<Promocione> listaPromociones;
	private InventarioPk nuevoInventario;
	private InventarioPk editarArticulo;
	private Servicio nuevoServicio;
	private Servicio editarServicio;
	private Promocione nuevoPromocion;
	private Promocione editarPromocion;

	private PieChartModel pieModel;

	public BeanGerente() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void inicializar() {
		listaInventario = mGimnasio.findAllInventarioPk();
		listaServicio = mGimnasio.findAllServicio();
		listaPromociones = mGimnasio.findAllPromocione();
		nuevoInventario = new InventarioPk();
		editarArticulo = new InventarioPk();
		nuevoServicio = new Servicio();
		nuevoPromocion = new Promocione();
		editarPromocion = new Promocione();
		editarServicio = new Servicio();

		pieModel = createPieModel();
	}

	public void insertarInventario() throws Exception {
		mGimnasio.createInventario(nuevoInventario);
		listaInventario = mGimnasio.findAllInventarioPk();
		nuevoInventario = new InventarioPk();
	}

	public void seleccionarInventario(InventarioPk Inv) {
		editarArticulo = Inv;
	}

	public void actualizarInventario() throws Exception {
		mGimnasio.actualizarInventario(editarArticulo);
		listaInventario = mGimnasio.findAllInventarioPk();
		editarArticulo = new InventarioPk();
	}

	public void actionListenerActivarDesactivarArticulo(int idArticulo) throws Exception {
		mGimnasio.activarDesactivarArticulo(idArticulo);
		listaInventario = mGimnasio.findAllInventarioPk();
		JSFUtil.crearMensajeINFO("Articulo activado/desactivado");
	}

	public void insertarServicio() throws Exception {
		mGimnasio.createServicio(nuevoServicio);
		listaServicio = mGimnasio.findAllServicio();
		nuevoServicio = new Servicio();
	}

	public void seleccionarServicio(Servicio Ser) {
		editarServicio = Ser;
	}

	public void actualizarServicio() throws Exception {
		mGimnasio.actualizarServicio(editarServicio);
		listaServicio = mGimnasio.findAllServicio();
		editarServicio = new Servicio();
	}

	public void actionListenerActivarDesactivarServicio(int idServicio) {
		try {
			mGimnasio.activarDesactivarServicio(idServicio);
			listaServicio = mGimnasio.findAllServicio();
			JSFUtil.crearMensajeINFO("Articulo activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public void insertarPromocion() throws Exception {
		mGimnasio.createPromociones(nuevoPromocion);
		listaPromociones = mGimnasio.findAllPromocione();
		nuevoPromocion = new Promocione();
	}

	public void seleccionarPromocion(Promocione prom) {
		editarPromocion = prom;
	}

	public void actualizarPromocion() throws Exception {
		mGimnasio.actualizarPromocion(editarPromocion);
		listaPromociones = mGimnasio.findAllPromocione();
		editarPromocion = new Promocione();
	}

	public void actionListenerActivarDesactivarPromocion(int idPromocion) {
		try {
			mGimnasio.activarDesactivarPromocion(idPromocion);
			listaPromociones = mGimnasio.findAllPromocione();
			JSFUtil.crearMensajeINFO("Articulo activado/desactivado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<InventarioPk> getListaInventario() {
		return listaInventario;
	}

	public void setListaInventario(List<InventarioPk> listaInventario) {
		this.listaInventario = listaInventario;
	}

	public InventarioPk getNuevoInventario() {
		return nuevoInventario;
	}

	public void setNuevoInventario(InventarioPk nuevoInventario) {
		this.nuevoInventario = nuevoInventario;
	}

	public List<Servicio> getListaServicio() {
		return listaServicio;
	}

	public void setListaServicio(List<Servicio> listaServicio) {
		this.listaServicio = listaServicio;
	}

	public Servicio getNuevoServicio() {
		return nuevoServicio;
	}

	public void setNuevoServicio(Servicio nuevoServicio) {
		this.nuevoServicio = nuevoServicio;
	}

	public List<Promocione> getListaPromociones() {
		return listaPromociones;
	}

	public void setListaPromociones(List<Promocione> listaPromociones) {
		this.listaPromociones = listaPromociones;
	}

	public Promocione getNuevoPromocion() {
		return nuevoPromocion;
	}

	public void setNuevoPromocion(Promocione nuevoPromocion) {
		this.nuevoPromocion = nuevoPromocion;
	}

	public Promocione getEditarPromocion() {
		return editarPromocion;
	}

	public void setEditarPromocion(Promocione editarPromocion) {
		this.editarPromocion = editarPromocion;
	}

	public Servicio getEditarServicio() {
		return editarServicio;
	}

	public void setEditarServicio(Servicio editarServicio) {
		this.editarServicio = editarServicio;
	}

	public InventarioPk getEditarArticulo() {
		return editarArticulo;
	}

	public void setEditarArticulo(InventarioPk editarArticulo) {
		this.editarArticulo = editarArticulo;
	}

	public void graficar() {
		for (InventarioPk inven : listaInventario) {
			// pieModel.set;
		}
	}

	public PieChartModel createPieModel() {
		Random rd = new Random();
		pieModel = new PieChartModel();
		ChartData data = new ChartData();
		PieChartDataSet dataSet = new PieChartDataSet();
		List<Number> values = new ArrayList<>();
		for (InventarioPk number : listaInventario) {
			values.add(number.getInvCantidad());
		}
		dataSet.setData(values);

		List<String> bgColors = new ArrayList<>();
		for (int i = 0; i < listaInventario.size(); i++) {
			bgColors.add("rgb("+(rd.nextInt(255)+1)+", "+(rd.nextInt(255)+1)+", "+(rd.nextInt(255)+1)+")");
		}
		dataSet.setBackgroundColor(bgColors);

		data.addChartDataSet(dataSet);
		List<String> labels = new ArrayList<>();
		for (InventarioPk number : listaInventario) {
			labels.add(number.getInvArticulo());
		}
		data.setLabels(labels);
		pieModel.setData(data);
		return pieModel;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

}
