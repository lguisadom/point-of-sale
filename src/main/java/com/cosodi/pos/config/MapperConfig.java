package com.cosodi.pos.config;

import com.cosodi.pos.dto.DocumentTypeDTO;
import com.cosodi.pos.entity.DocumentType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	@Bean("defaultMapper")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean("documentTypeMapper")
	public ModelMapper documentTypeMapper() {
		ModelMapper mapper = new ModelMapper();

		TypeMap<DocumentTypeDTO, DocumentType> type1 = mapper.createTypeMap(DocumentTypeDTO.class, DocumentType.class);
		type1.addMapping(DocumentTypeDTO::getDocumentTypeId, (dest, v) -> dest.setId((Integer) v));
		type1.addMapping(DocumentTypeDTO::getOverview, (dest, v) -> dest.setDescription((String) v));
		type1.addMapping(DocumentTypeDTO::getShortOverview, (dest, v) -> dest.setShortDescription((String) v));


		TypeMap<DocumentType, DocumentTypeDTO> type2 = mapper.createTypeMap(DocumentType.class, DocumentTypeDTO.class);
		type2.addMapping(DocumentType::getId, (dest, v) -> dest.setDocumentTypeId((Integer) v));
		type2.addMapping(DocumentType::getDescription, (dest, v) -> dest.setOverview((String) v));
		type2.addMapping(DocumentType::getShortDescription, (dest, v) -> dest.setShortOverview((String) v));

		return mapper;
	}
}
