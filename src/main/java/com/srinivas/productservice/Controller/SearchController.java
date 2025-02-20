//package com.srinivas.productservice.Controller;
//
//import com.srinivas.productservice.DTOs.GenericProductDto;
//import com.srinivas.productservice.DTOs.SearchRequestDto;
//import com.srinivas.productservice.Service.SearchService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//@RestController
//@RequestMapping("/search")
//public class SearchController {
//    private final SearchService searchService;
//
//    SearchController(SearchService searchService) {
//        this.searchService = searchService;
//    }
//
//    @PostMapping("/products")
//    public Page<GenericProductDto> searchProducts(@RequestBody SearchRequestDto requestDto) {
//        List<GenericProductDto> genericProductDtos = searchService.searchProducts(requestDto.getQuery(),
//                requestDto.getPageNumber(),
//                requestDto.getPageSize(),
//                requestDto.getSortParams());
//        return new  PageImpl<>(
//                genericProductDtos
//        );
//    }
//}
