package com.skillup.domain.promotion.stockStrategy;

import com.skillup.domain.promotion.PromotionDomain;
import com.skillup.domain.promotion.PromotionRepository;
import com.skillup.domain.promotion.PromotionStockOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "sync")
@Slf4j
public class SyncStrategy implements PromotionStockOperation {
    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public boolean lockStock(String id) {
        synchronized (this){
            // 1. find Promotion
            PromotionDomain promotionDomain = promotionRepository.getPromotionByPromotionId(id);

            // 2. availableStock - 1, lockStock + 1
            if (promotionDomain.getAvailableStock() > 0){
                log.info("(sync) locked");
                promotionDomain.setAvailableStock(promotionDomain.getAvailableStock() - 1);
                promotionDomain.setLockStock(promotionDomain.getLockStock() + 1);

                // 3. update Promotion with availableStock and lockStock
                promotionRepository.updatePromotion(promotionDomain);
                return true;
            }
            log.info("(sync) sold out");
            return false;
        }
    }

    @Override
    public boolean deductStock(String id) {
        return false;
    }

    @Override
    public boolean revertStock(String id) {
        return false;
    }
}
