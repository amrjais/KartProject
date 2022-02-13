/**
 * 
 */
package com.kart.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kart.os.api.entity.Order;

/**
 * @author amrja
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
