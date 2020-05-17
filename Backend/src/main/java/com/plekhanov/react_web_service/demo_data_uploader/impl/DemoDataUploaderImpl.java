package com.plekhanov.react_web_service.demo_data_uploader.impl;

import com.plekhanov.react_web_service.demo_data_uploader.impl.uploaders.ProductTypeUploader;
import com.plekhanov.react_web_service.demo_data_uploader.impl.uploaders.ProductUploader;
import com.plekhanov.react_web_service.demo_data_uploader.impl.uploaders.UserUploader;
import com.plekhanov.react_web_service.demo_data_uploader.DemoDataUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DemoDataUploaderImpl implements DemoDataUploader {

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
