package gov.mef.gfa.anagrafiche.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
			logger.error("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);
			e.printStackTrace();
			return Mono.just(new BeneficiarioRes()).map(beneficiario -> {
				beneficiario.setStatus(StatusRes.error("Errore nel recuperare le informazioni", id));
				return new ResponseEntity<BeneficiarioRes>(beneficiario, HttpStatus.INTERNAL_SERVER_ERROR);
			});
		}
	}

	@PutMapping("/{id}")
	@Operation(summary = "Put Beneficiario per ID", description = "Aggiorna le informazioni relative al beneficiario tramite ID, se non esiste lo crea")
	public Mono<ResponseEntity<BeneficiarioRes>> putBeneficiario(@RequestBody BeneficiarioPO beneficiario, @PathVariable(value = "id") BigDecimal id) {
		logger.info("Controller: {} Method: putBeneficiario", BeneficiarioController.class);

		try {
			return beneficiarioService.putBeneficiario(beneficiario, id)
					.map(ben -> new ResponseEntity<BeneficiarioRes>(ben, HttpStatus.OK));
		} catch (ServiceException e) {
			logger.error("Controller: {} Method: putBeneficiario", BeneficiarioController.class);
			e.printStackTrace();
			return Mono.just(new BeneficiarioRes()).map(ben -> {
				ben.setStatus(StatusRes.error("Errore nell'effettuare la put", id));
				return new ResponseEntity<BeneficiarioRes>(ben, HttpStatus.INTERNAL_SERVER_ERROR);
			});
		}
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete Beneficiario per ID", description = "Elimina il beneficiario tramite ID")
	public Mono<ResponseEntity<BeneficiarioRes>> deleteBeneficiario(@PathVariable(value = "id") BigDecimal id) {
		logger.info("Controller: {} Method: deleteBeneficiario", BeneficiarioController.class);

		try {
			return beneficiarioService.deleteBeneficiario(id)
					.map(ben -> new ResponseEntity<BeneficiarioRes>(ben, HttpStatus.OK));
		} catch (ServiceException e) {
			logger.error("Controller: {} Method: deleteBeneficiario", BeneficiarioController.class);
			e.printStackTrace();
			return Mono.just(new BeneficiarioRes()).map(ben -> {
				ben.setStatus(StatusRes.error("Errore nell'effettuare la delete", id));
				return new ResponseEntity<BeneficiarioRes>(ben, HttpStatus.INTERNAL_SERVER_ERROR);
			});
		}
	}
}
