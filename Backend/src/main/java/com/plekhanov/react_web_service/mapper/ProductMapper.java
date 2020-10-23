package com.plekhanov.react_web_service.mapper;


import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.web.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "productDto.type", target = "type.type")
    @Mapping(source = "productDto.category", target = "type.category")
    @Mapping(source = "productDto.age", target = "type.age")
    @Mapping(source = "productDto.gender", target = "type.gender")
    @Mapping(source = "productDto.productTypeId", target = "type.id")
    Product productDtoToProduct(ProductDto productDto);


}
