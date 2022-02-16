package gov.mef.gfa.common.bean.anagrafica;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegionePO {
	@NotNull
	private String codregione;
	private String denoregione;
	private String siglaregione;

}