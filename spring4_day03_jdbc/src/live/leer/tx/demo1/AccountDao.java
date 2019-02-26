package live.leer.tx.demo1;

/**
 * 转账DAO的接口
 *
 * @author leer
 */
public interface AccountDao {
    public void outMoney(String from, Double money);

    public void inMoney(String to, Double money);
}
