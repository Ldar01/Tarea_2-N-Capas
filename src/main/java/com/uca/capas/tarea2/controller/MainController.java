package com.uca.capas.tarea2.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/alumno")
	public @ResponseBody String student() {
		String texto = "Nombre y apellido: Luisa Arevalo 	Carnet: 00038617	 Ingenieria Informatica	 Cuarto anio ";
		return texto;
	}
	@RequestMapping("/calendario")
	public @ResponseBody String calendar(HttpServletRequest req) throws ParseException {
		
		Integer day =Integer.parseInt(req.getParameter("dia"));
		Integer month = Integer.parseInt(req.getParameter("mes"));
		Integer year = Integer.parseInt(req.getParameter("anio"));
		
		Date date = new SimpleDateFormat("dd/M/yyyy").parse(day.toString()+ "/" + month.toString()+"/"+ year.toString());
		Calendar prueba = Calendar.getInstance();	
		prueba.setTime(date);
		int dayOfWeek = prueba.get(Calendar.DAY_OF_WEEK);
		
		String texto = "Day of the week form the given date: ";
		
		switch(dayOfWeek) {
		case 1: 
			return texto.concat("Sunday");
		case 2: 
			return texto.concat("Monday");
		case 3: 
			return texto.concat("Tuesday");
		case 4: 
			return texto.concat("Wednsday");
		case 5: 
			return texto.concat("Thrusday");
		case 6: 
			return texto.concat("Friday");
		case 7: 
			return texto.concat("Saturday");
		default:
			return texto.concat("NO VALID");
		}

	}
}
