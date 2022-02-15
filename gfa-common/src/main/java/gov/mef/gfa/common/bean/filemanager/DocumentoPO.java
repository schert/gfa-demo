package gov.mef.gfa.common.bean.filemanager;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentoPO {

	private long idDocumento;
	private Date dataCaricamento;
	private boolean flagCancellato;
	private BigDecimal idDocumentale;
	private String nomeFile;
	private StatoDocumentoPO statoDocumento;
	private TipoDocumentoPO tipoDocumento;
}
