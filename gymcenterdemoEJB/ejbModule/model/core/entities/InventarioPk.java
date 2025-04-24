package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inventario_pk database table.
 * 
 */
@Entity
@Table(name="inventario_pk")
@NamedQuery(name="InventarioPk.findAll", query="SELECT i FROM InventarioPk i")
public class InventarioPk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inv_id", unique=true, nullable=false)
	private Integer invId;

	@Column(name="inv_articulo", nullable=false, length=1024)
	private String invArticulo;

	@Column(name="inv_cantidad", nullable=false)
	private Integer invCantidad;

	@Column(name="inv_estado", nullable=false)
	private Boolean invEstado;

	@Column(name="inv_estadofisico", nullable=false)
	private Integer invEstadofisico;

	public InventarioPk() {
	}

	public Integer getInvId() {
		return this.invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public String getInvArticulo() {
		return this.invArticulo;
	}

	public void setInvArticulo(String invArticulo) {
		this.invArticulo = invArticulo;
	}

	public Integer getInvCantidad() {
		return this.invCantidad;
	}

	public void setInvCantidad(Integer invCantidad) {
		this.invCantidad = invCantidad;
	}

	public Boolean getInvEstado() {
		return this.invEstado;
	}

	public void setInvEstado(Boolean invEstado) {
		this.invEstado = invEstado;
	}

	public Integer getInvEstadofisico() {
		return this.invEstadofisico;
	}

	public void setInvEstadofisico(Integer invEstadofisico) {
		this.invEstadofisico = invEstadofisico;
	}

}