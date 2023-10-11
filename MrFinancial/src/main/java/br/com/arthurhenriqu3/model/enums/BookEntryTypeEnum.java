/**
 * 
 * TRATAR EXCEÇÃO!!!
 * LINHA 31 E 38
 * 
 */
package br.com.arthurhenriqu3.model.enums;

import java.util.stream.Stream;

public enum BookEntryTypeEnum {

	EXPENSE("Expense", (byte) 0), REVENUE("Revenue", (byte) 1);

	private String value;
	private Byte code;

	private BookEntryTypeEnum(String value, Byte code) {
		this.value = value;
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public Byte getCode() {
		return code;
	}

	public static BookEntryTypeEnum findByValue(String value) {
		return Stream.of(values()).filter(e -> e.getValue().equals(value)).findFirst()
				.orElseThrow(RuntimeException::new);
	}

	public static BookEntryTypeEnum findByCode(Byte code) {
		return Stream.of(values()).filter(e -> e.getCode().equals(code)).findFirst()
				.orElseThrow(RuntimeException::new);
	}

	@Override
	public String toString() {
		return this.value;
	}
}