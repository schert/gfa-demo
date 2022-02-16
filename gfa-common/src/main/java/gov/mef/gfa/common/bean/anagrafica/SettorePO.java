package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SettorePO {
	@NotNull
	private BigDecimal idsettore;
	private String descrizione;

}
