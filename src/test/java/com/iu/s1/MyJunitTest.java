package com.iu.s1;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
/* 서버 작동 전에 test 하려는데 appServlet에 있는 파일들은 서버가 작동해야 사용할 수 있다.
 * 이를 도와주는 것이 ContextConfiguration임.
 */
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class MyJunitTest {

}
