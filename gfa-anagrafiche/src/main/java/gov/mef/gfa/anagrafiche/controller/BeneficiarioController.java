package gov.mef.gfa.anagrafiche.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@Tag(name = "Beneficiario", description = "CRUD Anagrafica Beneficiario")
@RestController
@RequestMapping("/${path-name.beneficiario}/${api-tag}/v1")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioServiceImpl beneficiarioService;

	Logger logger = LoggerFactory.getLogger(BeneficiarioController.class);

	@GetMapping("/{id}")
	@Operation(summary = "Recupero Beneficiario per ID", description = "Restituisce tutte le informazioni relative al beneficiario ricercato tramite ID")
	public BeneficiarioPO getBeneficiarioById(
			@Parameter(name = "id", description = "ID del beneficiario", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
			HttpServletResponse response) {

		logger.info("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);

		try {
			BeneficiarioPO beneficiario = beneficiarioService.getBeneficiarioById(id);
			if (beneficiario == null)
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return beneficiario;
		} catch (ServiceException e) {
			logger.error("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@PutMapping("/{id}")
	@Operation(summary = "Put Beneficiario per ID", description = "Aggiorna le informazioni relative al beneficiario tramite ID, se non esiste lo crea")
	public BeneficiarioPO putBeneficiario(@RequestBody BeneficiarioPO beneficiario,
			@PathVariable(value = "id") BigDecimal id, HttpServletResponse response) {
		logger.info("Controller: {} Method: putBeneficiario", BeneficiarioController.class);

		try {
			return beneficiarioService.putBeneficiario(beneficiario, id);
		} catch (ServiceException e) {
			logger.error("Controller: {} Method: putBeneficiario", BeneficiarioController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Beneficiario per ID", description = "Elimina il beneficiario tramite ID")
	public BeneficiarioPO deleteBeneficiario(@PathVariable(value = "id") BigDecimal id, HttpServletResponse response) {
		logger.info("Controller: {} Method: deleteBeneficiario", BeneficiarioController.class);

		try {
			return beneficiarioService.deleteBeneficiario(id);
		} catch (ServiceException e) {
			logger.error("Controller: {} Method: deleteBeneficiario", BeneficiarioController.class);
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
	}
}
