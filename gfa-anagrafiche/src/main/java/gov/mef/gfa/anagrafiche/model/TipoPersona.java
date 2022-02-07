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
@Table(name="TIPO_PERSONA")
public class TipoPersona {
	
	@Id
	public BigDecimal idTipoPersona;
	public String descrizione;

}
