package com.decathlon.gifting.jpamapping;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    EntityManager entityManager;

    public void persist(CartEntity cart) {
        entityManager.merge(cart);
    }

    public List<CartEntity> listAll() {
        return entityManager.createQuery("SELECT c FROM CartEntity c", CartEntity.class).getResultList();
    }

    public void clear() {
        entityManager.createQuery("DELETE from CartEntity").executeUpdate();
    }
}
