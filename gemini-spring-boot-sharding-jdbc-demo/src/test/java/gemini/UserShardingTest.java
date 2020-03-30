package gemini;

import com.gemini.SpringBootShardingJdbcDemoApplication;
import com.gemini.entity.User;
import com.gemini.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 演示取模的分库分表策略
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootShardingJdbcDemoApplication.class)
@MapperScan(basePackages = "com.gemini.mapper")
public class UserShardingTest {
	@Autowired
	UserService userService;

	@Test
	public void insert(){


		for(int i=1;i<101;i++) {
			User user = new User();
			user.setId(i);
			user.setUsername("test_"+(i));
			user.setPassword("1234587");
			long resutl=   userService.addUser(user);
			System.out.println("------done:");
		}
	}

	@Test
	public void select(){
		List<User> userInfo1= userService.list();
		System.out.println("------userInfo1:"+userInfo1);

	}

}
