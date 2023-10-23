/**
 * 
 * TRATAR EXCEÇÃO!!!
 * LINHA 31 e 38
 * 
 */
package br.com.arthurhenriqu3.model.enums;

import java.util.stream.Stream;

public enum StatusEnum {

	INATIVO("INATIVO", (byte) 0), ATIVO("ATIVO", (byte) 1);

	private String value;
	private Byte code;

	private StatusEnum(String value, Byte code) {
		this.value = value;
		this.code = code;
	}

	public String getValue() {
		return this.value;
	}

	public Byte getCode() {
		return this.code;
	}

	public static StatusEnum findByValue(String value) {
		return Stream.of(values()).filter(e -> e.getValue().equals(value)).findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public static StatusEnum findByCode(Byte code) {
		return Stream.of(values()).filter(e -> e.getCode().equals(code)).findFirst()
				.orElseThrow(RuntimeException::new);
	}

	@Override
	public String toString() {
		return this.value;
	}
}