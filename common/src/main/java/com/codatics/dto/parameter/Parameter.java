package com.codatics.dto.parameter;

import com.codatics.common.domain.CommonDomain;
import com.codatics.common.enumerate.ParameterDataType;
import com.codatics.common.state.ActiveStatus;

public class Parameter extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6113799846926938107L;
	private String parameterCode;
    private String description;
    private String parameterValue;
    
    private ParameterCategory category;
    private ParameterDataType dataType;
    
    private ActiveStatus status;
    
    public String getParameterCode() {
        return parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String value) {
        this.parameterValue = value;
    }

    public ParameterCategory getCategory() {
        return category;
    }

    public void setCategory(ParameterCategory category) {
        this.category = category;
    }

    public ParameterDataType getDataType() {
        return dataType;
    }

    public void setDataType(ParameterDataType dataType) {
        this.dataType = dataType;
    }

    public ActiveStatus getStatus() {
        return status;
    }

    public void setStatus(ActiveStatus status) {
        this.status = status;
    }
}
