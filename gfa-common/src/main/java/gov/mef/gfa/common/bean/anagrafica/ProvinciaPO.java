package gov.mef.gfa.common.bean.anagrafica;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinciaPO {	
	
	@NotNull
	private String codProvincia;
	private RegionePO regione;
	private String denoProvincia;
	private String sigla;

}