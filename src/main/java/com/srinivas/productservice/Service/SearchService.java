//package com.srinivas.productservice.Service;
//
//import com.srinivas.productservice.DTOs.GenericProductDto;
//import com.srinivas.productservice.Models.ProductDocument;
//import com.srinivas.productservice.Models.SortParam;
//import com.srinivas.productservice.Repository.ProductSearchRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class SearchService {
//
//    private final ProductSearchRepository productSearchRepository;
//    SearchService(ProductSearchRepository productSearchRepository) {
//        this.productSearchRepository = productSearchRepository;
//    }
//
//    @Autowired
//    private CacheManager cacheManager;
//
//    @CachePut(value = "searchResults", key = "#query + '-' + #pageNumber + '-' + #pageSize + '-' + #sortParams")
//    public List<GenericProductDto> searchProducts(String query, String category, String attribute, BigDecimal maxPrice, BigDecimal minPrice, int pageNumber, int pageSize, List<SortParam> sortParams) {
//        Sort sort = Sort.by(sortParams.get(0).getSortParamName());
//        sort = sortParams.get(0).getSortType().equalsIgnoreCase("ASC") ? sort.ascending() : sort.descending();
//
//        for (int i = 1; i < sortParams.size(); i++) {
//            SortParam sortParam = sortParams.get(i);
//            Sort newSort = Sort.by(sortParam.getSortParamName());
//            sort = sortParam.getSortType().equalsIgnoreCase("ASC") ? sort.and(newSort.ascending()) : sort.and(newSort.descending());
//        }
//
//        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
//
//        Page<ProductDocument> productDocumentsPage = productSearchRepository.findAllByTitleContainingIgnoreCase(query, pageable);
//        List<ProductDocument> products = productDocumentsPage.getContent();
//
//        List<GenericProductDto> genericProductDtos = new ArrayList<>();
//        for (ProductDocument productDocument : products) {
//            genericProductDtos.add(GenericProductDto.from(productDocument));
//        }
//
//        return genericProductDtos;
//    }
//    public List<ProductDocument> getProductsSortedByPrice(String order) {
//        Sort sort=Sort.by(Sort.Direction.ASC, "price");
//
//        if (order.equalsIgnoreCase("ASC")) {
//            sort = Sort.by(Sort.Direction.ASC, "price");
//        } else if(order.equalsIgnoreCase("DESC")) {
//            sort = Sort.by(Sort.Direction.DESC, "price");
//        }
//        return productSearchRepository.findAll(sort);
//    }
//
//    @CacheEvict(value = "searchResults", allEntries = true)
//    public void evictAllCacheValues() {
//        // Method to evict all cache entries
//    }
//
//}
