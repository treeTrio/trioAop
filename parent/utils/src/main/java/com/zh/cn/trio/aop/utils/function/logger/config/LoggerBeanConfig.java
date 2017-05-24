package com.zh.cn.trio.aop.utils.function.logger.config;

import java.util.Map;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;
import com.zh.cn.trio.aop.utils.function.logger.LoggerFace;

public class LoggerBeanConfig extends AopUtilConfig<LoggerBeanConfig> {

	public static final String LEVEL_INFO = "INFO";
	public static final String LEVEL_ERROR = "ERROR";
	public static final String LEVEL_DEBUG = "DEBUG";
	public static final String LEVEL_WARN = "WARN";

	private LoggerFace loggerFace;

	/** time->levels->name */
	private Map<String, Map<String, String>> config;

	public Map<String, Map<String, String>> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Map<String, String>> config) {
		this.config = config;
	}

	public LoggerFace getLoggerFace() {
		return loggerFace;
	}

	public void setLoggerFace(LoggerFace loggerFace) {
		this.loggerFace = loggerFace;
	}

}
