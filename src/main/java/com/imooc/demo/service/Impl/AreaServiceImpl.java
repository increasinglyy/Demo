package com.imooc.demo.service.Impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

//告诉spring容器，它也是其中一个bean
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    //事务的控制
    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())){
            //设置默认值
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            //插入操作
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败："+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && !"".equals(area.getAreaId())){
            //设置默认值
            area.setLastEditTime(new Date());
            //更新操作
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败："+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0){
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败："+e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }
}
