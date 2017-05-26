package com.zh.cn.trio.aop.utils.base.validation;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.base.validation.bean.IValidationResult;

public interface Validation {

	IValidationResult validationData(Format format, Object formatBean, String[] expression, String[] errorExpression,
			String[] errorCode);

}
