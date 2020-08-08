package com.plekhanov.demoDataUploader.uploaders;

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
        ProductType maleJeans = productTypeService.findByParameters("джинсы", male, adult, clothes);
        if (maleJeans == null) {
            maleJeans = new ProductType();
            maleJeans.setName("джинсы");
            maleJeans.setGender(male);
            maleJeans.setAge(adult);
            maleJeans.setCategory(clothes);
            productTypeService.saveOrUpdate(maleJeans);
        }

        //одежда рубашки
        ProductType maleShirts = productTypeService.findByParameters("рубашки", male, adult, clothes);
        if (maleShirts == null) {
            maleShirts = new ProductType();
            maleShirts.setName("рубашки");
            maleShirts.setGender(male);
            maleShirts.setAge(adult);
            maleShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(maleShirts);
        }

        //одежда футболки
        ProductType femaleTShirts = productTypeService.findByParameters("футболки", female, adult, clothes);
        if (femaleTShirts == null) {
            femaleTShirts = new ProductType();
            femaleTShirts.setName("футболки");
            femaleTShirts.setGender(female);
            femaleTShirts.setAge(adult);
            femaleTShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(femaleTShirts);
        }

        //одежда брюки
        ProductType malePants = productTypeService.findByParameters("брюки", male, adult, clothes);
        if (malePants == null) {
            malePants = new ProductType();
            malePants.setName("брюки");
            malePants.setGender(male);
            malePants.setAge(adult);
            malePants.setCategory(clothes);
            productTypeService.saveOrUpdate(malePants);
        }

        //одежда шорты
        ProductType maleShorts = productTypeService.findByParameters("шорты", male, adult, clothes);
        if (maleShorts == null) {
            maleShorts = new ProductType();
            maleShorts.setName("шорты");
            maleShorts.setGender(male);
            maleShorts.setAge(adult);
            maleShorts.setCategory(clothes);
            productTypeService.saveOrUpdate(maleShorts);
        }

        //одежда толстовки
        ProductType maleHoodies = productTypeService.findByParameters("толстовки", male, adult, clothes);
        if (maleHoodies == null) {
            maleHoodies = new ProductType();
            maleHoodies.setName("толстовки");
            maleHoodies.setGender(male);
            maleHoodies.setAge(adult);
            maleHoodies.setCategory(clothes);
            productTypeService.saveOrUpdate(maleHoodies);
        }

        //одежда верхняя одежда
        ProductType maleOuterwear = productTypeService.findByParameters("верхняя одежда", male, adult, clothes);
        if (maleOuterwear == null) {
            maleOuterwear = new ProductType();
            maleOuterwear.setName("верхняя одежда");
            maleOuterwear.setGender(male);
            maleOuterwear.setAge(adult);
            maleOuterwear.setCategory(clothes);
            productTypeService.saveOrUpdate(maleOuterwear);
        }

        //обувь кроссовки
        ProductType maleSneakers = productTypeService.findByParameters("кроссовки", male, adult, shoes);
        if (maleSneakers == null) {
            maleSneakers = new ProductType();
            maleSneakers.setName("кроссовки");
            maleSneakers.setGender(male);
            maleSneakers.setAge(adult);
            maleSneakers.setCategory(shoes);
            productTypeService.saveOrUpdate(maleSneakers);
        }

        //обувь ботинки
        ProductType maleBoots = productTypeService.findByParameters("ботинки", male, adult, shoes);
        if (maleBoots == null) {
            maleBoots = new ProductType();
            maleBoots.setName("ботинки");
            maleBoots.setGender(male);
            maleBoots.setAge(adult);
            maleBoots.setCategory(shoes);
            productTypeService.saveOrUpdate(maleBoots);
        }

        //обувь шлепанцы
        ProductType maleSlippers = productTypeService.findByParameters("шлепанцы", male, adult, shoes);
        if (maleSlippers == null) {
            maleSlippers = new ProductType();
            maleSlippers.setName("шлепанцы");
            maleSlippers.setGender(male);
            maleSlippers.setAge(adult);
            maleSlippers.setCategory(shoes);
            productTypeService.saveOrUpdate(maleSlippers);
        }

        //аксессуары сумки
        ProductType maleBags = productTypeService.findByParameters("сумки", male, adult, accessories);
        if (maleBags == null) {
            maleBags = new ProductType();
            maleBags.setName("сумки");
            maleBags.setGender(male);
            maleBags.setAge(adult);
            maleBags.setCategory(accessories);
            productTypeService.saveOrUpdate(maleBags);
        }

        //аксессуары ремни
        ProductType maleBelts = productTypeService.findByParameters("ремни", male, adult, accessories);
        if (maleBelts == null) {
            maleBelts = new ProductType();
            maleBelts.setName("ремни");
            maleBelts.setGender(male);
            maleBelts.setAge(adult);
            maleBelts.setCategory(accessories);
            productTypeService.saveOrUpdate(maleBelts);
        }

        //аксессуары шляпы
        ProductType maleHats = productTypeService.findByParameters("шляпы", male, adult, accessories);
        if (maleHats == null) {
            maleHats = new ProductType();
            maleHats.setName("шляпы");
            maleHats.setGender(male);
            maleHats.setAge(adult);
            maleHats.setCategory(accessories);
            productTypeService.saveOrUpdate(maleHats);
        }
    }
}
