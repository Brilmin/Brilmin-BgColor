package com.example.codestates.bgcolor.service;

import com.example.codestates.bgcolor.entity.BgColor;
import com.example.codestates.bgcolor.repository.BgColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BgColorService {
    private final BgColorRepository bgColorRepository;

    public BgColorService(BgColorRepository bgColorRepository) {
        this.bgColorRepository = bgColorRepository;
    }

    // 배경색 데이터를 저장하는 메소드
    public BgColor saveBgColor(BgColor bgColor) {
        return bgColorRepository.save(bgColor); // 배경색 데이터를 데이터베이스에 저장
    }

    // 모든 배경색 데이터를 불러오는 메소드
    public List<BgColor> getAllBgColors() {
        return bgColorRepository.findAll(); // 데이터베이스에 저장된 모든 배경색 데이터를 불러옴
    }
}
