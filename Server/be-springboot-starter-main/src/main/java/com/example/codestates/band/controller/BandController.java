package com.example.codestates.band.controller;

import com.example.codestates.band.dto.BandPatchDto;
import com.example.codestates.band.dto.BandPostDto;
import com.example.codestates.band.entity.Band;
import com.example.codestates.band.mapper.BandMapper;
import com.example.codestates.band.service.BandService;
import com.example.codestates.band.utils.UriCreator;
import com.example.codestates.dto.MultiResponseDto;
import com.example.codestates.dto.SingleResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RequestMapping("/bands")
@RestController
@Validated
public class BandController {

    private final static String BAND_DEFAULT_URL = "/bands";

    private final BandService bandService;
    private final BandMapper bandMapper;

    public BandController(BandService bandService, BandMapper bandMapper) {
        this.bandService = bandService;
        this.bandMapper = bandMapper;
    }

    //생성관련
    //Valid로 유효성 검사 @RequestBody로 요청데이터를 POSTDTO 객체로 매핑함.
    // createBands 매서드는 coffeePostDto를 입력받아 실제 객체를 생성하고 데이터베이스에 저장하는 로직임.
   @PostMapping
  public ResponseEntity postBand(@Valid @RequestBody BandPostDto bandPostDto) {


        Band band = bandService.createBand(bandMapper.bandPostDtoToBand(bandPostDto));
        URI location = UriCreator.createUri(BAND_DEFAULT_URL, band.getBandId());

        return ResponseEntity.created(location).build();

   }



    //수정관련
    @PatchMapping("/{band-id}")
    public ResponseEntity patchBand(@PathVariable("band-id") @Positive long bandId,
                                    @Valid @RequestBody BandPatchDto bandPatchDto){

        bandPatchDto.setBandId(bandId);
        Band band = bandService.updateBand(bandMapper.bandPatchDtoToBand(bandPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(bandMapper.bandToBandResponseDto(band)),
                HttpStatus.OK);
    }


    //조회관련
//    //밴드 ID에 해당하는 밴드정보를 조회하고, 조회된 밴드의 정보를 응답으로 반환
//   @GetMapping("/{band-id}")
//    public ResponseEntity getBand(@PathVariable("band-id")long bandId){
//
//        Band band = bandService.findBandId(bandId);
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(bandMapper.bandToBandResponseDto(band)),
//                HttpStatus.OK);
//
//    }

    @GetMapping("/{band-school}")
    public ResponseEntity getSchool(@PathVariable("band-school")String school){

        Band band = bandService.findSchool(school);

        return new ResponseEntity<>(
                new SingleResponseDto<>(bandMapper.bandToBandResponseDto(band)),
                HttpStatus.OK);

    }


    //주어진 페이지 및 크기에 해당하는 밴드 목록을 조회하고, 조회된 밴드 목록과 페이지 정보를 응답으로 반환합니다.
    @GetMapping
    public ResponseEntity getBands(@Positive @RequestParam int page,
                                   @Positive @RequestParam int size){
        // @Positive @RequestParam int page 페이지번호 1이상의 양수값이어야함.
        // @Positive @RequestParam int size 페이지크키 1이상의 양수값이어야함.

        Page<Band> pageBands = bandService.findSchools(page -1, size);
        List<Band> bands = pageBands.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(bandMapper.bandToBandResponseDtos(bands),
                        pageBands), HttpStatus.OK);


    }


//    @GetMapping
//    public ResponseEntity getSchools(@Positive @RequestParam int page,
//                                   @Positive @RequestParam int size){
//        // @Positive @RequestParam int page 페이지번호 1이상의 양수값이어야함.
//        // @Positive @RequestParam int size 페이지크키 1이상의 양수값이어야함.
//
//        Page<Band> pageBands = bandService.findBands(page -1, size);
//        List<Band> bands = pageBands.getContent();
//
//        return new ResponseEntity<>(
//                new MultiResponseDto<>(bandMapper.bandToBandResponseDtos(bands),
//                        pageBands), HttpStatus.OK);
//
//
//    }


    //삭제관련
    //밴드ID에 해당하는 밴드를 삭제하고, 삭제성공시 이를 알리는 응답을 반환함.
    @DeleteMapping("/{band-id}")
    public ResponseEntity deleteBand(@PathVariable("band-id") long bandId){

        bandService.deleteBands(bandId);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }




}