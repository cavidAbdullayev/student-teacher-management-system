package org.example.studentteachermanagementsystem.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ModelMapperServiceImpl implements ModelMapperService {
    private final ModelMapper modelMapper;

    public ModelMapper forRequest() {
        modelMapper
                .getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    public ModelMapper forResponse() {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}