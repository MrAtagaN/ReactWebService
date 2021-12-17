package com.plekhanov.react_web_service.mapper;

import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.web.api.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * //TODO сделать тест
 */
@Mapper(componentModel = "spring", uses = {FavoriteProductMapper.class, ProductMapper.class})
public interface UserMapper {

    @Mapping(source = "user.favoriteProducts", target = "favoriteProducts", qualifiedByName = "favoriteProductsToProductDto")
    UserDto userToUserDto(User user);
}
