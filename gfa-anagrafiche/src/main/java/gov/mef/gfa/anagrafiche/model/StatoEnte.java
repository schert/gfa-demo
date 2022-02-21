package gov.mef.gfa.anagrafiche.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="STATO_ENTE")
public class StatoEnte {
	
	@Id
	public BigDecimal idStatoEnte;
	public String descrizione;

}
