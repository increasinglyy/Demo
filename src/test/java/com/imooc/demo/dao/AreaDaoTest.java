package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testAQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        // 验证预期值和实际值是否相符
        assertEquals(3, areaList.size());
    }
    @Test
    public void queryById(){
        Area area = areaDao.queryAreaById(1);
        assertEquals("北苑",area.getAreaName());
    }
    @Test
    @Ignore
    public void insertArea(){
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        //检验影响行数是否为1
        assertEquals(1, effectedNum);
    }
    @Test
    public void updataArea(){
        Area area = new Area();
        area.setAreaName("西苑");
        area.setAreaId(12);
        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1, effectedNum);
    }
    @Test
    public void deleteArea(){
        int effectedNum = areaDao.deleteArea(12);
        assertEquals(1,effectedNum);
    }
}