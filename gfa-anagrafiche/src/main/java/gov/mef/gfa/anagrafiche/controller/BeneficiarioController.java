package gov.mef.gfa.anagrafiche.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import gov.mef.gfa.anagrafiche.service.impl.BeneficiarioServiceImpl;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioPO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Beneficiario", description = "CRUD Anagrafica Beneficiario")
@RestController
@RequestMapping("/${path-name.beneficiario}/${api-tag}/v1")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioServiceImpl beneficiarioService;

	@GetMapping("/{id}")
	@Operation(summary = "Recupero Beneficiario per ID", description = "Restituisce tutte le informazioni relative al beneficiario ricercato tramite ID")
	public BeneficiarioPO getBeneficiarioById(@Parameter(name = "id", description = "ID del beneficiario", example = "12", required = true) @PathVariable(value = "id") BigDecimal id, HttpServletResponse response) {

		log.info("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);

		try {
			BeneficiarioPO beneficiario = beneficiarioService.getBeneficiarioById(id);
			if (beneficiario == null)
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return beneficiario;
		} catch (ServiceException e) {
			log.error("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@PostMapping("/addBeneficiario")
	@Operation(summary = "Put Beneficiario per ID", description = "Aggiorna le informazioni relative al beneficiario tramite ID, se non esiste lo crea")
	public BeneficiarioPO postBeneficiario(@Valid @RequestBody BeneficiarioPO beneficiario, HttpServletResponse response) {
		log.info("Controller: {} Method: postBeneficiario", BeneficiarioController.class);

		try {
			response.setStatus(HttpServletResponse.SC_CREATED);
			return beneficiarioService.putBeneficiario(beneficiario, null);
		} catch (ServiceException e) {
			log.error("Controller: {} Method: postBeneficiario", BeneficiarioController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@PutMapping("/{id}")
	@Operation(summary = "Put Beneficiario per ID", description = "Aggiorna le informazioni relative al beneficiario tramite ID, se non esiste lo crea")
	public BeneficiarioPO putBeneficiario(@RequestBody BeneficiarioPO beneficiario, @Parameter(name = "id", description = "ID del beneficiario", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
			HttpServletResponse response) {
		log.info("Controller: {} Method: putBeneficiario", BeneficiarioController.class);

		try {
			return beneficiarioService.putBeneficiario(beneficiario, id);
		} catch (ServiceException e) {
			log.error("Controller: {} Method: putBeneficiario", BeneficiarioController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Beneficiario per ID", description = "Elimina il beneficiario tramite ID")
	public void deleteBeneficiario(@Parameter(name = "id", description = "ID del beneficiario", example = "12", required = true) @PathVariable(value = "id") BigDecimal id, HttpServletResponse response) {
		log.info("Controller: {} Method: deleteBeneficiario", BeneficiarioController.class);

		try {
			if (beneficiarioService.deleteBeneficiario(id) == 0) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			}

		} catch (ServiceException e) {
			log.error("Controller: {} Method: deleteBeneficiario", BeneficiarioController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}
