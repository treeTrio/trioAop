package com.zh.cn.trio.aop.utils.function.cache.model;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

public abstract class AbstractCacheModel implements CacheModel {

	@Override
	public void execBefore(AopUtilContext<CacheBeanConfig> aopUtilContext) {

	}

	@Override
	public void execAfter(AopUtilContext<CacheBeanConfig> aopUtilContext) {

	}

	/**
	 * 读缓存结果
	 */
	protected void getCacheResult(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		CacheFace cacheFace = aopUtilContext.getAopUtilConfig().getCacheFace();
		boolean hasCache = cacheFace.hasCache(aopUtilContext);
		if (hasCache) {
			aopUtilContext.setResultObject(cacheFace.getCache(aopUtilContext));
		}
	}

}
