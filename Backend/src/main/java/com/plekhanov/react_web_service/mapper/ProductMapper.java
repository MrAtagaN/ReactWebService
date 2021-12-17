package com.plekhanov.react_web_service.mapper;


import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.web.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * //TODO сделать тест, нужен ли uses = FavoriteProductMapper.class ?
 */
@Mapper(componentModel = "spring", uses = FavoriteProductMapper.class)
public interface ProductMapper {

    @Mapping(source = "productDto.type", target = "type.type")
    @Mapping(source = "productDto.category", target = "type.category")
    @Mapping(source = "productDto.age", target = "type.age")
    @Mapping(source = "productDto.gender", target = "type.gender")
    @Mapping(source = "productDto.productTypeId", target = "type.id")
    Product productDtoToProduct(ProductDto productDto);


    @Mapping(source = "product.type.type", target = "type")
    @Mapping(source = "product.type.category", target = "category")
    @Mapping(source = "product.type.age", target = "age")
    @Mapping(source = "product.type.gender", target = "gender")
    @Mapping(source = "product.type.id", target = "productTypeId")
    ProductDto productToProductDto(Product product);

}
