package com.plekhanov.react_web_service.demo_data_uploader.uploaders;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static com.plekhanov.react_web_service.entities.ProductType.Category.*;

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
        ProductType jeans = productTypeService.findByNameAndCategory("джинсы", clothes);
        if (jeans == null) {
            jeans = new ProductType();
            jeans.setName("джинсы");
            jeans.setCategory(clothes);
            productTypeService.saveOrUpdate(jeans);
        }

        //одежда рубашки
        ProductType shirts = productTypeService.findByNameAndCategory("рубашки", clothes);
        if (shirts == null) {
            shirts = new ProductType();
            shirts.setName("рубашки");
            shirts.setCategory(clothes);
            productTypeService.saveOrUpdate(shirts);
        }

        //одежда футболки
        ProductType tShirts = productTypeService.findByNameAndCategory("футболки", clothes);
        if (tShirts == null) {
            tShirts = new ProductType();
            tShirts.setName("футболки");
            tShirts.setCategory(clothes);
            productTypeService.saveOrUpdate(tShirts);
        }

        //одежда брюки
        ProductType pants = productTypeService.findByNameAndCategory("брюки", clothes);
        if (pants == null) {
            pants = new ProductType();
            pants.setName("брюки");
            pants.setCategory(clothes);
            productTypeService.saveOrUpdate(pants);
        }

        //одежда шорты
        ProductType shorts = productTypeService.findByNameAndCategory("шорты", clothes);
        if (shorts == null) {
            shorts = new ProductType();
            shorts.setName("шорты");
            shorts.setCategory(clothes);
            productTypeService.saveOrUpdate(shorts);
        }

        //одежда толстовки
        ProductType hoodies = productTypeService.findByNameAndCategory("толстовки", clothes);
        if (hoodies == null) {
            hoodies = new ProductType();
            hoodies.setName("толстовки");
            hoodies.setCategory(clothes);
            productTypeService.saveOrUpdate(hoodies);
        }

        //одежда верхняя одежда
        ProductType outerwear = productTypeService.findByNameAndCategory("верхняя одежда", clothes);
        if (outerwear == null) {
            outerwear = new ProductType();
            outerwear.setName("верхняя одежда");
            outerwear.setCategory(clothes);
            productTypeService.saveOrUpdate(outerwear);
        }

        //обувь кроссовки
        ProductType sneakers = productTypeService.findByNameAndCategory("кроссовки", shoes);
        if (sneakers == null) {
            sneakers = new ProductType();
            sneakers.setName("кроссовки");
            sneakers.setCategory(shoes);
            productTypeService.saveOrUpdate(sneakers);
        }

        //обувь ботинки
        ProductType boots = productTypeService.findByNameAndCategory("ботинки", shoes);
        if (boots == null) {
            boots = new ProductType();
            boots.setName("ботинки");
            boots.setCategory(shoes);
            productTypeService.saveOrUpdate(boots);
        }

        //обувь шлепанцы
        ProductType slippers = productTypeService.findByNameAndCategory("шлепанцы", shoes);
        if (slippers == null) {
            slippers = new ProductType();
            slippers.setName("шлепанцы");
            slippers.setCategory(shoes);
            productTypeService.saveOrUpdate(slippers);
        }

        //аксессуары сумки
        ProductType bags = productTypeService.findByNameAndCategory("сумки", accessories);
        if (bags == null) {
            bags = new ProductType();
            bags.setName("сумки");
            bags.setCategory(accessories);
            productTypeService.saveOrUpdate(bags);
        }

        //аксессуары ремни
        ProductType belts = productTypeService.findByNameAndCategory("ремни", accessories);
        if (belts == null) {
            belts = new ProductType();
            belts.setName("ремни");
            belts.setCategory(accessories);
            productTypeService.saveOrUpdate(belts);
        }

        //аксессуары шляпы
        ProductType hats = productTypeService.findByNameAndCategory("шляпы", accessories);
        if (hats == null) {
            hats = new ProductType();
            hats.setName("шляпы");
            hats.setCategory(accessories);
            productTypeService.saveOrUpdate(hats);
        }
    }
}
