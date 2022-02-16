package gov.mef.gfa.common.bean.anagrafica;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinciaPO {
	@NotNull
	private String codprovincia;
	private RegionePO regione;
	private String denoprovincia;
	private String sigla;

}