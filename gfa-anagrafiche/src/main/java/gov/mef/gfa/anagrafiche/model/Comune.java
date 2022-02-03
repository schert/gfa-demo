package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;

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
 * The persistent class for the COMUNE database table.
 * 
 */
@Entity
@Table(name="COMUNE")
@Data
@NoArgsConstructor
public class Comune implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, length=10)
	private String codcomune;

	@ManyToOne
	@JoinColumn(name = "codprovincia", foreignKey=@ForeignKey(name = "Fk_comune_provincia"), nullable = false)
	private Provincia codprovincia;

	@Column(length=255)
	private String denocomune;

}