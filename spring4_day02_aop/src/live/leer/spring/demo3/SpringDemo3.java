package live.leer.spring.demo3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AOP入门
 *
 * @author leer
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDemo3 {

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Test
    public void demo1() {
        productDao.save();
        productDao.update();
        productDao.find();
        productDao.delete();
    }
}
