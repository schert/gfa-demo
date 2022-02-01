package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the PROVINCIA database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="PROVINCIA")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable=false, length=10)
	private String codprovincia;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codregione", foreignKey=@ForeignKey(name = "Fk_provincia_regione"))
	private Regione regione;

	@Column(length=255)
	private String denoprovincia;

	@Column(length=2)
	private String sigla;

}