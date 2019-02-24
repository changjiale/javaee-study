package live.leer.springmvc.exception;

/**
 * 自定义异常
 * @author leer
 *
 */
public class MyException extends Exception {

	private String msg;

	
	
	public MyException() {
		super();
	}

	public MyException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
