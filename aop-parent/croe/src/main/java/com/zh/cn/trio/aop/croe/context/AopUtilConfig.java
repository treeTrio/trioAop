package com.zh.cn.trio.aop.croe.context;

import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.croe.strategy.AopStrategy;

/**
 * 抽象父类配置
 * 
 * @param <T>
 */
public abstract class AopUtilConfig<T extends AopUtilConfig<T>> {

	/**
	 * 触发时间--前置触发
	 */
	public static final String TIME_BEFORE = "BEFORE";
	/**
	 * 触发时间--后置触发
	 */
	public static final String TIME_AFTER = "AFTER";
	/**
	 * 触发时间--异常触发
	 */
	public static final String TIME_ERROR = "ERROR";

	public static final String TIME_AROUND_STARAT = "AROUND_SATART";
	public static final String TIME_AROUND_END = "AROUND_END";

	/**
	 * 触发时间
	 */
	private String[] targetTimes;

	/**
	 * 策略
	 */
	private AopStrategy<T> aopStrategy;

	public boolean checkEnable(String time) {
		if (targetTimes == null || StringUtils.isEmpty(time)) {
			return false;
		}
		for (String string : targetTimes) {
			if (time.equals(string)) {
				return true;
			}
		}
		return false;
	}

	public String[] getTargetTimes() {
		return targetTimes;
	}

	public void setTargetTimes(String[] targetTimes) {
		this.targetTimes = targetTimes;
	}

	public AopStrategy<T> getAopStrategy() {
		return aopStrategy;
	}

	public void setAopStrategy(AopStrategy<T> aopStrategy) {
		this.aopStrategy = aopStrategy;
	}

}
