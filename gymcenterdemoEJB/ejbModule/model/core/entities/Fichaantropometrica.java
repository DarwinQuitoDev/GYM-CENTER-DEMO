package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fichaantropometrica database table.
 * 
 */
@Entity
@Table(name="fichaantropometrica")
@NamedQuery(name="Fichaantropometrica.findAll", query="SELECT f FROM Fichaantropometrica f")
public class Fichaantropometrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fich_id", unique=true, nullable=false)
	private Integer fichId;

	@Temporal(TemporalType.DATE)
	@Column(name="fich_fecha_nacimiento")
	private Date fichFechaNacimiento;

	@Column(name="fich_tipo_sangre", length=2147483647)
	private String fichTipoSangre;

	//bi-directional many-to-one association to Detfichaantropometrica
	@OneToMany(mappedBy="fichaantropometrica")
	private List<Detfichaantropometrica> detfichaantropometricas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cli_id")
	private Cliente cliente;

	public Fichaantropometrica() {
	}

	public Integer getFichId() {
		return this.fichId;
	}

	public void setFichId(Integer fichId) {
		this.fichId = fichId;
	}

	public Date getFichFechaNacimiento() {
		return this.fichFechaNacimiento;
	}

	public void setFichFechaNacimiento(Date fichFechaNacimiento) {
		this.fichFechaNacimiento = fichFechaNacimiento;
	}

	public String getFichTipoSangre() {
		return this.fichTipoSangre;
	}

	public void setFichTipoSangre(String fichTipoSangre) {
		this.fichTipoSangre = fichTipoSangre;
	}

	public List<Detfichaantropometrica> getDetfichaantropometricas() {
		return this.detfichaantropometricas;
	}

	public void setDetfichaantropometricas(List<Detfichaantropometrica> detfichaantropometricas) {
		this.detfichaantropometricas = detfichaantropometricas;
	}

	public Detfichaantropometrica addDetfichaantropometrica(Detfichaantropometrica detfichaantropometrica) {
		getDetfichaantropometricas().add(detfichaantropometrica);
		detfichaantropometrica.setFichaantropometrica(this);

		return detfichaantropometrica;
	}

	public Detfichaantropometrica removeDetfichaantropometrica(Detfichaantropometrica detfichaantropometrica) {
		getDetfichaantropometricas().remove(detfichaantropometrica);
		detfichaantropometrica.setFichaantropometrica(null);

		return detfichaantropometrica;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}