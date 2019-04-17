package com.imooc.demo.service.Impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {

    @Autowired
    private AreaService areaService;
    @Test
    public void getAreaList() {
        List<Area> areaList = areaService.getAreaList();
        assertEquals(2,areaList.size());
    }

    @Test
    public void getAreaById() {
        Area area = areaService.getAreaById(1);
        assertEquals("北苑", area.getAreaName());
    }

    @Test
    public void addArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        boolean effected = areaService.addArea(area);
        //检验影响行数是否为1
        assertEquals(true, effected);
    }

    @Test
    public void modifyArea() {
    }

    @Test
    public void deleteArea() {
    }
}