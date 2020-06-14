package com.plekhanov.react_web_service.demo_data_uploader.uploaders;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

import static com.plekhanov.react_web_service.entities.Product.Age.adult;
import static com.plekhanov.react_web_service.entities.Product.Gender.female;
import static com.plekhanov.react_web_service.entities.Product.Gender.male;
import static com.plekhanov.react_web_service.entities.ProductType.Category.clothes;

/**
 * Загрузка в базу тестовых {@link Product}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductUploader {

    ProductService productService;
    ProductTypeService productTypeService;


    public void uploadData() {
        //джинсы
        ProductType jeans = productTypeService.findByNameAndCategory("джинсы", clothes);

        //модель 123
        Set<Product> found = productService.search(ProductSearchParams.builder().name("модель 123").build());
        if (found.isEmpty()) {
            Product product = new Product();
            product.setName("модель 123");
            product.setDescription("джинсы классические, прямые");
            product.setType(jeans);
            product.setBrand("gap");
            product.setPrice(new BigDecimal(4999));
            product.setSize(32);
            product.setGender(male);
            product.setAge(adult);
            product.setColor("синий");
            productService.saveOrUpdate(product);
        }

        //Ultra-Comfort
        Set<Product> found2 = productService.search(ProductSearchParams.builder().name("Ultra-Comfort").build());
        if (found2.isEmpty()) {
            Product product2 = new Product();
            product2.setName("Ultra-Comfort");
            product2.setDescription("Джинсовая коллекция. Линия Casual. Экологичный хлопок. Ткань ultra-comfort cashmere " +
                    "touch. Крой скинни. Итальянская ткань. Биоразлагаемая эластичная ткань. Темный цвет с эффектом " +
                    "потертости. Экологичный краситель.");
            product2.setType(jeans);
            product2.setBrand("mango");
            product2.setPrice(new BigDecimal(3499));
            product2.setSize(32);
            product2.setGender(male);
            product2.setAge(adult);
            product2.setColor("синий");
            productService.saveOrUpdate(product2);
        }

        //Джинсы-скинни sculpt
        Set<Product> found3 = productService.search(ProductSearchParams.builder().name("Джинсы-скинни sculpt").build());
        if (found3.isEmpty()) {
            Product product3 = new Product();
            product3.setName("Джинсы-скинни sculpt");
            product3.setDescription("Укороченная длина. Крой скинни. Посадка на талии. Ткань из экологичного хлопка. По " +
                    "бокам два кармана. Карман для монет. Сзади два накладных кармана. Шлевки. Застежка на молнию и пуговицу.");
            product3.setType(jeans);
            product3.setBrand("mango");
            product3.setPrice(new BigDecimal(4499));
            product3.setSize(30);
            product3.setGender(female);
            product3.setAge(adult);
            product3.setColor("белый");
            productService.saveOrUpdate(product3);
        }

        //рубашки
        ProductType shirts = productTypeService.findByNameAndCategory("рубашки", clothes);

        //Рубашка regular-fit из светлого денима
        Set<Product> found4 = productService.search(ProductSearchParams.builder().name("Рубашка regular-fit из светлого денима").build());
        if (found4.isEmpty()) {
            Product product4 = new Product();
            product4.setName("Рубашка regular-fit из светлого денима");
            product4.setDescription("Линия Casual. Regular fit. Светлый цвет. Воротник \"Акула\". На груди накладной " +
                    "карман. Длинные рукава. Закругленные манжеты с застежкой на две пуговицы.");
            product4.setType(shirts);
            product4.setBrand("mango");
            product4.setPrice(new BigDecimal(2999));
            product4.setSize(32);
            product4.setGender(male);
            product4.setAge(adult);
            product4.setColor("белый");
            productService.saveOrUpdate(product4);
        }

        //Хлопковая рубашка regular fit с принтом
        Set<Product> found5 = productService.search(ProductSearchParams.builder().name("Хлопковая рубашка regular fit с принтом").build());
        if (found5.isEmpty()) {
            Product product5 = new Product();
            product5.setName("Хлопковая рубашка regular fit с принтом");
            product5.setDescription("Линия Casual. Изделие выполнено из хлопка. Дизайн с фактурной выделкой. Принт. " +
                    "Regular fit. Классический воротник. Короткие рукава. Застежка на пуговицы.");
            product5.setType(shirts);
            product5.setBrand("gap");
            product5.setPrice(new BigDecimal(2999));
            product5.setSize(32);
            product5.setGender(male);
            product5.setAge(adult);
            product5.setColor("белый");
            productService.saveOrUpdate(product5);
        }

        //Топ со сборками и принтом
        Set<Product> found6 = productService.search(ProductSearchParams.builder().name("Топ со сборками и принтом").build());
        if (found6.isEmpty()) {
            Product product6 = new Product();
            product6.setName("Топ со сборками и принтом");
            product6.setDescription("100% органический хлопок. Цветочный принт. Присборенная вставка. Рукава-фонарики " +
                    "три четверти. Внизу волан.");
            product6.setType(shirts);
            product6.setBrand("mango");
            product6.setPrice(new BigDecimal(1999));
            product6.setSize(32);
            product6.setGender(female);
            product6.setAge(adult);
            product6.setColor("белый");
            productService.saveOrUpdate(product6);
        }

    }
}
