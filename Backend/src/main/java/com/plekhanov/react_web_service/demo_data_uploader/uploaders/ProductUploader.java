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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.plekhanov.react_web_service.entities.ProductType.Age.adult;
import static com.plekhanov.react_web_service.entities.ProductType.Category.clothes;
import static com.plekhanov.react_web_service.entities.ProductType.Gender.*;

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
        ProductType jeans = productTypeService.findByParameters("джинсы", male, adult, clothes);

        //модель 123
        Set<Product> found = productService.search(ProductSearchParams.builder().name("модель 123").build());
        if (found.isEmpty()) {
            Product product = new Product();
            product.setName("модель 123");
            product.setDescription("джинсы классические, прямые");
            product.setType(jeans);
            product.setBrand("gap");
            product.setPrice(new BigDecimal(4999));
            product.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
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
            product2.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
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
            product3.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product3.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
            product3.setColor("белый");
            productService.saveOrUpdate(product3);
        }

        //рубашки
        ProductType shirts = productTypeService.findByParameters("рубашки", male, adult, clothes);

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
            product4.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product4.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
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
            product5.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product5.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
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
            product6.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product6.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
            product6.setColor("белый");
            productService.saveOrUpdate(product6);
        }

        //футболки
        ProductType tShirts = productTypeService.findByParameters("футболки", female, adult, clothes);

        //Меланжевая футболка с карманом
        Set<Product> found7 = productService.search(ProductSearchParams.builder().name("Меланжевая футболка с карманом").build());
        if (found7.isEmpty()) {
            Product product7 = new Product();
            product7.setName("Меланжевая футболка с карманом");
            product7.setDescription("Линия Casual. Базовый дизайн. В состав входит хлопок. Пестрая ткань. Круглый вырез " +
                    "горловины. Короткие рукава.");
            product7.setType(tShirts);
            product7.setBrand("gap");
            product7.setPrice(new BigDecimal(999));
            product7.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product7.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
            product7.setColor("белый");
            productService.saveOrUpdate(product7);
        }

        //Хлопковая футболка с V-образной горловиной
        Set<Product> found8 = productService.search(ProductSearchParams.builder().name("Хлопковая футболка с V-образной горловиной").build());
        if (found8.isEmpty()) {
            Product product8 = new Product();
            product8.setName("Хлопковая футболка с V-образной горловиной");
            product8.setDescription("Линия Casual. Базовый дизайн. Изделие выполнено из хлопка. V-образный вырез " +
                    "горловины. Короткие рукава.");
            product8.setType(tShirts);
            product8.setBrand("gap");
            product8.setPrice(new BigDecimal(799));
            product8.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product8.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
            product8.setColor("белый");
            productService.saveOrUpdate(product8);
        }

        //Футболка из органического хлопка с принтом
        Set<Product> found9 = productService.search(ProductSearchParams.builder().name("Футболка из органического хлопка с принтом").build());
        if (found9.isEmpty()) {
            Product product9 = new Product();
            product9.setName("Футболка из органического хлопка с принтом");
            product9.setDescription("100% органический хлопок. Набивной рисунок. Круглый вырез горловины. Короткие рукава.");
            product9.setType(tShirts);
            product9.setBrand("gap");
            product9.setPrice(new BigDecimal(899));
            product9.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
            product9.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
            product9.setColor("белый");
            productService.saveOrUpdate(product9);
        }

    }
}
