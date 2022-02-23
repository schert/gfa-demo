package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatoRichiestaFinanziamentoPO {
	@NotNull
	public BigDecimal idStatoFinanziamento;
	public String descrizione;

}
