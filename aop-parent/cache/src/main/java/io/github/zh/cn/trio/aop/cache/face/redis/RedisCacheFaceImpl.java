package io.github.zh.cn.trio.aop.cache.face.redis;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;
import io.github.zh.cn.trio.aop.cache.face.CacheFace;
import io.github.zh.cn.trio.aop.croe.base.format.utils.FormatConvertUtils;
import io.github.zh.cn.trio.aop.croe.base.redis.operaction.RedisStringOperation;
import io.github.zh.cn.trio.aop.croe.base.serialization.Serialization;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class RedisCacheFaceImpl implements CacheFace {

	private RedisStringOperation redisStringOperation;

	private Serialization serialization;

	public RedisStringOperation getRedisStringOperation() {
		return redisStringOperation;
	}

	public void setRedisStringOperation(RedisStringOperation redisStringOperation) {
		this.redisStringOperation = redisStringOperation;
	}

	public Serialization getSerialization() {
		return serialization;
	}

	public void setSerialization(Serialization serialization) {
		this.serialization = serialization;
	}

	@Override
	public boolean hasCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext),
				aopUtilContext.getAopUtilConfig().getKeyModelString());
		return redisStringOperation.exists(string);
	}

	@Override
	public Object getCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext),
				aopUtilContext.getAopUtilConfig().getKeyModelString());
		String val = redisStringOperation.get(string);
		Object object = serialization.forSerialization(val, aopUtilContext.getReturnClass());
		return object;
	}

	@Override
	public boolean setCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext),
				aopUtilContext.getAopUtilConfig().getKeyModelString());
		String val = serialization.serialization(aopUtilContext.getResultObject());
		redisStringOperation.expireat(string, val, aopUtilContext.getAopUtilConfig().getCacheTime());
		return true;
	}

	@Override
	public boolean removeCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext),
				aopUtilContext.getAopUtilConfig().getKeyModelString());
		redisStringOperation.del(string);
		return true;
	}

}
