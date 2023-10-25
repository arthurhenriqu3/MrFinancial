package br.com.arthurhenriqu3.model.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.dto.BookEntryDTO;

public class BookEntryDTOMapper implements DTOMapper<BookEntry, BookEntryDTO> {

	@Autowired
	private CategoryDTOMapper categoryDTOMapper;

	@Autowired
	private WalletDTOMapper walletDTOMapper;

	@Override
	public BookEntryDTO toDTO(BookEntry bookEntry) {
		return new BookEntryDTO(categoryDTOMapper.toDTO(bookEntry.getCategory()),
				walletDTOMapper.toDTO(bookEntry.getWallet()), bookEntry.getName(), bookEntry.getDescription(),
				bookEntry.getValue(), bookEntry.getDate(), bookEntry.getStatus());
	}

	@Override
	public BookEntry toEntity(BookEntryDTO bookEntryDTO) {
		return new BookEntry(categoryDTOMapper.toEntity(bookEntryDTO.categoryDto()),
				walletDTOMapper.toEntity(bookEntryDTO.walletDto()), bookEntryDTO.name(), bookEntryDTO.description(),
				bookEntryDTO.value(), bookEntryDTO.date(), bookEntryDTO.status());
	}
}