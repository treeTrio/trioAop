package io.github.zh.cn.trio.aop.function.cache.context;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.function.cache.model.CacheModel;

public class CacheConfig extends RunTimeConfig{
	/**
	 * @return 缓存时间
	 */
	private int cacheTime;

	/**
	 * @return 缓存模式
	 */
	private CacheModel cacheModel;

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

	public CacheModel getCacheModel() {
		return cacheModel;
	}

	public void setCacheModel(CacheModel cacheModel) {
		this.cacheModel = cacheModel;
	}

	public String getKeyModelString() {
		return keyModelString;
	}

	public void setKeyModelString(String keyModelString) {
		this.keyModelString = keyModelString;
	}
}
