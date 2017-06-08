package io.github.zh.cn.trio.aop.logger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;
import io.github.zh.cn.trio.aop.croe.utils.BeanUtils;
import io.github.zh.cn.trio.aop.logger.annotation.TrioLogger;
import io.github.zh.cn.trio.aop.logger.context.LoggerBeanContext;
import io.github.zh.cn.trio.aop.logger.face.AbstarctLoggerFace;
import io.github.zh.cn.trio.aop.plug.format.Format;

@Aspect
public class TrioLoggerAnnotationAspect extends AbstractAopAspect<LoggerBeanContext> {

	@Autowired
	private Format defaultFormat;

	@Autowired
	private AopStrategy defaultAopStrategy;
	
	@Autowired
	private AbstarctLoggerFace defaultAbstarctLoggerFace;


	private String defaultKeyModelString = "'method:'+getTargetMethod()+':args:'+getTargetArgs().toString()";

	
	public Format getDefaultFormat() {
		return defaultFormat;
	}

	public void setDefaultFormat(Format defaultFormat) {
		this.defaultFormat = defaultFormat;
	}

	public AopStrategy getDefaultAopStrategy() {
		return defaultAopStrategy;
	}

	public void setDefaultAopStrategy(AopStrategy defaultAopStrategy) {
		this.defaultAopStrategy = defaultAopStrategy;
	}

	public String getDefaultKeyModelString() {
		return defaultKeyModelString;
	}
	
	public void setDefaultKeyModelString(String defaultKeyModelString) {
		this.defaultKeyModelString = defaultKeyModelString;
	}
	
	@Around("@annotation(io.github.zh.cn.trio.aop.logger.annotation.TrioLogger)")
	public Object proxyAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		return super.proxy(proceedingJoinPoint);
	}


	@Override
	public LoggerBeanContext initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		LoggerBeanContext loggerBeanContext = new LoggerBeanContext();
		loggerBeanContext.setMethodInvocationProceedingJoinPoint(methodInvocationProceedingJoinPoint);
		loggerBeanContext.setApplicationContext(getApplicationContext());
		
		TrioLogger trioLogger = loggerBeanContext.getTargetMethod().getAnnotation(TrioLogger.class);
		AbstarctLoggerFace loggerFace = BeanUtils.getBean(getApplicationContext(), trioLogger.loggerFace(), AbstarctLoggerFace.class, defaultAbstarctLoggerFace);
		AopStrategy aopStrategy = BeanUtils.getBean(getApplicationContext(), trioLogger.aopStrategy(), AopStrategy.class, defaultAopStrategy);
		Format format = BeanUtils.getBean(getApplicationContext(), trioLogger.format(), Format.class, defaultFormat);
		
		loggerBeanContext.setLoggerFace(loggerFace);
		loggerBeanContext.setAopStrategy(aopStrategy);
		loggerBeanContext.setFormat(format);
		
		loggerBeanContext.setTargetTimes(new String[]{trioLogger.targetTime()});
		
		loggerBeanContext.setTimeToLevelMap(loggerBeanContext.initMap(loggerBeanContext.getTimeToLevelMap(), trioLogger.targetTime(),
				trioLogger.targetLevel()));

		String targetName = StringUtils.isEmpty(trioLogger.targetName())?loggerBeanContext.getTarget().getClass().getName():trioLogger.targetName();
		String modelString=StringUtils.isEmpty(trioLogger.modelString())?defaultKeyModelString:trioLogger.modelString();
		
		loggerBeanContext.setLevelToNameMap(loggerBeanContext.initMap(loggerBeanContext.getLevelToNameMap(), trioLogger.targetLevel(), targetName));
		
		loggerBeanContext.setNameToModelMap(loggerBeanContext.initMap(loggerBeanContext.getNameToModelMap(), targetName, modelString));
	
		
		
		return loggerBeanContext;
	}

}
