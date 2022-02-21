package gov.mef.gfa.anagrafiche.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.service.impl.MonitoraggioImpl;
import gov.mef.gfa.anagrafiche.service.impl.RichiestaFinanziamentoImpl;
import gov.mef.gfa.common.bean.anagrafica.RichiestaFinanziamentoPO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Richiesta Finanziamento", description = "CRUD Anagrafica Richiesta Finanziamento")
@RestController
@RequestMapping("/${path-name.richiestaFinanziamento}/${api-tag}/v1")
public class RichiestaFinanziamentoController {

	@Autowired
	private RichiestaFinanziamentoImpl richiestaFinanziamentoService;

	@GetMapping("/{id}")
	@Operation(summary = "Recupero Richiesta Finanziamento per ID", description = "Restituisce tutte le informazioni relative alla richiesta di finanziamento ricercato tramite ID")
	public RichiestaFinanziamentoPO getRichiestaFinanziamentoById(
			@Parameter(name = "id", description = "ID della richiesta di finanziamento", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
			HttpServletResponse response) {

		log.info("Controller: {} Method: getRichiestaFinanziamentoById", RichiestaFinanziamentoController.class);

		try {
			RichiestaFinanziamentoPO richiestaFinanziamento = richiestaFinanziamentoService
					.getRichiestaFinanziamentoById(id);
			if (richiestaFinanziamento == null)
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return richiestaFinanziamento;
		} catch (ServiceException e) {
			log.error("Controller: {} Method: getRichiestaFinanziamentoById", RichiestaFinanziamentoController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@PostMapping("/addRichiestaFinanziamento")
	@Operation(summary = "Put Richiesta Finanziamento per ID", description = "Aggiorna le informazioni relative alla ricerca di finanziamento tramite ID, se non esiste lo crea")
	public RichiestaFinanziamentoPO postRichiestaFinanziamento(
			@RequestBody RichiestaFinanziamentoPO richiestaFinanziamentoPO, HttpServletResponse response) {
		log.info("Controller: {} Method: postRichiestaFinanziamento", RichiestaFinanziamentoController.class);

		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return richiestaFinanziamentoService.putRichiestaFinanziamento(richiestaFinanziamentoPO, null);
		} catch (ServiceException e) {
			log.error("Controller: {} Method: postRichiestaFinanziamento", RichiestaFinanziamentoController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@PutMapping("/{id}")
	@Operation(summary = "Put Richiesta Finanziamento per ID", description = "Aggiorna le informazioni relative alla richiesta di richiestaFinanziamentoPO tramite ID, se non esiste lo crea")
	public RichiestaFinanziamentoPO putRichiestaFinanziamento(@RequestBody RichiestaFinanziamentoPO richiestaFinanziamentoPO,
			@Parameter(name = "id", description = "ID della richiesta di finanziamento", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
			HttpServletResponse response) {
		log.info("Controller: {} Method: putFinanziamento", RichiestaFinanziamentoController.class);

		try {
			return richiestaFinanziamentoService.putRichiestaFinanziamento(richiestaFinanziamentoPO, id);
		} catch (ServiceException e) {
			log.error("Controller: {} Method: putFinanziamento", RichiestaFinanziamentoController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Richiesta Finanziamento per ID", description = "Elimina la richiesta di finanziamento tramite ID")
	public void deleteRichiestaFinanziamento(
			@Parameter(name = "id", description = "ID della richiesta di finanziamento", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
			HttpServletResponse response) {
		log.info("Controller: {} Method: deleteRichiestaFinanziamento", RichiestaFinanziamentoController.class);

		try {
			if (richiestaFinanziamentoService.deleteRichiestaFinanziamento(id) == 0) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			}

		} catch (ServiceException e) {
			log.error("Controller: {} Method: deleteRichiestaFinanziamento", RichiestaFinanziamentoController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
