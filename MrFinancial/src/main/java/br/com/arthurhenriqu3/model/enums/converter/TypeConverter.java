package br.com.arthurhenriqu3.model.enums.converter;

import java.util.Objects;

import br.com.arthurhenriqu3.model.enums.TypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeConverter implements AttributeConverter<TypeEnum, Byte> {

	@Override
	public Byte convertToDatabaseColumn(TypeEnum bookEntryTypeEnum) {
		if (Objects.isNull(bookEntryTypeEnum)) {
			return null;
		}

		return bookEntryTypeEnum.getCode();
	}

	@Override
	public TypeEnum convertToEntityAttribute(Byte code) {
		if (Objects.isNull(code)) {
			return null;
		}

		return TypeEnum.findByCode(code);
	}
}