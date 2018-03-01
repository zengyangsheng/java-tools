import com.zeng.utils.data.ListUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangsheng.zeng
 * @date 2018/3/1 16:29
 */
public class MainTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUserName("zeng");
        list.add(user1);

        User user2 = new User();
        user2.setUserId(2L);
        user2.setUserName("yang");
        list.add(user2);
        List<String> nameList = ListUtils.selectValues(list, "userName");
        System.out.println(nameList);
    }

}
