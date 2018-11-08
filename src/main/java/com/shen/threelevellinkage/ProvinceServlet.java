package com.shen.threelevellinkage;


import com.shen.threelevellinkage.entity.ProvinceEntity;
import com.shen.threelevellinkage.service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 省份
 */
public class ProvinceServlet extends HttpServlet{
AreaService service=new AreaService();

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
  try{
    List<ProvinceEntity> ps=service.loadAllProvince();
    String respString=toJSON(ps);
    resp.setCharacterEncoding("utf-8");
    resp.setContentType("application/json");
    PrintWriter out=resp.getWriter();
    out.print(respString);
    out.close();
  }catch(Exception e){
    e.printStackTrace();
  }
}
private String toJSON(List<ProvinceEntity> list){
  StringBuilder json=new StringBuilder();
  json.append("[");
  for(ProvinceEntity p:list){
    json.append(p.toJsonString());
    json.append(",");
  }
  json.setCharAt(json.length()-1,']');
  return json.toString();
}
}
