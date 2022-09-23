package com.api.hexagonal.ports.input;

import com.api.hexagonal.domain.service.PriceService;
import com.api.hexagonal.dto.PriceDTO;
import com.api.hexagonal.dto.PriceResponseDTO;
import com.api.hexagonal.mapper.PriceDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
public class PriceApplicationServiceImpl implements PriceApplicationService {

    @Autowired
    private PriceService priceService;

    private PriceDataMapper priceDataMapper;

    @Override
    public PriceResponseDTO getAppliedPriceByDate(PriceDTO priceDTO) {
        return priceDataMapper.convertDomainToDto(priceService.getPriceByDate(priceDTO.getApplicationDate(),
                priceDTO.getProductId().longValue(), priceDTO.getBrandId().longValue()));
    }
}
