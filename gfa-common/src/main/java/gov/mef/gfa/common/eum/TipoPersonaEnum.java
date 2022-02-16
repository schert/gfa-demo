package gov.mef.gfa.common.eum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoPersonaEnum {
	FISICA("1", "Fisica"), GIURIDICA("2", "Giuridica");

	public final String id;
	public final String name;

	public static class Constants {
		public static final String FISICA = "1";
		public static final String GIURIDICA = "2";
	}
}