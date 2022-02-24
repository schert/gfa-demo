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
	@Column(name="CODPROVINCIA", nullable=false, length=10)
	private String codProvincia;

    @ManyToOne
    @JoinColumn(name = "CODREGIONE", foreignKey=@ForeignKey(name = "Fk_provincia_regione"))
	private Regione regione;

	@Column(name="DENOPROVINCIA", length=255)
	private String denoProvincia;

	@Column(length=3)
	private String sigla;

}