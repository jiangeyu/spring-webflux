import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:34 2019/11/29
 */
@MapperScan(basePackages =  " transaction.dao", annotationClass = Repository.class)
@SpringBootApplication(scanBasePackages = "transaction")
public class TransactionApplication {


    @Autowired
    PlatformTransactionManager transactionManager = null;

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
        short s = 1;
        s= (short) (s+1);
        System.out.println(s);

    }


    @PostConstruct
    public void viewTransactionManager() {
        System.out.println(transactionManager.getClass().getName());
    }

}
