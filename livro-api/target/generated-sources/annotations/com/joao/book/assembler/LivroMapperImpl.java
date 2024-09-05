package com.joao.book.assembler;

import com.joao.book.model.LivroEntity;
import com.joao.book.model.LivroResource;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-05T10:46:02-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class LivroMapperImpl implements LivroMapper {

    @Override
    public LivroResource toResource(LivroEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LivroResource livroResource = new LivroResource();

        livroResource.setAnoPublicacao( entity.getAnoPublicacao() );
        livroResource.setAutor( entity.getAutor() );
        livroResource.setIsbn( entity.getIsbn() );
        livroResource.setTitulo( entity.getTitulo() );

        return livroResource;
    }

    @Override
    public LivroEntity toEntity(LivroResource livroDtoResource) {
        if ( livroDtoResource == null ) {
            return null;
        }

        LivroEntity livroEntity = new LivroEntity();

        livroEntity.setAnoPublicacao( livroDtoResource.getAnoPublicacao() );
        livroEntity.setAutor( livroDtoResource.getAutor() );
        livroEntity.setIsbn( livroDtoResource.getIsbn() );
        livroEntity.setTitulo( livroDtoResource.getTitulo() );

        return livroEntity;
    }
}
