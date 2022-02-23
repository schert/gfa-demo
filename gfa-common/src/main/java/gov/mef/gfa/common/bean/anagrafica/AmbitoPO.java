package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import gov.mef.gfa.common.validator.ReferedRequiredValidation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmbitoPO {
	@NotNull(groups = ReferedRequiredValidation.class)
	@Null
	public BigDecimal idAmbito;
	public String descrizione;

}
