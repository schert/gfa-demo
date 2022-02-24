package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the REGIONE database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="REGIONE")
public class Regione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODREGIONE", nullable=false, length=10)
	private String codRegione;

	@Column(name="DENOREGIONE", length=255)
	private String denoRegione;

	@Column(name="SIGLAREGIONE", length=3, unique = true)
	private String siglaRegione;

}