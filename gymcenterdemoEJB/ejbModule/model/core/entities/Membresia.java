package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the membresia database table.
 * 
 */
@Entity
@Table(name="membresia")
@NamedQuery(name="Membresia.findAll", query="SELECT m FROM Membresia m")
public class Membresia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mem_id", unique=true, nullable=false)
	private Integer memId;

	@Temporal(TemporalType.DATE)
	@Column(name="mem_fecha_fin", nullable=false)
	private Date memFechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="mem_fecha_ini", nullable=false)
	private Date memFechaIni;

	//bi-directional many-to-one association to ComprobanteDePago
	@OneToMany(mappedBy="membresia")
	private List<ComprobanteDePago> comprobanteDePagos;

	//bi-directional many-to-one association to Detbitacora
	@OneToMany(mappedBy="membresia")
	private List<Detbitacora> detbitacoras;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cli_id", nullable=false)
	private Cliente cliente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="ser_id", nullable=false)
	private Servicio servicio;

	public Membresia() {
	}

	public Integer getMemId() {
		return this.memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Date getMemFechaFin() {
		return this.memFechaFin;
	}

	public void setMemFechaFin(Date memFechaFin) {
		this.memFechaFin = memFechaFin;
	}

	public Date getMemFechaIni() {
		return this.memFechaIni;
	}

	public void setMemFechaIni(Date memFechaIni) {
		this.memFechaIni = memFechaIni;
	}

	public List<ComprobanteDePago> getComprobanteDePagos() {
		return this.comprobanteDePagos;
	}

	public void setComprobanteDePagos(List<ComprobanteDePago> comprobanteDePagos) {
		this.comprobanteDePagos = comprobanteDePagos;
	}

	public ComprobanteDePago addComprobanteDePago(ComprobanteDePago comprobanteDePago) {
		getComprobanteDePagos().add(comprobanteDePago);
		comprobanteDePago.setMembresia(this);

		return comprobanteDePago;
	}

	public ComprobanteDePago removeComprobanteDePago(ComprobanteDePago comprobanteDePago) {
		getComprobanteDePagos().remove(comprobanteDePago);
		comprobanteDePago.setMembresia(null);

		return comprobanteDePago;
	}

	public List<Detbitacora> getDetbitacoras() {
		return this.detbitacoras;
	}

	public void setDetbitacoras(List<Detbitacora> detbitacoras) {
		this.detbitacoras = detbitacoras;
	}

	public Detbitacora addDetbitacora(Detbitacora detbitacora) {
		getDetbitacoras().add(detbitacora);
		detbitacora.setMembresia(this);

		return detbitacora;
	}

	public Detbitacora removeDetbitacora(Detbitacora detbitacora) {
		getDetbitacoras().remove(detbitacora);
		detbitacora.setMembresia(null);

		return detbitacora;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}