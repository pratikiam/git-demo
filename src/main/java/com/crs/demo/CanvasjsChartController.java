package com.crs.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crs.demo.CanvasjsChartData.DataPointModel;
import com.crs.demo.CanvasjsChartData.DatabaseConnectionException;
 

@Controller
@RequestMapping("/canvasjschart")
public class CanvasjsChartController {
 
	@Autowired
	private CanvasjsChartService canvasjsChartService;
 
	@RequestMapping(method = RequestMethod.GET)
	public String springMVC(ModelMap modelMap) {
		List<List<DataPointModel>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		return "charts";
	}
 
	@ExceptionHandler({DatabaseConnectionException.class})
	public ModelAndView getSuperheroesUnavailable(DatabaseConnectionException ex) {
	    return new ModelAndView("charts", "error", ex.getMessage());
	}
}