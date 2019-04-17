package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;

import java.util.List;

//定义area的增删改查方法
public interface AreaDao {
    /*
    * 列出区域列表
    *
    * @return arealist
    * */
    List<Area> queryArea();

    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
