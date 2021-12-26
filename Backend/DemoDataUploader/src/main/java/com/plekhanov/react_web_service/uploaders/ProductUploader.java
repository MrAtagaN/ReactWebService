package com.plekhanov.react_web_service.uploaders;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.model.entities.Product;
import com.plekhanov.react_web_service.model.entities.ProductType;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.plekhanov.react_web_service.model.entities.ProductType.Age.adult;
import static com.plekhanov.react_web_service.model.entities.ProductType.Category.clothes;
import static com.plekhanov.react_web_service.model.entities.ProductType.Gender.female;
import static com.plekhanov.react_web_service.model.entities.ProductType.Gender.male;

/**
 * Загрузка в базу тестовых {@link Product}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductUploader {

    ProductDao productDao;
    ProductTypeDao productTypeDao;


    @SneakyThrows
    public void uploadData() {

        //мужские джинсы
        Set<ProductType> maleJeansSet = productTypeDao.findByParameters("джинсы", male, adult, clothes);
        ProductType maleJeans = maleJeansSet.stream().findFirst().get();

        //модель 123

        Product product = new Product();
        product.setName("модель 123");
        product.setDescription("джинсы классические, прямые");
        product.setType(maleJeans);
        product.setBrand("gap");
        product.setPrice(new BigDecimal(4999));
        product.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product.setColor("синий");
        productDao.save(product);


        //Ultra-Comfort

        Product product2 = new Product();
        product2.setName("Ultra-Comfort");
        product2.setDescription("Джинсовая коллекция. Линия Casual. Экологичный хлопок. Ткань ultra-comfort cashmere " +
                "touch. Крой скинни. Итальянская ткань. Биоразлагаемая эластичная ткань. Темный цвет с эффектом " +
                "потертости. Экологичный краситель.");
        product2.setType(maleJeans);
        product2.setBrand("mango");
        product2.setPrice(new BigDecimal(3499));
        product2.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product2.setColor("синий");
        productDao.save(product2);


        //Джинсы-скинни sculpt

        Product product3 = new Product();
        product3.setName("Джинсы-скинни sculpt");
        product3.setDescription("Укороченная длина. Крой скинни. Посадка на талии. Ткань из экологичного хлопка. По " +
                "бокам два кармана. Карман для монет. Сзади два накладных кармана. Шлевки. Застежка на молнию и пуговицу.");
        product3.setType(maleJeans);
        product3.setBrand("mango");
        product3.setPrice(new BigDecimal(4499));
        product3.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product3.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product3.setColor("белый");
        productDao.save(product3);


        //мужские рубашки
        Set<ProductType> maleShirtsSet = productTypeDao.findByParameters("рубашки", male, adult, clothes);
        ProductType maleShirts = maleShirtsSet.stream().findFirst().get();

        //Рубашка regular-fit из светлого денима

        Product product4 = new Product();
        product4.setName("Рубашка regular-fit из светлого денима");
        product4.setDescription("Линия Casual. Regular fit. Светлый цвет. Воротник \"Акула\". На груди накладной " +
                "карман. Длинные рукава. Закругленные манжеты с застежкой на две пуговицы.");
        product4.setType(maleShirts);
        product4.setBrand("mango");
        product4.setPrice(new BigDecimal(2999));
        product4.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product4.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product4.setColor("белый");
        productDao.save(product4);


        //Хлопковая рубашка regular fit с принтом

        Product product5 = new Product();
        product5.setName("Хлопковая рубашка regular fit с принтом");
        product5.setDescription("Линия Casual. Изделие выполнено из хлопка. Дизайн с фактурной выделкой. Принт. " +
                "Regular fit. Классический воротник. Короткие рукава. Застежка на пуговицы.");
        product5.setType(maleShirts);
        product5.setBrand("gap");
        product5.setPrice(new BigDecimal(2999));
        product5.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product5.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product5.setColor("белый");
        productDao.save(product5);


        //Топ со сборками и принтом

        Product product6 = new Product();
        product6.setName("Топ со сборками и принтом");
        product6.setDescription("100% органический хлопок. Цветочный принт. Присборенная вставка. Рукава-фонарики " +
                "три четверти. Внизу волан.");
        product6.setType(maleShirts);
        product6.setBrand("mango");
        product6.setPrice(new BigDecimal(1999));
        product6.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product6.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product6.setColor("белый");
        productDao.save(product6);


        //женские футболки
        Set<ProductType> femaleTShirtsSet = productTypeDao.findByParameters("футболки", female, adult, clothes);
        ProductType femaleTShirts = femaleTShirtsSet.stream().findFirst().get();
        //Меланжевая футболка с карманом

        Product product7 = new Product();
        product7.setName("Меланжевая футболка с карманом");
        product7.setDescription("Линия Casual. Базовый дизайн. В состав входит хлопок. Пестрая ткань. Круглый вырез " +
                "горловины. Короткие рукава.");
        product7.setType(femaleTShirts);
        product7.setBrand("gap");
        product7.setPrice(new BigDecimal(999));
        product7.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product7.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product7.setColor("белый");
        productDao.save(product7);


        //Хлопковая футболка с V-образной горловиной

        Product product8 = new Product();
        product8.setName("Хлопковая футболка с V-образной горловиной");
        product8.setDescription("Линия Casual. Базовый дизайн. Изделие выполнено из хлопка. V-образный вырез " +
                "горловины. Короткие рукава.");
        product8.setType(femaleTShirts);
        product8.setBrand("gap");
        product8.setPrice(new BigDecimal(799));
        product8.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product8.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product8.setColor("белый");
        productDao.save(product8);


        //Футболка из органического хлопка с принтом

        Product product9 = new Product();
        product9.setName("Футболка из органического хлопка с принтом");
        product9.setDescription("100% органический хлопок. Набивной рисунок. Круглый вырез горловины. Короткие рукава.");
        product9.setType(femaleTShirts);
        product9.setBrand("gap");
        product9.setPrice(new BigDecimal(899));
        product9.setSize(new HashSet<>(Arrays.asList(30, 31, 32)));
        product9.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product9.setColor("белый");
        productDao.save(product9);


        //Футболка из органического хлопка с принтом

        Product product10 = new Product();
        product10.setName("Футболка с принтом");
        product10.setDescription("Футболка из хлопкового трикотажа с принтом");
        product10.setType(femaleTShirts);
        product10.setBrand("h&m");
        product10.setPrice(new BigDecimal(1399));
        product10.setSize(new HashSet<>(Arrays.asList(29, 31)));
        product10.setNamedSize(new HashSet<>(Arrays.asList("M", "S")));
        product10.getImages().add(Files.readAllBytes(Paths.get("Backend/DemoDataUploader/src/main/resources/images/tShirt.jpg")));
        product10.setMainImageNumber(0);
        product10.setColor("белый");
        productDao.save(product10);


    }
}
