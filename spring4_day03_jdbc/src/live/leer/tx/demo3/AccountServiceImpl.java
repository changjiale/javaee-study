package live.leer.tx.demo3;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {
    //注入DAO(xml方式注入)
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    /**
     * from 转出账号
     * to  转入账号
     * money 转账金额
     */
    @Override
    public void transfer(String from, String to, Double money) {
        // TODO Auto-generated method stub

        accountDao.outMoney(from, money);
        int i = 1 / 0;
        accountDao.inMoney(to, money);


    }

}
