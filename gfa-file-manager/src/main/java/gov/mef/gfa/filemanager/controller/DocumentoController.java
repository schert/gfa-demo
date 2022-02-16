package gov.mef.gfa.filemanager.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gov.mef.gfa.common.bean.common.StatusRes;
import gov.mef.gfa.filemanager.exception.FileException;
import gov.mef.gfa.filemanager.service.DocumentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "Documento", description = "Manager Documento")
@RestController
@RequestMapping("/${api-tag}/v1")
public class DocumentoController {

	@Autowired
	DocumentoService documentoService;

	@PostMapping("/uploadFiles")
	public StatusRes uploadDocumenti(@RequestParam("files") MultipartFile[] files, HttpServletResponse response) {

		log.info("Controller: {} Method: getFinanziamentoDirettoById", DocumentoController.class);
		List<String> failsFileName = new ArrayList<>();

		try {
			Arrays.asList(files).stream().forEach(file -> {
				try {
					documentoService.putDocumento(file, null);
				} catch (FileException e) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					failsFileName.add(((MultipartFile) e.getObj()).getOriginalFilename());
				}

			});

			if (failsFileName.size() > 0) {
				return StatusRes.error("Errore nello storicizzare i file", failsFileName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return StatusRes.error("Errore nello storicizzare i file", e);
		}

		return StatusRes.success();
	}

}
