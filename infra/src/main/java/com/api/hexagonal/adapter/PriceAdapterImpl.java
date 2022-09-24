package com.api.hexagonal.adapter;

import com.api.hexagonal.domain.entity.Price;
import com.api.hexagonal.domain.repository.PriceRepository;
import com.api.hexagonal.mapper.PriceMapper;
import com.api.hexagonal.mapper.PriceQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Invoca al puerto de salida @{@link PriceRepository}
 */
@Service
public class PriceAdapterImpl implements PriceRepository {

    private static Logger logger = LoggerFactory.getLogger(PriceAdapterImpl.class);

    @Autowired
    private PriceMapper priceMapper;

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Optional<Price> getPriceByDates(LocalDateTime applicationDate, Long productId, Long brandId) {
        Price price = null;
        try {
            StringBuilder stringBuilder = new StringBuilder("SELECT TOP 1 p.PRODUCT_ID AS \"productId\", " +
                    "p.BRAND_ID AS \"brandId\", p.PRICE_LIST AS \"priceList\", p.START_DATE AS \"startDate\", ");
            stringBuilder.append(" p.END_DATE AS \"endDate\", p.PRICE AS \"price\" FROM PRICES p ");
            stringBuilder.append(" where start_date <= '" + applicationDate + "' and end_date > '" + applicationDate + "'");
            stringBuilder.append(" and product_id = " + productId + " and brand_id = " + brandId + "");
            stringBuilder.append(" order by priority desc");
            Query query = entityManager.createNativeQuery(stringBuilder.toString());
            NativeQueryImpl<PriceQuery> nativeQuery = (NativeQueryImpl<PriceQuery>) query;
            nativeQuery.setResultTransformer(Transformers.aliasToBean(PriceQuery.class));
            price = (priceMapper.mapToDomain(nativeQuery.getSingleResult()));
        } catch (NoResultException e) {
            logger.warn(String.format(String.format("No existe un precio a aplicar para la fecha: " +
                    " %s, producto: %s y marca: %s ", applicationDate, productId, brandId)));
        }
        return Optional.ofNullable(price);
    }
}
