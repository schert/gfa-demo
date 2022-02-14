package gov.mef.gfa.anagrafiche.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import gov.mef.gfa.anagrafiche.service.impl.FinanziamentoDirettoImpl;
import gov.mef.gfa.common.bean.anagrafica.FinanziamentoDirettoPO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Finanziamento", description = "CRUD Anagrafica Finanziamento Diretto")
@RestController
@RequestMapping("/${path-name.finanziamento}/${api-tag}/v1")
public class FinanziamentoDirettoController {

    @Autowired
    private FinanziamentoDirettoImpl finanziamentoService;

    Logger logger = LoggerFactory.getLogger(FinanziamentoDirettoController.class);

    @GetMapping("/{id}")
    @Operation(summary = "Recupero Finanziamento Diretto per ID", description = "Restituisce tutte le informazioni relative al finanziamento ricercato tramite ID")
    public FinanziamentoDirettoPO getFinanziamentoDirettoById(
            @Parameter(name = "id", description = "ID del finanziamento", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
            HttpServletResponse response) {

        logger.info("Controller: {} Method: getFinanziamentoDirettoById", FinanziamentoDirettoController.class);

        try {
            FinanziamentoDirettoPO finanziamento = finanziamentoService.getFinanziamentoDirettoById(id);
            if (finanziamento == null)
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return finanziamento;
        } catch (ServiceException e) {
            logger.error("Controller: {} Method: getFinanziamentoDirettoById", FinanziamentoDirettoController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @PostMapping("/addFinanziamento")
    @Operation(summary = "Put Finanziamento per ID", description = "Aggiorna le informazioni relative al finanziamento tramite ID, se non esiste lo crea")
    public FinanziamentoDirettoPO postFinanziamento(@RequestBody FinanziamentoDirettoPO finanziamento,
            HttpServletResponse response) {
        logger.info("Controller: {} Method: postFinanziamento", FinanziamentoDirettoController.class);

        try {
            return finanziamentoService.putFinanziamento(finanziamento, null);
        } catch (ServiceException e) {
            logger.error("Controller: {} Method: postFinanziamento", FinanziamentoDirettoController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_CREATED);
            return null;
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Put Finanziamento per ID", description = "Aggiorna le informazioni relative al finanziamento tramite ID, se non esiste lo crea")
    public FinanziamentoDirettoPO putFinanziamento(@RequestBody FinanziamentoDirettoPO finanziamento,
            @Parameter(name = "id", description = "ID del finanziamento", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
            HttpServletResponse response) {
        logger.info("Controller: {} Method: putFinanziamento", FinanziamentoDirettoController.class);

        try {
            return finanziamentoService.putFinanziamento(finanziamento, id);
        } catch (ServiceException e) {
            logger.error("Controller: {} Method: putFinanziamento", FinanziamentoDirettoController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Finanziamento per ID", description = "Elimina il finanziamento tramite ID")
    public void deleteFinanziamento(
            @Parameter(name = "id", description = "ID del finanziamento", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
            HttpServletResponse response) {
        logger.info("Controller: {} Method: deleteFinanziamento", FinanziamentoDirettoController.class);

        try {
            if (finanziamentoService.deleteFinanziamento(id) == 0) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }

        } catch (ServiceException e) {
            logger.error("Controller: {} Method: deleteFinanziamento", FinanziamentoDirettoController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
