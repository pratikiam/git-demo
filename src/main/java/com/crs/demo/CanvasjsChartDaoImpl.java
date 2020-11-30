package com.crs.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.crs.demo.CanvasjsChartData.DataPointModel;


@Service
@Transactional
public class CanvasjsChartDaoImpl implements CanvasjsChartService{

	@Override
	public List<List<DataPointModel>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}

}
