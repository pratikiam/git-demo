package com.crs.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/MenuMaster")
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@GetMapping(value="/get",produces="application/json")
	public List<MenuMasterEntity> getMenu(){
		
		return menuService.getMenu();
	}
	
	@GetMapping(value="/getAll",produces="application/json")
	public ResponseEntity<?> getMenuAll(){
		
		return menuService.getMenuAll();
	}
	
	
	@PostMapping(value="/delete/{careid[]}",produces= "application/json")
	public void getdeleted(@PathVariable Integer [] careid){
		
		System.out.println("id "+careid);
		for(Integer ids:careid) {
			System.out.println("ids "+ids);
		}
	}
	
	@PostMapping(value="/add", produces="appllcation/json")
	public ResponseEntity<?> addMenu(@RequestBody MenuMasterEntity menu){
		return  menuService.addMenu(menu);
	}
}