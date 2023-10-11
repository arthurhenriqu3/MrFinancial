package br.com.arthurhenriqu3.model.enums.converter;

import java.util.Objects;

import br.com.arthurhenriqu3.model.enums.StatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<StatusEnum, Byte> {

	@Override
	public Byte convertToDatabaseColumn(StatusEnum statusEnum) {
		if (Objects.isNull(statusEnum)) {
			return null;
		}

		return statusEnum.getCode();
	}

	@Override
	public StatusEnum convertToEntityAttribute(Byte code) {
		if (Objects.isNull(code)) {
			return null;
		}

		return StatusEnum.findByCode(code);
	}
}