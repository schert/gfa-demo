package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

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
	@Column(nullable=false, length=10)
	private String codregione;

	@Column(length=255)
	private String denoregione;

	@Column(length=3)
	private String siglaregione;

}