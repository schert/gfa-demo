package gov.mef.gfa.common.gfacommon.client;

import org.springframework.web.reactive.function.client.WebClient;

import gov.mef.gfa.common.Routes;

public class GfaClient {
	public static <T> T apiCallGetPathParams(WebClient.Builder builder, Class<T> type, Routes routes, Object... params) {
		try {
			return type.cast(builder.build().get().uri(uriBuilder -> uriBuilder.path(routes.getPath()).build(params))
					.retrieve().bodyToMono(type).block());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Notifica in pagina o pagina di servizio
			throw e;
		}
	}
}
