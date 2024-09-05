package com.joao.book.assembler;

import org.mapstruct.Mapper;

import com.joao.book.model.LivroEntity;
import com.joao.book.model.LivroResource;

@Mapper(componentModel = "spring")	
public interface LivroMapper {
	
	LivroResource toResource(LivroEntity entity);
	
	LivroEntity toEntity(LivroResource livroDtoResource);
}
