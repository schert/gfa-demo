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
import gov.mef.gfa.anagrafiche.service.impl.FinanziamentoDirettoImpl;
import gov.mef.gfa.common.bean.anagrafica.FinanziamentoDirettoRes;
import gov.mef.gfa.common.bean.common.StatusRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@Tag(name = "Finanziamento", description = "CRUD Anagrafica Finanziamento Diretto")
@RestController
@RequestMapping("/${path-name.finanziamento}/${api-tag}/v1")
public class FinanziamentoDirettoController {

    @Autowired
    private FinanziamentoDirettoImpl finanziamentoService;

    Logger logger = LoggerFactory.getLogger(FinanziamentoDirettoController.class);

    @GetMapping("/{id}")
    @Operation(summary = "Recupero Finanziamento Diretto per ID", description = "Restituisce tutte le informazioni relative al finanziamento ricercato tramite ID")
    public Mono<ResponseEntity<FinanziamentoDirettoRes>> getFinanziamentoDirettoById(
            @Parameter(name = "id", description = "ID del finanziamento", example = "12", required = true) @PathVariable(value = "id") BigDecimal id) {

        logger.info("Controller: {} Method: getFinanziamentoDirettoById", FinanziamentoDirettoController.class);

        try {
            return finanziamentoService.getFinanziamentoDirettoById(id)
                    .map(finanziamento -> new ResponseEntity<FinanziamentoDirettoRes>(finanziamento, HttpStatus.OK))
                    .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (ServiceException e) {
            logger.error("Controller: {} Method: getFinanziamentoDirettoById", FinanziamentoDirettoController.class);
            e.printStackTrace();
            return Mono.just(new FinanziamentoDirettoRes()).map(finanziamento -> {
                finanziamento.setStatus(StatusRes.error("Errore nel recuperare le informazioni", id));
                return new ResponseEntity<>(finanziamento, HttpStatus.INTERNAL_SERVER_ERROR);
            });
        }
    }

}
