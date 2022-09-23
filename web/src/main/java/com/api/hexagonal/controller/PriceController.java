package com.api.hexagonal.controller;


import com.api.hexagonal.domain.service.PriceService;
import com.api.hexagonal.dto.PriceDTO;
import com.api.hexagonal.dto.PriceResponseDTO;
import com.api.hexagonal.ports.input.PriceApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Prices")
@RestController
public class PriceController {

    @Autowired
    private PriceApplicationService priceApplicationService;

    @PostMapping("/prices")
    @ApiOperation(value = "Busca el precio a aplicar según fecha, codigo de marca y codigo de producto")
    public ResponseEntity<PriceResponseDTO> getPriceByDate(@RequestBody PriceDTO priceDTO) {
        PriceResponseDTO priceResponseDTO = priceApplicationService.getAppliedPriceByDate(priceDTO);
        return new ResponseEntity<>(priceResponseDTO, HttpStatus.OK);
    }

}
