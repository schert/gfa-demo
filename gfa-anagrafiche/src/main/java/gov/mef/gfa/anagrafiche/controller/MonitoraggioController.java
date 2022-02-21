package gov.mef.gfa.anagrafiche.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;

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
import gov.mef.gfa.common.bean.anagrafica.MonitoraggioPO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Monitoraggio", description = "CRUD Anagrafica Monitoraggio")
@RestController
@RequestMapping("/${path-name.monitoraggio}/${api-tag}/v1")
public class MonitoraggioController {

    @Autowired
    private MonitoraggioImpl monitoraggioService;

    @GetMapping("/{id}")
    @Operation(summary = "Recupero Monitoraggio per ID", description = "Restituisce tutte le informazioni relative al monitoraggio ricercato tramite ID")
    public MonitoraggioPO getMonitoraggioById(
            @Parameter(name = "id", description = "ID del monitoraggio", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
            HttpServletResponse response) {

        log.info("Controller: {} Method: getMonitoraggioById", MonitoraggioController.class);

        try {
            MonitoraggioPO monitoraggio = monitoraggioService.getMonitoraggioById(id);
            if (monitoraggio == null)
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return monitoraggio;
        } catch (ServiceException e) {
            log.error("Controller: {} Method: getMonitoraggioById", MonitoraggioController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @PostMapping("/addMonitoraggio")
    @Operation(summary = "Put Monitoraggio per ID", description = "Aggiorna le informazioni relative al monitoraggio tramite ID, se non esiste lo crea")
    public MonitoraggioPO postMonitoraggio(@RequestBody MonitoraggioPO monitoraggio,
            HttpServletResponse response) {
        log.info("Controller: {} Method: postMonitoraggio", MonitoraggioController.class);

        try {
        	response.setStatus(HttpServletResponse.SC_CREATED);
            return monitoraggioService.putMonitoraggio(monitoraggio, null);
        } catch (ServiceException e) {
            log.error("Controller: {} Method: postMonitoraggio", MonitoraggioController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Put Monitoraggio per ID", description = "Aggiorna le informazioni relative al monitoraggio tramite ID, se non esiste lo crea")
    public MonitoraggioPO putMonitoraggio(@RequestBody MonitoraggioPO monitoraggio,
            @Parameter(name = "id", description = "ID del monitoraggio", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
            HttpServletResponse response) {
        log.info("Controller: {} Method: putMonitoraggio", MonitoraggioController.class);

        try {
            return monitoraggioService.putMonitoraggio(monitoraggio, id);
        } catch (ServiceException e) {
            log.error("Controller: {} Method: putMonitoraggio", MonitoraggioController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Monitoraggio per ID", description = "Elimina il monitoraggio tramite ID")
    public void deleteMonitoraggio(
            @Parameter(name = "id", description = "ID del monitoraggio", example = "12", required = true) @PathVariable(value = "id") BigDecimal id,
            HttpServletResponse response) {
        log.info("Controller: {} Method: deleteMonitoraggio", MonitoraggioController.class);

        try {
            if (monitoraggioService.deleteMonitoraggio(id) == 0) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            } else {
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }

        } catch (ServiceException e) {
            log.error("Controller: {} Method: deleteMonitoraggio", MonitoraggioController.class);
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
