package com.codatics.dto.parameter;

import com.codatics.common.domain.CommonDomain;

public class ParameterCategory extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2413326278770274910L;
	private String parameterType;
    private String categoryCode;
    private String categoryName;

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }   
}
