package gov.mef.gfa.common.bean.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
	private UtentePO utente;
	private List<Profilo> profili;
}
