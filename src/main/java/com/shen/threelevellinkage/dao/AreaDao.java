package com.shen.threelevellinkage.dao;

import com.shen.threelevellinkage.entity.CityEntity;
import com.shen.threelevellinkage.entity.DistrictEntity;
import com.shen.threelevellinkage.entity.ProvinceEntity;
import com.shen.threelevellinkage.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class AreaDao{
  /**
   * 加载所有省份
   */
public List<ProvinceEntity> selectAll() throws SQLException{
  try(
          Connection c= DBUtil.getConnection();
          ){
    StringBuilder sql=new StringBuilder();
    sql.append("select code,name from dic_area where parentCode is null");
    PreparedStatement ps=c.prepareStatement(sql.toString());
    ResultSet rs=ps.executeQuery();
    List<ProvinceEntity> result=new LinkedList<>();
    while(rs.next()){
      result.add(row2ProviceEntity(rs));
    }
    return result;
  }
} /**
   * 加载所有市区
   */
public List<CityEntity> selectCitys(String pcode) throws SQLException{
  try(Connection c=DBUtil.getConnection();){
    StringBuilder sql=new StringBuilder();
    sql.append("select code,name from dic_area where parentCode=?");
    PreparedStatement ps=c.prepareStatement(sql.toString());
    ps.setString(1, pcode);
    ResultSet rs=ps.executeQuery();
    List<CityEntity> result=new LinkedList<>();
    while(rs.next()){
      result.add(row2CityEntity(rs));
    }
    return result;
  }
}

public List<DistrictEntity> selectDistricts(String code) throws SQLException{
  try(Connection c=DBUtil.getConnection();){
    StringBuilder sql=new StringBuilder();
    sql.append("select code,name from dic_area where parentCode=?");
    PreparedStatement ps=c.prepareStatement(sql.toString());
    ps.setString(1, code);
    ResultSet rs=ps.executeQuery();
    List<DistrictEntity> result=new LinkedList<>();
    while(rs.next()){
      result.add(row2DistrictEntity(rs));
    }
    return result;
  }
}
private ProvinceEntity row2ProviceEntity(ResultSet rs) throws SQLException{
  ProvinceEntity e=new ProvinceEntity();
  e.setCode(rs.getString("code"));
  e.setName(rs.getString("name"));
  return e;
}

private CityEntity row2CityEntity(ResultSet rs) throws SQLException{
  CityEntity e=new CityEntity();
  e.setCode(rs.getString("code"));
  e.setName(rs.getString("name"));
  return e;
}
private DistrictEntity row2DistrictEntity(ResultSet rs) throws SQLException{
  DistrictEntity e=new DistrictEntity();
  e.setCode(rs.getString("code"));
  e.setName(rs.getString("name"));
  return e;
   }
}
