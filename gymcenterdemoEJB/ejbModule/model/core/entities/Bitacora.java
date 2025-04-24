package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bitacora database table.
 * 
 */
@Entity
@Table(name="bitacora")
@NamedQuery(name="Bitacora.findAll", query="SELECT b FROM Bitacora b")
public class Bitacora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bit_id", unique=true, nullable=false)
	private Integer bitId;

	@Temporal(TemporalType.DATE)
	@Column(name="bit_fecha_fn", nullable=false)
	private Date bitFechaFn;

	@Temporal(TemporalType.DATE)
	@Column(name="bit_fecha_in", nullable=false)
	private Date bitFechaIn;

	//bi-directional many-to-one association to Detbitacora
	@OneToMany(mappedBy="bitacora")
	private List<Detbitacora> detbitacoras;

	public Bitacora() {
	}

	public Integer getBitId() {
		return this.bitId;
	}

	public void setBitId(Integer bitId) {
		this.bitId = bitId;
	}

	public Date getBitFechaFn() {
		return this.bitFechaFn;
	}

	public void setBitFechaFn(Date bitFechaFn) {
		this.bitFechaFn = bitFechaFn;
	}

	public Date getBitFechaIn() {
		return this.bitFechaIn;
	}

	public void setBitFechaIn(Date bitFechaIn) {
		this.bitFechaIn = bitFechaIn;
	}

	public List<Detbitacora> getDetbitacoras() {
		return this.detbitacoras;
	}

	public void setDetbitacoras(List<Detbitacora> detbitacoras) {
		this.detbitacoras = detbitacoras;
	}

	public Detbitacora addDetbitacora(Detbitacora detbitacora) {
		getDetbitacoras().add(detbitacora);
		detbitacora.setBitacora(this);

		return detbitacora;
	}

	public Detbitacora removeDetbitacora(Detbitacora detbitacora) {
		getDetbitacoras().remove(detbitacora);
		detbitacora.setBitacora(null);

		return detbitacora;
	}

}