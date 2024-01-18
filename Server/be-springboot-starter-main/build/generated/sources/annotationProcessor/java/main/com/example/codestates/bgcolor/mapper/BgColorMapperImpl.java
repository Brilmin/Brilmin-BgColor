package com.example.codestates.bgcolor.mapper;

import com.example.codestates.bgcolor.dto.BgColorPostDto;
import com.example.codestates.bgcolor.dto.BgColorResponseDto;
import com.example.codestates.bgcolor.entity.BgColor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T15:33:37+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.20.1 (Azul Systems, Inc.)"
)
@Component
public class BgColorMapperImpl implements BgColorMapper {

    @Override
    public BgColor bgColorPostDtoToBgColor(BgColorPostDto bgColorPostDto) {
        if ( bgColorPostDto == null ) {
            return null;
        }

        BgColor bgColor = new BgColor();

        bgColor.setColorName( bgColorPostDto.getColorName() );
        bgColor.setHexCode( bgColorPostDto.getHexCode() );

        return bgColor;
    }

    @Override
    public BgColorResponseDto bgColorToBgColorResponseDto(BgColor bgColor) {
        if ( bgColor == null ) {
            return null;
        }

        BgColorResponseDto bgColorResponseDto = new BgColorResponseDto();

        bgColorResponseDto.setBgColorId( bgColor.getBgColorId() );
        bgColorResponseDto.setColorName( bgColor.getColorName() );
        bgColorResponseDto.setHexCode( bgColor.getHexCode() );

        return bgColorResponseDto;
    }
}
