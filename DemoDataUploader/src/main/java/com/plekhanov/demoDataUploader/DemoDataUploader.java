package com.plekhanov.demoDataUploader;

import com.plekhanov.demoDataUploader.uploaders.ProductTypeUploader;
import com.plekhanov.demoDataUploader.uploaders.ProductUploader;
import com.plekhanov.demoDataUploader.uploaders.UserUploader;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * Наполнение базы демонстрационными данными
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DemoDataUploader {

    UserUploader userUploader;
    ProductTypeUploader productTypeUploader;
    ProductUploader productUploader;


    public void uploadData() {
        String bugfix = "это строка - решение бага с кодировкой";
        System.setProperty("file.encoding", "UTF-8");
        userUploader.uploadData();
        //сначала загружается тип, затем продукты
        productTypeUploader.uploadData();
        productUploader.uploadData();
    }
}
