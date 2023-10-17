package br.com.arthurhenriqu3.model.dto.mapper;

public interface DTOMapper<E, D> {

	public D toDTO(E e);

	public E toEntity(D d);
}