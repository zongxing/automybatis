package com.mashensoft.automybatis.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mashensoft.automybatis.AutomybatisApplication;
import com.mashensoft.automybatis.model.User;
import com.mashensoft.automybatis.model.UserExample;
import com.mashensoft.automybatis.model.UserExample.Criteria;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AutomybatisApplication.class)
//@Transactional
public class UserMapperTest {
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void testCountByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByExample() {
		UserExample ue = new UserExample();
		Criteria c = ue.createCriteria();
		c.andIdEqualTo(21);
		userMapper.deleteByExample(ue);
	}
	@Test
	public void testDeleteByExampleIdcard() {
		UserExample ue = new UserExample();
		Criteria c = ue.createCriteria();
		c.andIdcardEqualTo("1111111");
		assertEquals(2,userMapper.deleteByExample(ue));
	}

	@Test
	public void testDeleteByPrimaryKey() {
		assertEquals(1,userMapper.deleteByPrimaryKey(20));
	}
	@Test
	public void testInsert() {
		User user = new User();
		user.setIdcard("1111111");
		user.setPassword("1111");
		user.setSex("男");
		user.setUsername("11111111");
		userMapper.insert(user);//所有列都会被插入，如果某列你没写，会插入null
		//userMapper.insertSelective(record);//写哪一列，就插入哪一列。动态sql
	}

	@Test
	public void testInsertSelective() {
		User user = new User();
		user.setIdcard("1111111");
		userMapper.insertSelective(user);//所有列都会被插入，如果某列你没写，会插入null
	}

	@Test
	public void testSelectByExample() {
		UserExample ue = new UserExample();
		ue.createCriteria().andIdEqualTo(15);
		assertEquals(1,userMapper.selectByExample(ue).size());
	}
	@Test
	public void testSelectByExampleUsername() {
		UserExample ue = new UserExample();
		ue.createCriteria().andUsernameEqualTo("kkkk");
		assertEquals(2,userMapper.selectByExample(ue).size());
	}
	@Test
	public void testSelectByExampleLikeUsername() {
		UserExample ue = new UserExample();
		ue.createCriteria().andUsernameLike("%x%");
		assertEquals(3,userMapper.selectByExample(ue).size());
	}
	@Test
	public void testSelectByExampleBetween() {
		UserExample ue = new UserExample();
		ue.createCriteria().andIdBetween(1,9);
		assertEquals(4,userMapper.selectByExample(ue).size());
	}
	@Test
	public void testSelectByExampleAnd() {
		UserExample ue = new UserExample();
		ue.createCriteria().andSexEqualTo("男").andIdcardEqualTo("2222222");
		assertEquals(2,userMapper.selectByExample(ue).size());
	}
	@Test
	public void testSelectByExampleOr() {
		UserExample ue = new UserExample();
		ue.createCriteria().andSexEqualTo("男");
		ue.or(ue.createCriteria().andIdcardEqualTo("2222222"));
		
		assertEquals(3,userMapper.selectByExample(ue).size());
	}

	@Test
	public void testSelectByPrimaryKey() {
		User user = userMapper.selectByPrimaryKey(15);
		
		assertEquals("1111111", user.getIdcard());
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		User user = new User();
		user.setIdcard("666");
		UserExample ue = new UserExample();
		ue.createCriteria().andPasswordEqualTo("123").andSexEqualTo("男");
		ue.or(ue.createCriteria().andUsernameEqualTo("kkkk"));
		
		
		userMapper.updateByExampleSelective(user, ue);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		User user = new User();
		user.setIdcard("1111111");
		user.setId(15);
		assertEquals(1,userMapper.updateByPrimaryKeySelective(user));
		
	}

	/**
	 * 
	 */
	@Test
	public void testUpdateByPrimaryKey() {
		User user = new User();
		user.setIdcard("1111111");
		user.setId(15);
		assertEquals(1,userMapper.updateByPrimaryKey(user));
		
	}

}
