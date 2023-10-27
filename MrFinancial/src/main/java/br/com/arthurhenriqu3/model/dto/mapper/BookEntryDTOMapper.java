package br.com.arthurhenriqu3.model.dto.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.dto.BookEntryDto;

@Component
public class BookEntryDTOMapper implements DTOMapper<BookEntry, BookEntryDto> {

	@Autowired
	private CategoryDTOMapper categoryDTOMapper;

	@Autowired
	private WalletDTOMapper walletDTOMapper;

	@Override
	public BookEntryDto toDTO(BookEntry bookEntry) {
		return null;

//		return new BookEntryDto(bookEntry.getId(), categoryDTOMapper.toDTO(bookEntry.getCategory()),
//				walletDTOMapper.toDTO(bookEntry.getWallet()), bookEntry.getName(), bookEntry.getDescription(),
//				bookEntry.getValue(), bookEntry.getDate(), bookEntry.getStatus());
	}

	@Override
	public BookEntry toEntity(BookEntryDto bookEntryDTO) {
		return null;

		//		return new BookEntry(bookEntryDTO.id(), categoryDTOMapper.toEntity(bookEntryDTO.categoryDto()),
//				walletDTOMapper.toEntity(bookEntryDTO.walletDto()), bookEntryDTO.name(), bookEntryDTO.description(),
//				bookEntryDTO.value(), bookEntryDTO.date(), bookEntryDTO.status());
	}
}