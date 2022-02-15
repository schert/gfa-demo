package gov.mef.gfa.filemanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the STATO_DOCUMENTO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="STATO_DOCUMENTO")
public class StatoDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_STATO_DOCUMENTO", unique=true, nullable=false)
	private long idStatoDocumento;

	@Column(nullable=false, length=100)
	private String descrizione;
	
	@OneToMany(mappedBy="statoDocumentoBean")
	private List<Documento> documenti;
}