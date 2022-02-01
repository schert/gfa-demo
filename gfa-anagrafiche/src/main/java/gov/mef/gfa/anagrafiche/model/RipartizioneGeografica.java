package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="RIPARTIZIONEGEOGRAFICA")
public class RipartizioneGeografica implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(length=6)
	private String ripartizione;
	
	@Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codregione", foreignKey=@ForeignKey(name = "Fk_regione"))
	private Regione regione;

}
