package com.crs.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<MenuMasterEntity, Long>{

	
	@Query(value="select * from menu_list where pareid=0",nativeQuery=true)
	public List<MenuMasterEntity> menuByParIdZero();
	
	@Query(value="select * from menu_list where pareid=?1",nativeQuery=true)
	public MenuMasterEntity findSubMenu(int pareid);
	
	@Query(value="select * from menu_list where pareid=?1",nativeQuery=true)
	public MenuMasterEntity findSubMenus(int pareid);
	
	@Query(value="select * from menu_list where catid=?1",nativeQuery = true)
	public List<MenuMasterEntity> findByZero(int cateid);

	@Query(value="delete from menu_list where catid in ?1",nativeQuery = true)
	public void deleteIn(List<Integer> ids);

	
}
