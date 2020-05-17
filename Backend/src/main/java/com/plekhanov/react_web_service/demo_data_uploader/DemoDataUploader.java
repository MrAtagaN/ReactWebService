package com.plekhanov.react_web_service.demo_data_uploader;

import com.plekhanov.react_web_service.demo_data_uploader.uploaders.ProductTypeUploader;
import com.plekhanov.react_web_service.demo_data_uploader.uploaders.ProductUploader;
import com.plekhanov.react_web_service.demo_data_uploader.uploaders.UserUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Наполнение базы демонстрационными данными
 */
@Service
@RequiredArgsConstructor
public class DemoDataUploader {

    private final UserUploader userUploader;
    private final ProductTypeUploader productTypeUploader;
    private final ProductUploader productUploader;


    public void insertData() {
        System.setProperty("file.encoding", "UTF-8");
        userUploader.insertData();
        productTypeUploader.insertData();
        productUploader.insertData();
    }
}
