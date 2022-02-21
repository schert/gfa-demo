package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import gov.mef.gfa.common.eum.TipoPersonaEnum;
import gov.mef.gfa.common.validator.InList;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmbitoPO {

	@NotNull
	public BigDecimal idAmbito;
	public String descrizione;

}
