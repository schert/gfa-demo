package gov.mef.gfa.anagrafiche.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.service.impl.BeneficiarioServiceImpl;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioRes;
import gov.mef.gfa.common.bean.common.StatusRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@Tag(name = "Beneficiario", description = "CRUD Anagrafica Beneficiario")
@RestController
@RequestMapping("/${path-name.beneficiario}/${api-tag}/v1")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioServiceImpl beneficiarioService;

	Logger logger = LoggerFactory.getLogger(BeneficiarioController.class);

	@GetMapping("/{id}")
	@Operation(summary = "Recupero Beneficiario per ID", description = "Restituisce tutte le informazioni relative al beneficiario ricercato tramite ID")
	public Mono<ResponseEntity<BeneficiarioRes>> getBeneficiarioById(
			@Parameter(name = "id", description = "ID del beneficiario", example = "12", required = true) @PathVariable(value = "id") BigDecimal id) {

		logger.info("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);

		try {
			return beneficiarioService.getBeneficiarioById(id)
					.map(beneficiario -> new ResponseEntity<BeneficiarioRes>(beneficiario, HttpStatus.OK))
					.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		} catch (ServiceException e) {
			BeneficiarioRes beneficiarioResponse = new BeneficiarioRes();
			beneficiarioResponse.setStatus(StatusRes.error("Errore nel recuperare le informazioni", id));
			logger.error("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);
			e.printStackTrace();
			return Mono.just(beneficiarioResponse)
					.map(beneficiario -> new ResponseEntity<BeneficiarioRes>(beneficiario, HttpStatus.OK));
		}
	}

//	@PutMapping("/update")
//	public Mono<ResponseEntity<BeneficiarioRes>> updateBeneficiario(@RequestBody BeneficiarioRes beneficiario) {
//		logger.info("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);
//
//	}
}
