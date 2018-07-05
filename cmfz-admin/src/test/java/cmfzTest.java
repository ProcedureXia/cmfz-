import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yx on 2018/7/4.
 */
public class cmfzTest {
    public static void main(String[] args) {
        System.out.println("zxcvbnmm");
    }

    @Test
    public void test1(){
     ApplicationContext applicationContext =  new  ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService = (ManagerService) applicationContext.getBean("managerServiceImpl");

    }
}

