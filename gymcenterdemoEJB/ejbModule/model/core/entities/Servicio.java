package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@Table(name="servicio")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ser_id", unique=true, nullable=false)
	private Integer serId;

	@Column(name="ser_descripcion", nullable=false, length=1024)
	private String serDescripcion;

	@Column(name="ser_duracion")
	private Integer serDuracion;

	@Column(name="ser_estado", nullable=false)
	private Boolean serEstado;

	@Column(name="ser_nombre", nullable=false, length=1024)
	private String serNombre;

	@Column(name="ser_precio", nullable=false, precision=131089)
	private BigDecimal serPrecio;

	//bi-directional many-to-one association to Membresia
	@OneToMany(mappedBy="servicio")
	private List<Membresia> membresias;

	public Servicio() {
	}

	public Integer getSerId() {
		return this.serId;
	}

	public void setSerId(Integer serId) {
		this.serId = serId;
	}

	public String getSerDescripcion() {
		return this.serDescripcion;
	}

	public void setSerDescripcion(String serDescripcion) {
		this.serDescripcion = serDescripcion;
	}

	public Integer getSerDuracion() {
		return this.serDuracion;
	}

	public void setSerDuracion(Integer serDuracion) {
		this.serDuracion = serDuracion;
	}

	public Boolean getSerEstado() {
		return this.serEstado;
	}

	public void setSerEstado(Boolean serEstado) {
		this.serEstado = serEstado;
	}

	public String getSerNombre() {
		return this.serNombre;
	}

	public void setSerNombre(String serNombre) {
		this.serNombre = serNombre;
	}

	public BigDecimal getSerPrecio() {
		return this.serPrecio;
	}

	public void setSerPrecio(BigDecimal serPrecio) {
		this.serPrecio = serPrecio;
	}

	public List<Membresia> getMembresias() {
		return this.membresias;
	}

	public void setMembresias(List<Membresia> membresias) {
		this.membresias = membresias;
	}

	public Membresia addMembresia(Membresia membresia) {
		getMembresias().add(membresia);
		membresia.setServicio(this);

		return membresia;
	}

	public Membresia removeMembresia(Membresia membresia) {
		getMembresias().remove(membresia);
		membresia.setServicio(null);

		return membresia;
	}

}