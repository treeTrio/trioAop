package io.github.zh.cn.trio.aop.dynamic.aspect;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.dynamic.context.DynamicContext;

public class TrioDynamicXmlAspect extends AbstractAopAspect<DynamicContext> {

	@Override
	public DynamicContext initContext(MethodInvocationProceedingJoinPoint methodInvocationProceedingJoinPoint) {
		return null;
	}

}
