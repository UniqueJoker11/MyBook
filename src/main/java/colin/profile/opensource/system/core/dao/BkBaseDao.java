package colin.profile.opensource.system.core.dao;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.spring.SpringBeetlSql;
import org.springframework.beans.factory.annotation.Autowired;

public class BkBaseDao {

	@Autowired
	private SpringBeetlSql beetlSql;
	// beetlSql管理类，类似于Spring jdbcTemplate
	private SQLManager sqlManager = null;

	/**
	 * 
	 * 方法描述：单例创建sqlManager   
	 * 注意事项：    
	 * @return 
	 * @Exception 异常对象
	 */
	protected SQLManager initSqlManager() {
		if (sqlManager == null) {
			sqlManager = beetlSql.getSQLMananger();
		}
		return sqlManager;
	}
}
