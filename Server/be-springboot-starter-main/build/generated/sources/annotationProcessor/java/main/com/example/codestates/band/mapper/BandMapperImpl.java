package com.example.codestates.band.mapper;

import com.example.codestates.band.dto.BandPatchDto;
import com.example.codestates.band.dto.BandPostDto;
import com.example.codestates.band.dto.BandResponseDto;
import com.example.codestates.band.entity.Band;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T14:27:59+0900",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.20.1 (Azul Systems, Inc.)"
)
@Component
public class BandMapperImpl implements BandMapper {

    @Override
    public Band bandPostDtoToBand(BandPostDto bandPostDto) {
        if ( bandPostDto == null ) {
            return null;
        }

        Band band = new Band();

        band.setSchool( bandPostDto.getSchool() );
        band.setSchoolCode( bandPostDto.getSchoolCode() );
        band.setGrade( bandPostDto.getGrade() );
        band.setBanNumber( bandPostDto.getBanNumber() );
        band.setJoinPass( bandPostDto.getJoinPass() );

        return band;
    }

    @Override
    public Band bandPatchDtoToBand(BandPatchDto bandPatchDto) {
        if ( bandPatchDto == null ) {
            return null;
        }

        Band band = new Band();

        band.setBandId( bandPatchDto.getBandId() );
        band.setSchool( bandPatchDto.getSchool() );
        band.setSchoolCode( bandPatchDto.getSchoolCode() );
        band.setGrade( bandPatchDto.getGrade() );
        band.setBanNumber( bandPatchDto.getBanNumber() );
        band.setJoinPass( bandPatchDto.getJoinPass() );
        band.setStatusUpdate( bandPatchDto.getStatusUpdate() );

        return band;
    }

    @Override
    public BandResponseDto bandToBandResponseDto(Band band) {
        if ( band == null ) {
            return null;
        }

        BandResponseDto.BandResponseDtoBuilder bandResponseDto = BandResponseDto.builder();

        if ( band.getBandId() != null ) {
            bandResponseDto.bandId( band.getBandId() );
        }
        bandResponseDto.school( band.getSchool() );
        bandResponseDto.schoolCode( band.getSchoolCode() );
        bandResponseDto.grade( band.getGrade() );
        bandResponseDto.banNumber( band.getBanNumber() );
        bandResponseDto.joinPass( band.getJoinPass() );
        bandResponseDto.statusUpdate( band.getStatusUpdate() );

        return bandResponseDto.build();
    }

    @Override
    public List<BandResponseDto> bandToBandResponseDtos(List<Band> bands) {
        if ( bands == null ) {
            return null;
        }

        List<BandResponseDto> list = new ArrayList<BandResponseDto>( bands.size() );
        for ( Band band : bands ) {
            list.add( bandToBandResponseDto( band ) );
        }

        return list;
    }
}
