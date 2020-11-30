package com.crs.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface MenuService {

	public List<MenuMasterEntity> getMenu();
	
	public List<MenuMasterEntity> getMenu(List<Integer> ids);

	public ResponseEntity<?> getMenuAll();
	
	public ResponseEntity<?> addMenu(MenuMasterEntity menu);
	
}
