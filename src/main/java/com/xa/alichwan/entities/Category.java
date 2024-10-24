package com.xa.alichwan.entities;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "categories")
@NoArgsConstructor
public class Category extends BaseEntity {

    public Category(String name, String slug, String description, boolean isDeleted){
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.isDeleted = isDeleted;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "name", length = 50, unique = true)
    private String name;

    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "slug", length = 50, unique = true)
    private String slug;

    @NotBlank
    @NotNull
    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "is_Deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
    
}