package live.leer.tx.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {
    //注入DAO(xml方式注入)
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //注入事务管理的模板
    private TransactionTemplate TransactionTemplate;


    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        TransactionTemplate = transactionTemplate;
    }


    /**
     * from 转出账号
     * to  转入账号
     * money 转账金额
     */
    @Override
    public void transfer(String from, String to, Double money) {
        // TODO Auto-generated method stub
        TransactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                // TODO Auto-generated method stub
                accountDao.outMoney(from, money);
                //int i = 1/0;
                accountDao.inMoney(to, money);
            }
        });


    }

}
