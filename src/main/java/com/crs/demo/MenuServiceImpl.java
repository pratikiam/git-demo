package com.crs.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired 
	MenuRepo repo;
	
	
	
	List<MenuMasterEntity> allMenu = new ArrayList<MenuMasterEntity>();
	
	//MenuMasterEntity parent = new MenuMasterEntity();
	
	List<MenuMasterEntity> parent = new ArrayList<MenuMasterEntity>();
	
	List<MenuMasterEntity> compList = new ArrayList<MenuMasterEntity>();
	
	List<MenuMasterEntity> menu = new ArrayList<MenuMasterEntity>();
	
	List<String> parMenu = new ArrayList<String>();
	
	List<String> menuList = new ArrayList<String>();
	
	JSONObject output = new JSONObject();
	
	JSONObject temp = new JSONObject();
	
	
	
		HashMap<MenuMasterEntity,List<MenuMasterEntity>> map = new HashMap<>();		 
		HashMap<MenuMasterEntity,HashMap<MenuMasterEntity, List<MenuMasterEntity>>> mp = new HashMap<>();	
	
	
	
	@Override
  		public List<MenuMasterEntity> getMenu(){
			
			allMenu = repo.findAll();
									
			List<MenuMasterEntity> menuList = new ArrayList<>();
		
				for(int i=0;i<allMenu.size();i++) {
					if(allMenu.get(i).getParentid()==0) {
						parent.add(allMenu.get(i));
						//parMenu.add(allMenu.get(i).getDescription());
				}
			}
								
			for(int i=0 ;i<parent.size();i++) {
				int catId = parent.get(i).getCategoryid();			
				menu.add(parent.get(i));
				//System.out.println("cateID" +catId);
				temp.put(parent.get(i),"");
				createMenu(catId);				
			}
				
		
			System.out.println("All Parents : "+parent);
			System.out.println("ParMenu :"+parMenu);
 			
			System.out.println("MenuList :"+menuList);
 			System.out.println("Menu :"+menu);
 			
 			
 			System.out.println("Output  "+output);
 			System.out.println("TEMP  "+temp);
 			
 			System.out.println("MP :"+mp );
 			System.out.println("MAP :"+map);
 			
			return menu;
  			
		}
	
	
  			public void createMenu(int cateId) {  				 							
  				List<MenuMasterEntity> parList = new ArrayList<MenuMasterEntity>();			
  				
					for(int y=0;y<allMenu.size();y++) {
						
						if(allMenu.get(y).getParentid()==cateId) {
							System.out.println("trck "+allMenu.get(y).getParentid());
							parList.add(allMenu.get(y));
							parMenu.add(allMenu.get(y).getDescription());	
							System.out.println("aaaaaaaaaaaa :"+parList);							
						}					
					}
					
  				
				if(parList.size()==0) {
					return;
				}

				menu.addAll(parList);
				
				for(int k=0;k<parList.size();k++) {					
					int curent = parList.get(k).getCategoryid();					
					createMenu(curent);
				}
			}


			@Override
			public List<MenuMasterEntity> getMenu(List<Integer> ids) {
				repo.deleteIn(ids);
				return null;
			}


			@Override
			public ResponseEntity<?> getMenuAll() {
				
				List<MenuMasterEntity> ent = repo.findAll();			
				
				return new ResponseEntity<Object> (ent,new HttpHeaders(),HttpStatus.OK) ;
			}


			@Override
			public ResponseEntity<?> addMenu(MenuMasterEntity menu) {
				repo.save(menu);
				return new ResponseEntity<String>("Added",new HttpHeaders(),HttpStatus.OK) ;			}
  	
		
}
