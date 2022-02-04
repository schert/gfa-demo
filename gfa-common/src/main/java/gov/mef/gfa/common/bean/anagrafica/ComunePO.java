package gov.mef.gfa.common.bean.anagrafica;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComunePO{

	private String codcomune;
	private ProvinciaPO provincia;
	private String denocomune;

}