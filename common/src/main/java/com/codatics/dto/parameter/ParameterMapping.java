package com.codatics.dto.parameter;

import com.codatics.common.domain.CommonDomain;
import com.codatics.common.state.ActiveStatus;

public class ParameterMapping extends CommonDomain {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4352248101017389406L;
	private ParameterMappingCategory category;
    private Parameter source;
    private Integer entityId;
    
    private String mappingCode;
    private String mappingValue;
    private String description;
    
    private ActiveStatus status;

    public ParameterMappingCategory getCategory() {
        return category;
    }

    public void setCategory(ParameterMappingCategory category) {
        this.category = category;
    }

    public Parameter getSource() {
        return source;
    }

    public void setSource(Parameter source) {
        this.source = source;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getMappingCode() {
        return mappingCode;
    }

    public void setMappingCode(String mappingCode) {
        this.mappingCode = mappingCode;
    }
    
    public String getMappingValue() {
        return mappingValue;
    }

    public void setMappingValue(String mappingValue) {
        this.mappingValue = mappingValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActiveStatus getStatus() {
        return status;
    }

    public void setStatus(ActiveStatus status) {
        this.status = status;
    }
    
    
}
