package com.evidence.app.util;

import com.evidence.app.dto.CriminalCaseResponseDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * @author JayendraB
 * Created on 29/05/21
 */
public class ConvertUtils{

    private ConvertUtils(){
        super();
    }

    public static CriminalCaseResponseDTO cloneObjectToCriminalCaseResponseDTO(Object object){

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
        objectMapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.convertValue( object, CriminalCaseResponseDTO.class);
    }
}
