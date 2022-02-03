package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the STRUTTURA_UFFICIO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="STRUTTURA_UFFICIO")
public class StrutturaUfficio implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idstruttura", foreignKey=@ForeignKey(name = "Fk_str_ufficio_struttura"), nullable = false)
	private Struttura struttura;

	@Id
	@Column(nullable=false, precision=38)
	private BigDecimal idufficio;
}