package com.plekhanov.react_web_service.uploaders;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.model.entities.ProductType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.plekhanov.react_web_service.model.entities.ProductType.Age.adult;
import static com.plekhanov.react_web_service.model.entities.ProductType.Category.*;
import static com.plekhanov.react_web_service.model.entities.ProductType.Gender.female;
import static com.plekhanov.react_web_service.model.entities.ProductType.Gender.male;

/**
 * Загрузка в базу {@link ProductType}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductTypeUploader {

    ProductTypeDao productTypeDao;


    public void uploadData() {

        //одежда джинсы
        Set<ProductType> maleJeansSet = productTypeDao.findByParameters("джинсы", male, adult, clothes);
        if (maleJeansSet.isEmpty()) {
            ProductType maleJeans = new ProductType();
            maleJeans.setType("джинсы");
            maleJeans.setGender(male);
            maleJeans.setAge(adult);
            maleJeans.setCategory(clothes);
            productTypeDao.save(maleJeans);
        }

        //одежда рубашки
        ProductType maleShirts = new ProductType();
        maleShirts.setType("рубашки");
        maleShirts.setGender(male);
        maleShirts.setAge(adult);
        maleShirts.setCategory(clothes);
        productTypeDao.save(maleShirts);


        //одежда футболки
        ProductType femaleTShirts = new ProductType();
        femaleTShirts.setType("футболки");
        femaleTShirts.setGender(female);
        femaleTShirts.setAge(adult);
        femaleTShirts.setCategory(clothes);
        productTypeDao.save(femaleTShirts);


        //одежда брюки
        ProductType malePants = new ProductType();
        malePants.setType("брюки");
        malePants.setGender(male);
        malePants.setAge(adult);
        malePants.setCategory(clothes);
        productTypeDao.save(malePants);


        //одежда шорты
        ProductType maleShorts = new ProductType();
        maleShorts.setType("шорты");
        maleShorts.setGender(male);
        maleShorts.setAge(adult);
        maleShorts.setCategory(clothes);
        productTypeDao.save(maleShorts);


        //одежда толстовки
        ProductType maleHoodies = new ProductType();
        maleHoodies.setType("толстовки");
        maleHoodies.setGender(male);
        maleHoodies.setAge(adult);
        maleHoodies.setCategory(clothes);
        productTypeDao.save(maleHoodies);


        //одежда верхняя одежда
        ProductType maleOuterwear = new ProductType();
        maleOuterwear.setType("верхняя одежда");
        maleOuterwear.setGender(male);
        maleOuterwear.setAge(adult);
        maleOuterwear.setCategory(clothes);
        productTypeDao.save(maleOuterwear);


        //обувь кроссовки
        ProductType maleSneakers = new ProductType();
        maleSneakers.setType("кроссовки");
        maleSneakers.setGender(male);
        maleSneakers.setAge(adult);
        maleSneakers.setCategory(shoes);
        productTypeDao.save(maleSneakers);


        //обувь ботинки
        ProductType maleBoots = new ProductType();
        maleBoots.setType("ботинки");
        maleBoots.setGender(male);
        maleBoots.setAge(adult);
        maleBoots.setCategory(shoes);
        productTypeDao.save(maleBoots);


        //обувь шлепанцы
        ProductType maleSlippers = new ProductType();
        maleSlippers.setType("шлепанцы");
        maleSlippers.setGender(male);
        maleSlippers.setAge(adult);
        maleSlippers.setCategory(shoes);
        productTypeDao.save(maleSlippers);


        //аксессуары сумки
        ProductType maleBags = new ProductType();
        maleBags.setType("сумки");
        maleBags.setGender(male);
        maleBags.setAge(adult);
        maleBags.setCategory(accessories);
        productTypeDao.save(maleBags);


        //аксессуары ремни
        ProductType maleBelts = new ProductType();
        maleBelts.setType("ремни");
        maleBelts.setGender(male);
        maleBelts.setAge(adult);
        maleBelts.setCategory(accessories);
        productTypeDao.save(maleBelts);


        //аксессуары шляпы
        ProductType maleHats = new ProductType();
        maleHats.setType("шляпы");
        maleHats.setGender(male);
        maleHats.setAge(adult);
        maleHats.setCategory(accessories);
        productTypeDao.save(maleHats);

    }
}
