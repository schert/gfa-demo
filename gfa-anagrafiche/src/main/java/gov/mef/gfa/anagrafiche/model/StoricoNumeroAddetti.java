package gov.mef.gfa.anagrafiche.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="STORICO_NUMERO_ADDETTI")
@SequenceGenerator(name = "seqid-gen-storico-addetti", sequenceName = "STORICO_ADDETTI_SEQ", allocationSize = 1)
public class StoricoNumeroAddetti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen-storico-addetti")
	public BigDecimal idStoricoNumeroAddetti;
	
	@ManyToOne
    @JoinColumn(name = "beneficiario", foreignKey=@ForeignKey(name = "Fk_str_num_addetti_beneficiario"))
	public Beneficiario beneficiario;
	
	public Date dataCompetenzaDa;
	public Date dataCompetenzaA;
	public BigDecimal numeroAddetti;
}
