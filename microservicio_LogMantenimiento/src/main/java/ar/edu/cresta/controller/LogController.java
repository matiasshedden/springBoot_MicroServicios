package ar.edu.cresta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.cresta.model.Log;
import ar.edu.cresta.service.LogService;

@RestController
@RequestMapping("/logMantenimientos")
public class LogController {
	
	@Autowired
	private LogService log_service;

	@PostMapping("/")
	public void guardar_log(@RequestBody Log log) {
		getLog_service().guardar_log(log);
	}
	
	private LogService getLog_service() {
		return log_service;
	}
}
