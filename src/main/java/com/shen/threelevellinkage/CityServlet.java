package com.shen.threelevellinkage;


import com.shen.threelevellinkage.entity.CityEntity;
import com.shen.threelevellinkage.service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 城市
 */
public class CityServlet extends HttpServlet{
AreaService service=new AreaService();

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
  try{
    String code=req.getParameter("code");
    List<CityEntity> ps=service.loadCitys(code);
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
private String toJSON(List<CityEntity> list){
  StringBuilder json=new StringBuilder();
  json.append("[");
  for(CityEntity p:list){
    json.append(p.toJsonString());
    json.append(",");
  }
  json.setCharAt(json.length()-1,']');
  return json.toString();
}
}
