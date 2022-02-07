package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeneficiarioPO {
	private long idBeneficiario;
	private String codiceAteco;
	private String codiceFiscale;
	private ComunePO comune;
	private String email;
	private String fax;
	private String indirizzo;
	private String nominativo;
	private String note;
	private BigDecimal numeroAddetti;
	private String partitaIva;
	private ProvinciaPO provincia;
	private String ragioneSociale;
	private RegionePO regione;
	private SettorePO settore;
	private String telefono;
	boolean flagCancellatoSn;

}