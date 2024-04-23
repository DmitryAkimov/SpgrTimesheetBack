package org.akimoved.spgrtimesheetback.data.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanShortConverter implements AttributeConverter<Boolean, Short> {

	@Override
	public Short convertToDatabaseColumn(Boolean attribute) {
		if (attribute) {
			return (short) 1;
		} else {
			return (short) 0;
		}
	}

	@Override
	public Boolean convertToEntityAttribute(Short dbData) {
		if (dbData == null) return false;
		return dbData == 1 ? true : false;
	}
}
