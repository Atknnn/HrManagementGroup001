package com.group1.controller;


import com.group1.dto.request.LoginPersonelRequestDto;
import com.group1.dto.request.PersonelSaveRequestDto;
import com.group1.dto.request.UpdatePersonelRequestDto;
import com.group1.dto.response.PersonelResponseDto;
import com.group1.dto.response.ShowResponseDto;
import com.group1.repository.entity.Personel;
import com.group1.service.PersonelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

import static com.group1.constants.RestApiUrls.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(PERSONEL)
public class PersonelController {
    private final PersonelService personelService;

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginPersonelRequestDto dto) {
        return ResponseEntity.ok(personelService.login(dto));
    }
//    @GetMapping(SHOW)
//    public ResponseEntity<Optional<ShowResponseDto>> show(ShowResponseDto dto){
//        return ResponseEntity.ok(personelService.show(dto));
//    }
    @PostMapping(UPDATE)
    public ResponseEntity<Void> update(UpdatePersonelRequestDto dto) throws IOException {
        personelService.update(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody @Valid PersonelSaveRequestDto dto){
        Personel personel =   personelService.save(dto);
        return ResponseEntity.ok().build();
    }
//@GetMapping(SHOWDETAILS)
//public ResponseEntity<Optional<PersonelResponseDto>> showDetails(){
//    return ResponseEntity.ok(personelService.showDetails());
//}
}
