package br.com.arthurhenriqu3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.model.enums.converter.StatusConverter;
import br.com.arthurhenriqu3.model.enums.converter.TypeConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_category", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "category_id",
		"type" }, name = "category_name_and_parent_and_type_unique") })
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = true)
	private Category parent;

	@NotBlank
	@NotEmpty
	@NotNull
	@Length(max = 50)
	@Column(nullable = false, length = 50)
	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column
	private String image;

	@NotNull
	@Column(nullable = false)
	@Convert(converter = TypeConverter.class)
	private TypeEnum type;

	@NotNull
	@Column(nullable = false)
	@Convert(converter = StatusConverter.class)
	private StatusEnum status;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Category> children;
	
	public Category() {
		this.type = TypeEnum.DESPESA;
		this.status = StatusEnum.INATIVO;
		this.children = new ArrayList<Category>();
	}

	public Category(UUID id, Category parent, String name, String description, String image, StatusEnum status, TypeEnum type,
			List<Category> children) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.parent = parent;
		this.status = status;
		this.type = type;
		this.children = children;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren(List<Category> children) {
		this.children = children;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent=[" + this.parent + "]]";
	}
}