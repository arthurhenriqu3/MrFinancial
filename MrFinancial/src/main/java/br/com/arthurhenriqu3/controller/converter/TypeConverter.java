package br.com.arthurhenriqu3.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.enums.TypeEnum;

@Component
public class TypeConverter implements Converter<String, TypeEnum>{

	@Override
	public TypeEnum convert(final String source) {
		return TypeEnum.findByValue(source);
	}
}