package com.ecommerce.infrastructure.postgres.specification

import com.ecommerce.domain.filters.ProductFilters
import com.ecommerce.infrastructure.postgres.model.ProductModel
import com.ecommerce.infrastructure.postgres.model.CategoryModel
import jakarta.persistence.criteria.Predicate
import org.springframework.data.jpa.domain.Specification

object ProductSpecification {

    fun build(filters: ProductFilters?): Specification<ProductModel> {
        return Specification { root, _, cb ->
            val predicates = mutableListOf<Predicate>()

            if (filters != null) {
                filters.name?.let {
                    if (it.isNotEmpty()) {
                        predicates.add(
                            cb.like(cb.lower(root.get("name")), "%${it.lowercase()}%")
                        )
                    }
                }

                filters.categoryId?.let {
                    if (it.isNotEmpty()) {
                        predicates.add(
                            cb.equal(root.get<CategoryModel>("category").get<String>("id"), it)
                        )
                    }
                }

                filters.minPrice?.let {
                    predicates.add(cb.ge(root.get("price"), it))
                }

                filters.maxPrice?.let {
                    predicates.add(cb.le(root.get("price"), it))
                }
            }

            if (predicates.isEmpty()) null else cb.and(*predicates.toTypedArray())
        }
    }
}
