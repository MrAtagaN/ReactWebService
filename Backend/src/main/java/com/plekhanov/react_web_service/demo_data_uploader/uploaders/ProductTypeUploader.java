package com.plekhanov.react_web_service.demo_data_uploader.uploaders;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.plekhanov.react_web_service.entities.ProductType.Category.clothes;

/**
 * Загрузка в базу {@link ProductType}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductTypeUploader {

    ProductTypeService productTypeService;


    public void insertData() {
        //одежда
        ProductType jeans = productTypeService.findByNameAndCategory("джинсы", clothes);
        if (jeans == null) {
            jeans = new ProductType();
            jeans.setName("джинсы");
            jeans.setCategory(clothes);
            productTypeService.saveOrUpdate(jeans);
        }

        ProductType shirts = productTypeService.findByNameAndCategory("рубашки", clothes);
        if (shirts == null) {
            shirts = new ProductType();
            shirts.setName("рубашки");
            shirts.setCategory(clothes);
            productTypeService.saveOrUpdate(shirts);
        }

        ProductType tShirts = productTypeService.findByNameAndCategory("футболки", clothes);
        if (tShirts == null) {
            tShirts = new ProductType();
            tShirts.setName("футболки");
            tShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(tShirts);
        }
    }
}
