package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the detfichaantropometrica database table.
 * 
 */
@Entity
@Table(name="detfichaantropometrica")
@NamedQuery(name="Detfichaantropometrica.findAll", query="SELECT d FROM Detfichaantropometrica d")
public class Detfichaantropometrica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="detf_id", unique=true, nullable=false)
	private Integer detfId;

	@Column(name="detf_bipces_der", nullable=false, precision=131089)
	private BigDecimal detfBipcesDer;

	@Column(name="detf_bipces_izq", nullable=false, precision=131089)
	private BigDecimal detfBipcesIzq;

	@Column(name="detf_cintura", nullable=false, precision=131089)
	private BigDecimal detfCintura;

	@Column(name="detf_espalda", nullable=false, precision=131089)
	private BigDecimal detfEspalda;

	@Column(name="detf_estatura", nullable=false, precision=131089)
	private BigDecimal detfEstatura;

	@Temporal(TemporalType.DATE)
	@Column(name="detf_fechadet", nullable=false)
	private Date detfFechadet;

	@Column(name="detf_muslo_der", nullable=false, precision=131089)
	private BigDecimal detfMusloDer;

	@Column(name="detf_muslo_izq", nullable=false, precision=131089)
	private BigDecimal detfMusloIzq;

	@Column(name="detf_pantorrila_der", nullable=false, precision=131089)
	private BigDecimal detfPantorrilaDer;

	@Column(name="detf_pantorrila_izq", nullable=false, precision=131089)
	private BigDecimal detfPantorrilaIzq;

	@Column(name="detf_peso", nullable=false, precision=131089)
	private BigDecimal detfPeso;

	@Column(name="detf_toraxico_inspiracion", nullable=false, precision=131089)
	private BigDecimal detfToraxicoInspiracion;

	@Column(name="detf_toraxico_normal", nullable=false, precision=131089)
	private BigDecimal detfToraxicoNormal;

	//bi-directional many-to-one association to Fichaantropometrica
	@ManyToOne
	@JoinColumn(name="fich_id", nullable=false)
	private Fichaantropometrica fichaantropometrica;

	public Detfichaantropometrica() {
	}

	public Integer getDetfId() {
		return this.detfId;
	}

	public void setDetfId(Integer detfId) {
		this.detfId = detfId;
	}

	public BigDecimal getDetfBipcesDer() {
		return this.detfBipcesDer;
	}

	public void setDetfBipcesDer(BigDecimal detfBipcesDer) {
		this.detfBipcesDer = detfBipcesDer;
	}

	public BigDecimal getDetfBipcesIzq() {
		return this.detfBipcesIzq;
	}

	public void setDetfBipcesIzq(BigDecimal detfBipcesIzq) {
		this.detfBipcesIzq = detfBipcesIzq;
	}

	public BigDecimal getDetfCintura() {
		return this.detfCintura;
	}

	public void setDetfCintura(BigDecimal detfCintura) {
		this.detfCintura = detfCintura;
	}

	public BigDecimal getDetfEspalda() {
		return this.detfEspalda;
	}

	public void setDetfEspalda(BigDecimal detfEspalda) {
		this.detfEspalda = detfEspalda;
	}

	public BigDecimal getDetfEstatura() {
		return this.detfEstatura;
	}

	public void setDetfEstatura(BigDecimal detfEstatura) {
		this.detfEstatura = detfEstatura;
	}

	public Date getDetfFechadet() {
		return this.detfFechadet;
	}

	public void setDetfFechadet(Date detfFechadet) {
		this.detfFechadet = detfFechadet;
	}

	public BigDecimal getDetfMusloDer() {
		return this.detfMusloDer;
	}

	public void setDetfMusloDer(BigDecimal detfMusloDer) {
		this.detfMusloDer = detfMusloDer;
	}

	public BigDecimal getDetfMusloIzq() {
		return this.detfMusloIzq;
	}

	public void setDetfMusloIzq(BigDecimal detfMusloIzq) {
		this.detfMusloIzq = detfMusloIzq;
	}

	public BigDecimal getDetfPantorrilaDer() {
		return this.detfPantorrilaDer;
	}

	public void setDetfPantorrilaDer(BigDecimal detfPantorrilaDer) {
		this.detfPantorrilaDer = detfPantorrilaDer;
	}

	public BigDecimal getDetfPantorrilaIzq() {
		return this.detfPantorrilaIzq;
	}

	public void setDetfPantorrilaIzq(BigDecimal detfPantorrilaIzq) {
		this.detfPantorrilaIzq = detfPantorrilaIzq;
	}

	public BigDecimal getDetfPeso() {
		return this.detfPeso;
	}

	public void setDetfPeso(BigDecimal detfPeso) {
		this.detfPeso = detfPeso;
	}

	public BigDecimal getDetfToraxicoInspiracion() {
		return this.detfToraxicoInspiracion;
	}

	public void setDetfToraxicoInspiracion(BigDecimal detfToraxicoInspiracion) {
		this.detfToraxicoInspiracion = detfToraxicoInspiracion;
	}

	public BigDecimal getDetfToraxicoNormal() {
		return this.detfToraxicoNormal;
	}

	public void setDetfToraxicoNormal(BigDecimal detfToraxicoNormal) {
		this.detfToraxicoNormal = detfToraxicoNormal;
	}

	public Fichaantropometrica getFichaantropometrica() {
		return this.fichaantropometrica;
	}

	public void setFichaantropometrica(Fichaantropometrica fichaantropometrica) {
		this.fichaantropometrica = fichaantropometrica;
	}

}