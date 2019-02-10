package live.leer.mybatis.pojo;

import java.util.List;

/**
 * 包装的pojo
 * @author leer
 *
 */
public class QueryVo {
	//用户对象
		private User user;
		private List<Integer> ids;
		
		public List<Integer> getIds() {
			return ids;
		}

		public void setIds(List<Integer> ids) {
			this.ids = ids;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

}
