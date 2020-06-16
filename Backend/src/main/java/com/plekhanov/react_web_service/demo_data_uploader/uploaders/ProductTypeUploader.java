package com.plekhanov.react_web_service.demo_data_uploader.uploaders;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.plekhanov.react_web_service.entities.ProductType.Category.*;
import static com.plekhanov.react_web_service.entities.ProductType.Gender.female;
import static com.plekhanov.react_web_service.entities.ProductType.Gender.male;

/**
 * Загрузка в базу {@link ProductType}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductTypeUploader {

    ProductTypeService productTypeService;


    public void uploadData() {
        //одежда джинсы
        ProductType jeans = productTypeService.findByParameters("джинсы", male, clothes);
        if (jeans == null) {
            jeans = new ProductType();
            jeans.setName("джинсы");
            jeans.setGender(male);
            jeans.setCategory(clothes);
            productTypeService.saveOrUpdate(jeans);
        }

        //одежда рубашки
        ProductType shirts = productTypeService.findByParameters("рубашки", male, clothes);
        if (shirts == null) {
            shirts = new ProductType();
            shirts.setName("рубашки");
            shirts.setGender(male);
            shirts.setCategory(clothes);
            productTypeService.saveOrUpdate(shirts);
        }

        //одежда футболки
        ProductType tShirts = productTypeService.findByParameters("футболки", female, clothes);
        if (tShirts == null) {
            tShirts = new ProductType();
            tShirts.setName("футболки");
            tShirts.setGender(female);
            tShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(tShirts);
        }

        //одежда брюки
        ProductType pants = productTypeService.findByParameters("брюки", male, clothes);
        if (pants == null) {
            pants = new ProductType();
            pants.setName("брюки");
            pants.setGender(male);
            pants.setCategory(clothes);
            productTypeService.saveOrUpdate(pants);
        }

        //одежда шорты
        ProductType shorts = productTypeService.findByParameters("шорты", male, clothes);
        if (shorts == null) {
            shorts = new ProductType();
            shorts.setName("шорты");
            shorts.setGender(male);
            shorts.setCategory(clothes);
            productTypeService.saveOrUpdate(shorts);
        }

        //одежда толстовки
        ProductType hoodies = productTypeService.findByParameters("толстовки", male, clothes);
        if (hoodies == null) {
            hoodies = new ProductType();
            hoodies.setName("толстовки");
            hoodies.setGender(male);
            hoodies.setCategory(clothes);
            productTypeService.saveOrUpdate(hoodies);
        }

        //одежда верхняя одежда
        ProductType outerwear = productTypeService.findByParameters("верхняя одежда", male, clothes);
        if (outerwear == null) {
            outerwear = new ProductType();
            outerwear.setName("верхняя одежда");
            outerwear.setGender(male);
            outerwear.setCategory(clothes);
            productTypeService.saveOrUpdate(outerwear);
        }

        //обувь кроссовки
        ProductType sneakers = productTypeService.findByParameters("кроссовки", male, shoes);
        if (sneakers == null) {
            sneakers = new ProductType();
            sneakers.setName("кроссовки");
            sneakers.setGender(male);
            sneakers.setCategory(shoes);
            productTypeService.saveOrUpdate(sneakers);
        }

        //обувь ботинки
        ProductType boots = productTypeService.findByParameters("ботинки", male, shoes);
        if (boots == null) {
            boots = new ProductType();
            boots.setName("ботинки");
            boots.setGender(male);
            boots.setCategory(shoes);
            productTypeService.saveOrUpdate(boots);
        }

        //обувь шлепанцы
        ProductType slippers = productTypeService.findByParameters("шлепанцы", male, shoes);
        if (slippers == null) {
            slippers = new ProductType();
            slippers.setName("шлепанцы");
            slippers.setGender(male);
            slippers.setCategory(shoes);
            productTypeService.saveOrUpdate(slippers);
        }

        //аксессуары сумки
        ProductType bags = productTypeService.findByParameters("сумки", male, accessories);
        if (bags == null) {
            bags = new ProductType();
            bags.setName("сумки");
            bags.setGender(male);
            bags.setCategory(accessories);
            productTypeService.saveOrUpdate(bags);
        }

        //аксессуары ремни
        ProductType belts = productTypeService.findByParameters("ремни", male, accessories);
        if (belts == null) {
            belts = new ProductType();
            belts.setName("ремни");
            belts.setGender(male);
            belts.setCategory(accessories);
            productTypeService.saveOrUpdate(belts);
        }

        //аксессуары шляпы
        ProductType hats = productTypeService.findByParameters("шляпы", male, accessories);
        if (hats == null) {
            hats = new ProductType();
            hats.setName("шляпы");
            hats.setGender(male);
            hats.setCategory(accessories);
            productTypeService.saveOrUpdate(hats);
        }
    }
}
