package com.shen.threelevellinkage.service;

import com.shen.threelevellinkage.dao.AreaDao;
import com.shen.threelevellinkage.entity.CityEntity;
import com.shen.threelevellinkage.entity.DistrictEntity;
import com.shen.threelevellinkage.entity.ProvinceEntity;

import java.util.List;

public class AreaService{

/**
 * 加载所有省
 * @return
 * @throws Exception
 */
public List<ProvinceEntity> loadAllProvince()throws  Exception{
  AreaDao dao=new AreaDao();
    return dao.selectAll();
  };

/**
 * 加载指定省下的所有市
 * @param code
 * @return
 * @throws Exception
 */
public List<CityEntity> loadCitys(String code)throws Exception{
  if(code==null)throw new IllegalArgumentException("非法参数");
  AreaDao dao=new AreaDao();
  return dao.selectCitys(code);

}

/**
 * 加載指定市下的所有区
 * @param code
 * @return
 * @throws Exception
 */
public List<DistrictEntity> loadDistricts(String code)throws Exception{
  if(code==null)throw new IllegalArgumentException("非法参数");
  AreaDao dao=new AreaDao();
  return dao.selectDistricts(code);
}
}
