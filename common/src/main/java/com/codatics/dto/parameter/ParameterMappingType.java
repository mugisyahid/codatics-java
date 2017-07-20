package com.codatics.dto.parameter;

import com.codatics.common.domain.CommonDomain;

public class ParameterMappingType extends CommonDomain {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6861861256447769593L;
	private String typeCode;
    private String typeName;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
