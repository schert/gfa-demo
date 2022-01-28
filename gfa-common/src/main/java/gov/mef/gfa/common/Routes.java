package gov.mef.gfa.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Routes {
	ANAGRAFICA_TEST_ENTE(Path.ANAGRAFICA_TEST_ENTE),
	ANAGRAFICA_ENTE(Path.ANAGRAFICA_ENTE);
	
	private String path;
	
	public static class Path {
		public static final String ANAGRAFICA_TEST_ENTE = "/anagrafiche/ente/api/v1/mapTest";
		public static final String ANAGRAFICA_ENTE = "/anagrafiche/ente/api/v1/{id}";
	}

}