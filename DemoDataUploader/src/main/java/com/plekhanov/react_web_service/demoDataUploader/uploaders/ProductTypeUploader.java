package com.plekhanov.react_web_service.demoDataUploader.uploaders;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;

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
        Set<ProductType> maleJeansSet = productTypeService.findByParameters("джинсы", male, adult, clothes);
        if (maleJeansSet.isEmpty()) {
            ProductType maleJeans = new ProductType();
            maleJeans.setName("джинсы");
            maleJeans.setGender(male);
            maleJeans.setAge(adult);
            maleJeans.setCategory(clothes);
            productTypeService.saveOrUpdate(maleJeans);
        }

        //одежда рубашки
        Set<ProductType> maleShirtsSet = productTypeService.findByParameters("рубашки", male, adult, clothes);
        if (maleShirtsSet.isEmpty()) {
            ProductType maleShirts = new ProductType();
            maleShirts.setName("рубашки");
            maleShirts.setGender(male);
            maleShirts.setAge(adult);
            maleShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(maleShirts);
        }

        //одежда футболки
        Set<ProductType> femaleTShirtsSet = productTypeService.findByParameters("футболки", female, adult, clothes);
        if (femaleTShirtsSet.isEmpty()) {
            ProductType femaleTShirts = new ProductType();
            femaleTShirts.setName("футболки");
            femaleTShirts.setGender(female);
            femaleTShirts.setAge(adult);
            femaleTShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(femaleTShirts);
        }

        //одежда брюки
        Set<ProductType> malePantsSet = productTypeService.findByParameters("брюки", male, adult, clothes);
        if (malePantsSet.isEmpty()) {
            ProductType malePants = new ProductType();
            malePants.setName("брюки");
            malePants.setGender(male);
            malePants.setAge(adult);
            malePants.setCategory(clothes);
            productTypeService.saveOrUpdate(malePants);
        }

        //одежда шорты
        Set<ProductType> maleShortsSet = productTypeService.findByParameters("шорты", male, adult, clothes);
        if (maleShortsSet.isEmpty()) {
            ProductType maleShorts = new ProductType();
            maleShorts.setName("шорты");
            maleShorts.setGender(male);
            maleShorts.setAge(adult);
            maleShorts.setCategory(clothes);
            productTypeService.saveOrUpdate(maleShorts);
        }

        //одежда толстовки
        Set<ProductType> maleHoodiesSet = productTypeService.findByParameters("толстовки", male, adult, clothes);
        if (maleHoodiesSet.isEmpty()) {
            ProductType maleHoodies = new ProductType();
            maleHoodies.setName("толстовки");
            maleHoodies.setGender(male);
            maleHoodies.setAge(adult);
            maleHoodies.setCategory(clothes);
            productTypeService.saveOrUpdate(maleHoodies);
        }

        //одежда верхняя одежда
        Set<ProductType> maleOuterwearSet = productTypeService.findByParameters("верхняя одежда", male, adult, clothes);
        if (maleOuterwearSet.isEmpty()) {
            ProductType maleOuterwear = new ProductType();
            maleOuterwear.setName("верхняя одежда");
            maleOuterwear.setGender(male);
            maleOuterwear.setAge(adult);
            maleOuterwear.setCategory(clothes);
            productTypeService.saveOrUpdate(maleOuterwear);
        }

        //обувь кроссовки
        Set<ProductType> maleSneakersSet = productTypeService.findByParameters("кроссовки", male, adult, shoes);
        if (maleSneakersSet.isEmpty()) {
            ProductType maleSneakers = new ProductType();
            maleSneakers.setName("кроссовки");
            maleSneakers.setGender(male);
            maleSneakers.setAge(adult);
            maleSneakers.setCategory(shoes);
            productTypeService.saveOrUpdate(maleSneakers);
        }

        //обувь ботинки
        Set<ProductType> maleBootsSet = productTypeService.findByParameters("ботинки", male, adult, shoes);
        if (maleBootsSet.isEmpty()) {
            ProductType maleBoots = new ProductType();
            maleBoots.setName("ботинки");
            maleBoots.setGender(male);
            maleBoots.setAge(adult);
            maleBoots.setCategory(shoes);
            productTypeService.saveOrUpdate(maleBoots);
        }

        //обувь шлепанцы
        Set<ProductType> maleSlippersSet = productTypeService.findByParameters("шлепанцы", male, adult, shoes);
        if (maleSlippersSet.isEmpty()) {
            ProductType maleSlippers = new ProductType();
            maleSlippers.setName("шлепанцы");
            maleSlippers.setGender(male);
            maleSlippers.setAge(adult);
            maleSlippers.setCategory(shoes);
            productTypeService.saveOrUpdate(maleSlippers);
        }

        //аксессуары сумки
        Set<ProductType> maleBagsSet = productTypeService.findByParameters("сумки", male, adult, accessories);
        if (maleBagsSet.isEmpty()) {
            ProductType maleBags = new ProductType();
            maleBags.setName("сумки");
            maleBags.setGender(male);
            maleBags.setAge(adult);
            maleBags.setCategory(accessories);
            productTypeService.saveOrUpdate(maleBags);
        }

        //аксессуары ремни
        Set<ProductType> maleBeltsSet = productTypeService.findByParameters("ремни", male, adult, accessories);
        if (maleBeltsSet.isEmpty()) {
            ProductType maleBelts = new ProductType();
            maleBelts.setName("ремни");
            maleBelts.setGender(male);
            maleBelts.setAge(adult);
            maleBelts.setCategory(accessories);
            productTypeService.saveOrUpdate(maleBelts);
        }

        //аксессуары шляпы
        Set<ProductType> maleHatsSet = productTypeService.findByParameters("шляпы", male, adult, accessories);
        if (maleHatsSet.isEmpty()) {
            ProductType maleHats = new ProductType();
            maleHats.setName("шляпы");
            maleHats.setGender(male);
            maleHats.setAge(adult);
            maleHats.setCategory(accessories);
            productTypeService.saveOrUpdate(maleHats);
        }
    }
}
