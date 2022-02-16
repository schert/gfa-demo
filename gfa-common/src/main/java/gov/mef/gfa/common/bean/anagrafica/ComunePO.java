package gov.mef.gfa.common.bean.anagrafica;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComunePO{
	@NotNull
	private String codcomune;
	private ProvinciaPO provincia;
	private String denocomune;

}