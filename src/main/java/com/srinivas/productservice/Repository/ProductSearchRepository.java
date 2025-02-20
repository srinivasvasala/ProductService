package com.srinivas.productservice.Repository;

import com.srinivas.productservice.Models.Category;
import com.srinivas.productservice.Models.Product;
import com.srinivas.productservice.Models.ProductDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<ProductDocument, String> {

    List<ProductDocument> findByNameContainingOrDescriptionContaining(String name, String description);

    List<ProductDocument> findByCategoryAndPriceBetween(String category, Double minPrice, Double maxPrice);

    List<ProductDocument>findAllByTitle(String title);

    Optional<ProductDocument> findById(Long id);

    Page<ProductDocument> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);


    List<ProductDocument> findByCategory(Category category);

    List<ProductDocument> findByTagsIn(List<String> tags);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"attributes.?0\": \"?1\"}}]}}")
    List<Product> findByAttributesKeyAndValue(String key, String value);


}
