package br.com.arthurhenriqu3.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.enums.StatusEnum;

@Component
public class StatusConverter implements Converter<String, StatusEnum>{

	@Override
	public StatusEnum convert(final String source) {
		return StatusEnum.findByValue(source);
	}
}