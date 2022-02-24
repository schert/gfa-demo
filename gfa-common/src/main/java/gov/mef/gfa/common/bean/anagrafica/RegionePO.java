package gov.mef.gfa.common.bean.anagrafica;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegionePO {

	@NotNull
	private String codRegione;
	private String denoRegione;
	private String siglaRegione;

}