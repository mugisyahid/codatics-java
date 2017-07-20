package com.codatics.dto.parameter;

import com.codatics.common.domain.CommonDomain;

public class ParameterMappingCategory extends CommonDomain {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8451127780592007152L;
	private ParameterMappingType mappingType;
    private ParameterCategory sourceCategory;

    private String categoryCode;
    private String categoryName;
    private String entityName;
    private String fieldParameterCode;
    private String fieldDescription;

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

    public ParameterMappingType getMappingType() {
        return mappingType;
    }

    public void setMappingType(ParameterMappingType mappingType) {
        this.mappingType = mappingType;
    }

    public ParameterCategory getSourceCategory() {
        return sourceCategory;
    }

    public void setSourceCategory(ParameterCategory sourceCategory) {
        this.sourceCategory = sourceCategory;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFieldParameterCode() {
        return fieldParameterCode;
    }

    public void setFieldParameterCode(String fieldParameterCode) {
        this.fieldParameterCode = fieldParameterCode;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }
}
