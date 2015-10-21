package com.globalroam.iaas.hoverV.test;

import com.globalroam.iaas.hoverv.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/conf/core-config.xml")
public class ContentServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserDao userDao;

	@Test
	 public void test() {
		//System.out.println(userDao.getRoleInfo(1));
		System.out.println(userDao.count());
	}
}
