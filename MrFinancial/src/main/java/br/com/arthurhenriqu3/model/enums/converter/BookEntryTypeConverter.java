package br.com.arthurhenriqu3.model.enums.converter;

import java.util.Objects;

import br.com.arthurhenriqu3.model.enums.BookEntryTypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BookEntryTypeConverter implements AttributeConverter<BookEntryTypeEnum, Byte> {

	@Override
	public Byte convertToDatabaseColumn(BookEntryTypeEnum bookEntryTypeEnum) {
		if (Objects.isNull(bookEntryTypeEnum)) {
			return null;
		}

		return bookEntryTypeEnum.getCode();
	}

	@Override
	public BookEntryTypeEnum convertToEntityAttribute(Byte code) {
		if (Objects.isNull(code)) {
			return null;
		}

		return BookEntryTypeEnum.findByCode(code);
	}
}