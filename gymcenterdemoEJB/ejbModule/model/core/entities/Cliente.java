package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_id", unique=true, nullable=false)
	private Integer cliId;

	@Column(name="cli_apellido", nullable=false, length=1024)
	private String cliApellido;

	@Column(name="cli_cedula", nullable=false, length=1024)
	private String cliCedula;

	@Column(name="cli_correo", nullable=false, length=1024)
	private String cliCorreo;

	@Column(name="cli_direcciom", nullable=false, length=1024)
	private String cliDirecciom;

	@Column(name="cli_nombre", nullable=false, length=1024)
	private String cliNombre;

	@Column(name="cli_telefono", nullable=false, length=1024)
	private String cliTelefono;

	//bi-directional many-to-one association to Fichaantropometrica
	@OneToMany(mappedBy="cliente")
	private List<Fichaantropometrica> fichaantropometricas;

	public Cliente() {
	}

	public Integer getCliId() {
		return this.cliId;
	}

	public void setCliId(Integer cliId) {
		this.cliId = cliId;
	}

	public String getCliApellido() {
		return this.cliApellido;
	}

	public void setCliApellido(String cliApellido) {
		this.cliApellido = cliApellido;
	}

	public String getCliCedula() {
		return this.cliCedula;
	}

	public void setCliCedula(String cliCedula) {
		this.cliCedula = cliCedula;
	}

	public String getCliCorreo() {
		return this.cliCorreo;
	}

	public void setCliCorreo(String cliCorreo) {
		this.cliCorreo = cliCorreo;
	}

	public String getCliDirecciom() {
		return this.cliDirecciom;
	}

	public void setCliDirecciom(String cliDirecciom) {
		this.cliDirecciom = cliDirecciom;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public List<Fichaantropometrica> getFichaantropometricas() {
		return this.fichaantropometricas;
	}

	public void setFichaantropometricas(List<Fichaantropometrica> fichaantropometricas) {
		this.fichaantropometricas = fichaantropometricas;
	}

	public Fichaantropometrica addFichaantropometrica(Fichaantropometrica fichaantropometrica) {
		getFichaantropometricas().add(fichaantropometrica);
		fichaantropometrica.setCliente(this);

		return fichaantropometrica;
	}

	public Fichaantropometrica removeFichaantropometrica(Fichaantropometrica fichaantropometrica) {
		getFichaantropometricas().remove(fichaantropometrica);
		fichaantropometrica.setCliente(null);

		return fichaantropometrica;
	}

}