package com.example.buysell.services;

import com.example.buysell.models.Image;
import com.example.buysell.models.Product;
import com.example.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final boolean IS_PREVIEW_IMAGE = true;
    private final boolean IS_NOT_PREVIEW_IMAGE = false;
    private final int PREVIEW_IMAGE_POSITION = 0;
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        List<Product> products = productRepository.findAll();
        if (title != null) {
            products = productRepository.findByTitle(title);
        }
        return products;
    }

    public void saveProduct(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(IS_PREVIEW_IMAGE);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            image2.setPreviewImage(IS_NOT_PREVIEW_IMAGE);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            image3.setPreviewImage(IS_NOT_PREVIEW_IMAGE);
            product.addImageToProduct(image3);
        }
        log.info("Save new Product. title: {}; Author: {}", product.getTitle(), product.getAuthor());
        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(PREVIEW_IMAGE_POSITION).getId());
        productRepository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }
}
