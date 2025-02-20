//package com.srinivas.productservice.Service;
//
//import com.srinivas.productservice.DTOs.FakeStoreProductDto;
//import com.srinivas.productservice.DTOs.GenericProductDto;
//import com.srinivas.productservice.Exception.ProductNotFoundException;
//import com.srinivas.productservice.Models.Product;
//import com.srinivas.productservice.Repository.ProductRepository;
//import com.srinivas.productservice.Security.JWTObject;
//import com.srinivas.productservice.Security.TokenValidator;
//import com.srinivas.productservice.ThirdPartyClient.fakeStoreClient.FakeStoreClient;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Primary
//@Service
//public class FakeStoreProductService implements ProductService {
//    private final FakeStoreClient fakeStoreAdapter;
//    private final ProductRepository productRepository;
//    private TokenValidator tokenValidator;
//    private RedisTemplate redisTemplate;
//
//    FakeStoreProductService(FakeStoreClient fakeStoreAdapter, TokenValidator tokenValidator, RedisTemplate redisTemplate, ProductRepository productRepository) {
//        this.fakeStoreAdapter = fakeStoreAdapter;
//        this.tokenValidator = tokenValidator;
//        this.redisTemplate = redisTemplate;
//        this.productRepository = productRepository;
//    }
//
//    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
//        GenericProductDto genericProductDto = new GenericProductDto();
//        genericProductDto.setId(fakeStoreProductDto.getId());
//        genericProductDto.setImage(fakeStoreProductDto.getImage());
//        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
//        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
//        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
//        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
//
//        return genericProductDto;
//    }
//
//    @Override
//    public GenericProductDto getProductById(String authToken, UUID id) throws ProductNotFoundException {
//        //Integrate the FakeStore API.
//        //RestTemplate
//        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);
//
////        if (jwtObjectOptional.isEmpty()) {
////            //Invalid token
////            //reject the request;
////            return null;
////        }
//        //JWTObject jwtObject = jwtObjectOptional.get();
//        //Long userId = jwtObject.getUserId();
//
//        FakeStoreProductDto fakeStoreProductDto = (FakeStoreProductDto) redisTemplate.opsForHash().get("PRODUCTS", id);
//
//        if (fakeStoreProductDto != null) {
//            return convertToGenericProductDto(fakeStoreProductDto);
//        }
//
//        fakeStoreProductDto = fakeStoreAdapter.getProductById(id);
//        redisTemplate.opsForHash().put("PRODUCTS", id, fakeStoreProductDto);
//        return convertToGenericProductDto(fakeStoreProductDto);
//    }
//
//    @Override
//    public List<GenericProductDto> getAllProducts() {
//        List<FakeStoreProductDto> FakeStoreProductDtos = fakeStoreAdapter.getAllProducts();
//
//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        for (FakeStoreProductDto fakeStoreProductDto : FakeStoreProductDtos) {
//            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
//        }
//        return genericProductDtos;
//    }
//
//    @Override
//    public GenericProductDto deleteProductById(UUID id) throws ProductNotFoundException {
//        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
//    }
//
//    @Override
//    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
//        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
//    }
//
//    @Override
//    public Product updateProductById(UUID id,Product product) throws ProductNotFoundException{
//        //
//        return productRepository.save(product);
//    }
//}
