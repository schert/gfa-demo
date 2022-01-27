package gov.mef.gfa.anagrafiche.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENTE")
@Data
@NoArgsConstructor
public class Ente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDENTE", nullable = true)
	private Integer idEnte;

}
