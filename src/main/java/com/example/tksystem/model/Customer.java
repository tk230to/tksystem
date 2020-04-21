package com.example.tksystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * 顧客クラス。
 */
@Entity
@Data
public class Customer {

  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_seq")
  @SequenceGenerator(name = "customer_id_seq", sequenceName = "customer_id_seq", allocationSize = 1)
  private Long id;

  @NotBlank
  /** 名前 */
  private String name;
}
