package io.github.zh.cn.trio.aop.config.abs.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.config.abs.context.AbsContext;
import io.github.zh.cn.trio.aop.config.abs.model.AbsBeanModel;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.croe.strategy.AopStrategy;

@Component
public class SimpleContextStrategy implements AopStrategy {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void operAop(AopUtilContext aopUtilContext, String targetTime) {
		AbsContext absContext = (AbsContext) aopUtilContext;
		AbsBeanModel absBeanModel = absContext.getBeanModel();
		if (AopUtilContext.TIME_BEFORE.equals(targetTime)) {
			absBeanModel.beforeAop(absContext);
		} else if (AopUtilContext.TIME_AFTER.equals(targetTime)) {
			absBeanModel.afertAop(absContext);
		} else if (AopUtilContext.TIME_ERROR.equals(targetTime)) {
			absBeanModel.errorAop(absContext);
		} else {
			logger.error("operAop has not time to target ");
		}
	}

}
