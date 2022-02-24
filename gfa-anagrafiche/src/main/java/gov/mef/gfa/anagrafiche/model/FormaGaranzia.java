package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the FORMA_GARANZIA database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "FORMA_GARANZIA")
public class FormaGaranzia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	private long id;

	@Column(nullable = false, length = 100)
	private String descrizione;

}