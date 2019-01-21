package live.leer.spring.demo2;

public class CustomerDAOImpl implements CustomerDAO {

	public void setup() {
		System.out.println("CustomerDAOImpl初始化");
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("CustomerDAOImpl的save方法执行了");
	}
	
	public void destory() {
		System.out.println("CustomerDAOImpl销毁了");
	}
	
	 
}
