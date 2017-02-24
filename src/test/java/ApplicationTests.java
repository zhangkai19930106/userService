import com.bonc.Application;
import com.bonc.Entity.User;
import com.bonc.Mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZK on 2017/2/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void insert() throws Exception{
        User user = new User();
        user.setUserName("ZK");
        user.setPassWord("123");
        user.setPhoneNum("18500486448");
        user.setRealName("张凯");
        user.setRealId("622301199301060375");
        user.setMailAddr("zhangkai1@bonc.com.cn");
        //user.setProId("011");
        //user.setAreaId("05");
        userMapper.insert(user);
    }

}
