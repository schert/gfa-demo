package gov.mef.gfa.common.bean.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationError {
	  private final String nome;
	  private final String messaggio;
}
