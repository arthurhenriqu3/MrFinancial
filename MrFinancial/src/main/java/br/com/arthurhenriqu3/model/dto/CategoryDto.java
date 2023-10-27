package br.com.arthurhenriqu3.model.dto;

import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CategoryDto {
	private UUID id;
	private CategoryDto parent;
	private @NotBlank @NotEmpty @NotNull @Length(max = 50) String name;
	private String description;
	private String image;
	private @NotNull StatusEnum status;
	private @NotNull TypeEnum type;
	private List<CategoryDto> children;

	public CategoryDto(Category category) {
		this.id = category.getId();
		this.parent = new CategoryDto(category.getParent());
		this.name = category.getName();
		this.description = category.getDescription();
		this.image = category.getImage();
		this.status = category.getStatus();
		this.type = category.getType();
	}

	public CategoryDto(UUID id, CategoryDto parent, @NotBlank @NotEmpty @NotNull @Length(max = 50) String name,
			String description, String image, @NotNull StatusEnum status, @NotNull TypeEnum type) {
		super();
		this.id = id;
		this.parent = parent;
		this.name = name;
		this.description = description;
		this.image = image;
		this.status = status;
		this.type = type;
	}

	public UUID getId() {
		return id;
	}

	public CategoryDto getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public TypeEnum getType() {
		return type;
	}

	public List<CategoryDto> getChildren() {
		return children;
	}

}
