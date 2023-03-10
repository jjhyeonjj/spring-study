package kr.co.heart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.heart.dao.BoardDao;
import kr.co.heart.domain.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest2 {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void insertDummyDataTest() throws Exception {
		boardDao.deleteAll();
		
		for(int i=1; i<=250; i++) {
			BoardDto boardDto = 
					new BoardDto("재미있는 제목"+i, "재미있는 내용"+i, "ezen"); 
			boardDao.insert(boardDto);
		}
	}
}
