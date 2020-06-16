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
import static com.plekhanov.react_web_service.entities.ProductType.Age.*;

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
        ProductType jeans = productTypeService.findByParameters("джинсы", male, adult, clothes);
        if (jeans == null) {
            jeans = new ProductType();
            jeans.setName("джинсы");
            jeans.setGender(male);
            jeans.setAge(adult);
            jeans.setCategory(clothes);
            productTypeService.saveOrUpdate(jeans);
        }

        //одежда рубашки
        ProductType shirts = productTypeService.findByParameters("рубашки", male, adult, clothes);
        if (shirts == null) {
            shirts = new ProductType();
            shirts.setName("рубашки");
            shirts.setGender(male);
            shirts.setAge(adult);
            shirts.setCategory(clothes);
            productTypeService.saveOrUpdate(shirts);
        }

        //одежда футболки
        ProductType tShirts = productTypeService.findByParameters("футболки", female, adult, clothes);
        if (tShirts == null) {
            tShirts = new ProductType();
            tShirts.setName("футболки");
            tShirts.setGender(female);
            tShirts.setAge(adult);
            tShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(tShirts);
        }

        //одежда брюки
        ProductType pants = productTypeService.findByParameters("брюки", male, adult, clothes);
        if (pants == null) {
            pants = new ProductType();
            pants.setName("брюки");
            pants.setGender(male);
            pants.setAge(adult);
            pants.setCategory(clothes);
            productTypeService.saveOrUpdate(pants);
        }

        //одежда шорты
        ProductType shorts = productTypeService.findByParameters("шорты", male, adult, clothes);
        if (shorts == null) {
            shorts = new ProductType();
            shorts.setName("шорты");
            shorts.setGender(male);
            shorts.setAge(adult);
            shorts.setCategory(clothes);
            productTypeService.saveOrUpdate(shorts);
        }

        //одежда толстовки
        ProductType hoodies = productTypeService.findByParameters("толстовки", male, adult, clothes);
        if (hoodies == null) {
            hoodies = new ProductType();
            hoodies.setName("толстовки");
            hoodies.setGender(male);
            hoodies.setAge(adult);
            hoodies.setCategory(clothes);
            productTypeService.saveOrUpdate(hoodies);
        }

        //одежда верхняя одежда
        ProductType outerwear = productTypeService.findByParameters("верхняя одежда", male, adult, clothes);
        if (outerwear == null) {
            outerwear = new ProductType();
            outerwear.setName("верхняя одежда");
            outerwear.setGender(male);
            outerwear.setAge(adult);
            outerwear.setCategory(clothes);
            productTypeService.saveOrUpdate(outerwear);
        }

        //обувь кроссовки
        ProductType sneakers = productTypeService.findByParameters("кроссовки", male, adult, shoes);
        if (sneakers == null) {
            sneakers = new ProductType();
            sneakers.setName("кроссовки");
            sneakers.setGender(male);
            sneakers.setAge(adult);
            sneakers.setCategory(shoes);
            productTypeService.saveOrUpdate(sneakers);
        }

        //обувь ботинки
        ProductType boots = productTypeService.findByParameters("ботинки", male, adult, shoes);
        if (boots == null) {
            boots = new ProductType();
            boots.setName("ботинки");
            boots.setGender(male);
            boots.setAge(adult);
            boots.setCategory(shoes);
            productTypeService.saveOrUpdate(boots);
        }

        //обувь шлепанцы
        ProductType slippers = productTypeService.findByParameters("шлепанцы", male, adult, shoes);
        if (slippers == null) {
            slippers = new ProductType();
            slippers.setName("шлепанцы");
            slippers.setGender(male);
            slippers.setAge(adult);
            slippers.setCategory(shoes);
            productTypeService.saveOrUpdate(slippers);
        }

        //аксессуары сумки
        ProductType bags = productTypeService.findByParameters("сумки", male, adult, accessories);
        if (bags == null) {
            bags = new ProductType();
            bags.setName("сумки");
            bags.setGender(male);
            bags.setAge(adult);
            bags.setCategory(accessories);
            productTypeService.saveOrUpdate(bags);
        }

        //аксессуары ремни
        ProductType belts = productTypeService.findByParameters("ремни", male, adult, accessories);
        if (belts == null) {
            belts = new ProductType();
            belts.setName("ремни");
            belts.setGender(male);
            belts.setAge(adult);
            belts.setCategory(accessories);
            productTypeService.saveOrUpdate(belts);
        }

        //аксессуары шляпы
        ProductType hats = productTypeService.findByParameters("шляпы", male, adult, accessories);
        if (hats == null) {
            hats = new ProductType();
            hats.setName("шляпы");
            hats.setGender(male);
            hats.setAge(adult);
            hats.setCategory(accessories);
            productTypeService.saveOrUpdate(hats);
        }
    }
}
