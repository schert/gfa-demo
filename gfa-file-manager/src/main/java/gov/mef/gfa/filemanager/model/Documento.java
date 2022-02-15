package gov.mef.gfa.filemanager.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the DOCUMENTO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="DOCUMENTO")
@SequenceGenerator(name = "seqid-gen-documento", sequenceName = "DOCUMENTO_SEQ", allocationSize = 1)
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqid-gen-documento")
	@Column(name="ID_DOCUMENTO", unique=true, nullable=false)
	private BigDecimal idDocumento;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_CARICAMENTO")
	private Date dataCaricamento;

	@Column(name="FLAG_CANCELLATO", nullable = false)
	private boolean flagCancellato;

	@Column(name="ID_DOCUMENTALE")
	private BigDecimal idDocumentale;

	@Column(name="NOME_FILE", length=200)
	private String nomeFile;
	
	@Lob
	@Column(name="CONTENT_FILE")
	private Byte[] contentFile;

	@ManyToOne
	@JoinColumn(name="STATO_DOCUMENTO", foreignKey = @ForeignKey(name = "Fk_documento_stato_documento"))
	private StatoDocumento statoDocumentoBean;

	@ManyToOne
	@JoinColumn(name="TIPO_DOCUMENTO", foreignKey = @ForeignKey(name = "Fk_documento_tipo_documento"))
	private TipoDocumento tipoDocumentoBean;

}