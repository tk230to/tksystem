package com.example.tksystem.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 顧客リポジトリクラス。
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
