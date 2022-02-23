package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import gov.mef.gfa.common.validator.ReferedRequiredValidation;
import lombok.Data;

@Data
public class StatoEntePO {
	@NotNull(groups = ReferedRequiredValidation.class)
	@Null
	public BigDecimal idStatoEnte;
	public String descrizione;

}
