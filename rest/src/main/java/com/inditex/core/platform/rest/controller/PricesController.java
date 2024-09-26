package com.inditex.core.platform.rest.controller;

import com.inditex.core.platform.application.FindProductPriceCommand;
import com.inditex.core.platform.application.port.input.UseCaseInvoker;
import com.inditex.core.platform.domain.model.Product;
import lombok.AllArgsConstructor;
import org.openapitools.api.PricesApi;
import org.openapitools.model.ProductPriceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PricesController implements PricesApi {

    FindProductPriceCommand findProductPriceCommand;
    UseCaseInvoker useCaseInvoker;

    @Override
    public ResponseEntity<ProductPriceResponse> findPrices(Integer brandId, Long productId, Date fee) {
        findProductPriceCommand.init(brandId, productId, fee);
        useCaseInvoker.setCommand(findProductPriceCommand);
        Optional<Product> a = useCaseInvoker.executeCommand();
        return null;
    }
}
