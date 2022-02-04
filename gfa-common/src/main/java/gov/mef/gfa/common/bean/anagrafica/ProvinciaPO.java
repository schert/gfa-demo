package gov.mef.gfa.common.bean.anagrafica;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinciaPO {
	
	private String codprovincia;
	private RegionePO regione;
	private String denoprovincia;
	private String sigla;

}