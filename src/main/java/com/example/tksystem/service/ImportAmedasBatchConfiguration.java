package com.example.tksystem.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * アメダスデータ取込ジョブ定義クラス。
 */
@Configuration
@EnableBatchProcessing
public class ImportAmedasBatchConfiguration {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private ImportAmedasTasklet importAmedasTasklet;

  /**
   * ジョブをBeanに登録。
   *
   * @return アメダスデータ取込ジョブ
   */
  @Bean
  public Job importAmedasJob() {

    // 実行するステップを設定
    return jobBuilderFactory.get("importAmedasJob").incrementer(new RunIdIncrementer())
        .start(importAmedasStep()).build();
  }

  /**
   * ステップをBeanに登録。
   *
   * @return アメダスデータ取込ジョブステップ
   */
  @Bean
  public Step importAmedasStep() {

    // 実行するタスクレットを設定
    return stepBuilderFactory.get("importAmedasStep").tasklet(importAmedasTasklet).build();
  }

  /**
   * タスクレットをBeanに登録。
   *
   * @return アメダスデータ取込タスクレット
   */
  @Bean
  public ImportAmedasTasklet tasklet() {

    return new ImportAmedasTasklet();
  }
}
