package io.github.zh.cn.trio.aop.function.cache.context;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.function.cache.model.AbstractCacheModel;

/**
 * 
 * 缓存配置
 *
 */
public class CacheBeanContext extends AopUtilContext {

	/**
	 * @return 缓存时间
	 */
	private int cacheTime;

	/**
	 * @return 缓存模式
	 */
	private AbstractCacheModel cacheModel;

	/**
	 * @return 缓存建 模板字符
	 */
	private String keyModelString;

	public int getCacheTime() {
		return cacheTime;
	}

	public void setCacheTime(int cacheTime) {
		this.cacheTime = cacheTime;
	}

	public AbstractCacheModel getCacheModel() {
		return cacheModel;
	}

	public void setCacheModel(AbstractCacheModel cacheModel) {
		this.cacheModel = cacheModel;
	}

	public String getKeyModelString() {
		return keyModelString;
	}

	public void setKeyModelString(String keyModelString) {
		this.keyModelString = keyModelString;
	}

}
