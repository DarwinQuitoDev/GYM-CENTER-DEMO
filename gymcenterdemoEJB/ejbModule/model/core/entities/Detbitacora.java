package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detbitacora database table.
 * 
 */
@Entity
@Table(name="detbitacora")
@NamedQuery(name="Detbitacora.findAll", query="SELECT d FROM Detbitacora d")
public class Detbitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detbit_id", unique=true, nullable=false)
	private Integer detbitId;

	//bi-directional many-to-one association to Bitacora
	@ManyToOne
	@JoinColumn(name="bit_id")
	private Bitacora bitacora;

	//bi-directional many-to-one association to Membresia
	@ManyToOne
	@JoinColumn(name="mem_id")
	private Membresia membresia;

	public Detbitacora() {
	}

	public Integer getDetbitId() {
		return this.detbitId;
	}

	public void setDetbitId(Integer detbitId) {
		this.detbitId = detbitId;
	}

	public Bitacora getBitacora() {
		return this.bitacora;
	}

	public void setBitacora(Bitacora bitacora) {
		this.bitacora = bitacora;
	}

	public Membresia getMembresia() {
		return this.membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

}