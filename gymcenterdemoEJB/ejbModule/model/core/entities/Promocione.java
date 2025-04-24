package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the promociones database table.
 * 
 */
@Entity
@Table(name="promociones")
@NamedQuery(name="Promocione.findAll", query="SELECT p FROM Promocione p")
public class Promocione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prom_id", unique=true, nullable=false)
	private Integer promId;

	@Column(name="prom_descripcion", nullable=false, length=1024)
	private String promDescripcion;

	@Column(name="prom_descuento", nullable=false, precision=131089)
	private BigDecimal promDescuento;

	@Column(name="prom_estado", nullable=false)
	private Boolean promEstado;

	@Column(name="prom_nombre", nullable=false, length=1024)
	private String promNombre;

	//bi-directional many-to-one association to ComprobanteDePago
	@OneToMany(mappedBy="promocione")
	private List<ComprobanteDePago> comprobanteDePagos;

	public Promocione() {
	}

	public Integer getPromId() {
		return this.promId;
	}

	public void setPromId(Integer promId) {
		this.promId = promId;
	}

	public String getPromDescripcion() {
		return this.promDescripcion;
	}

	public void setPromDescripcion(String promDescripcion) {
		this.promDescripcion = promDescripcion;
	}

	public BigDecimal getPromDescuento() {
		return this.promDescuento;
	}

	public void setPromDescuento(BigDecimal promDescuento) {
		this.promDescuento = promDescuento;
	}

	public Boolean getPromEstado() {
		return this.promEstado;
	}

	public void setPromEstado(Boolean promEstado) {
		this.promEstado = promEstado;
	}

	public String getPromNombre() {
		return this.promNombre;
	}

	public void setPromNombre(String promNombre) {
		this.promNombre = promNombre;
	}

	public List<ComprobanteDePago> getComprobanteDePagos() {
		return this.comprobanteDePagos;
	}

	public void setComprobanteDePagos(List<ComprobanteDePago> comprobanteDePagos) {
		this.comprobanteDePagos = comprobanteDePagos;
	}

	public ComprobanteDePago addComprobanteDePago(ComprobanteDePago comprobanteDePago) {
		getComprobanteDePagos().add(comprobanteDePago);
		comprobanteDePago.setPromocione(this);

		return comprobanteDePago;
	}

	public ComprobanteDePago removeComprobanteDePago(ComprobanteDePago comprobanteDePago) {
		getComprobanteDePagos().remove(comprobanteDePago);
		comprobanteDePago.setPromocione(null);

		return comprobanteDePago;
	}

}