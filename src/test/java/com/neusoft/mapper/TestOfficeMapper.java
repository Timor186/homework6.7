package com.neusoft.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neusoft.po.Doctor;
import com.neusoft.po.Office;


public class TestOfficeMapper {
    private SqlSession sqlSession;
    private OfficeMapper officeMapper;
    @Before
    public void initConfig() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        officeMapper = sqlSession.getMapper(OfficeMapper.class);
        System.out.println("初始化MyBatis配置资源");
    }
    @Test
    public void testGetAllOffice(){
        List<Office> list = officeMapper.getAllOffice();
        for(Office office : list){
            System.out.println("职能："+office.getOffice()+":"+office.getOfficeinfo());
            List<Doctor> doctors = office.getDoctors();
            for(Doctor d:doctors){
                System.out.println("包含医师："+d.getName()+":"+d.getId());
            }
            System.out.println("----------------------------------");
        }
    }
    @After
    public void closeConfig(){
        sqlSession.close();
        System.out.println("关闭数据库");
    }
}
