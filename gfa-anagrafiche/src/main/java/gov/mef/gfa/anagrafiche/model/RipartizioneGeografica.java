package gov.mef.gfa.anagrafiche.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="RIPARTIZIONEGEOGRAFICA")
public class RipartizioneGeografica {
	private static final long serialVersionUID = 1L;
	
	@Column(length=6)
	private String ripartizione;
	
	@Id
	@Column(length=10)
	private String codregione;

}
