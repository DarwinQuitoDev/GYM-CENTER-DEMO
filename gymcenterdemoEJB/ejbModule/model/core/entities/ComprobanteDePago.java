package model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the comprobante_de_pago database table.
 * 
 */
@Entity
@Table(name="comprobante_de_pago")
@NamedQuery(name="ComprobanteDePago.findAll", query="SELECT c FROM ComprobanteDePago c")
public class ComprobanteDePago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="com_id", unique=true, nullable=false)
	private Integer comId;

	@Column(name="com_descripcion", nullable=false, length=1024)
	private String comDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="com_fecha", nullable=false)
	private Date comFecha;

	@Column(name="com_total", nullable=false, precision=131089)
	private BigDecimal comTotal;

	//bi-directional many-to-one association to Membresia
	@ManyToOne
	@JoinColumn(name="mem_id", nullable=false)
	private Membresia membresia;

	//bi-directional many-to-one association to Promocione
	@ManyToOne
	@JoinColumn(name="prom_id", nullable=false)
	private Promocione promocione;

	public ComprobanteDePago() {
	}

	public Integer getComId() {
		return this.comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getComDescripcion() {
		return this.comDescripcion;
	}

	public void setComDescripcion(String comDescripcion) {
		this.comDescripcion = comDescripcion;
	}

	public Date getComFecha() {
		return this.comFecha;
	}

	public void setComFecha(Date comFecha) {
		this.comFecha = comFecha;
	}

	public BigDecimal getComTotal() {
		return this.comTotal;
	}

	public void setComTotal(BigDecimal comTotal) {
		this.comTotal = comTotal;
	}

	public Membresia getMembresia() {
		return this.membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public Promocione getPromocione() {
		return this.promocione;
	}

	public void setPromocione(Promocione promocione) {
		this.promocione = promocione;
	}

}