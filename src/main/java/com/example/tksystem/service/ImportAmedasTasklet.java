package com.example.tksystem.service;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * アメダスデータ取込タスクレット。
 */
public class ImportAmedasTasklet implements Tasklet {

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
      throws Exception {

    Thread.sleep(10000);
    System.out.println(chunkContext.getStepContext().getJobParameters().get("time"));
    System.out.println("ImportAmedasTasklet");
    return RepeatStatus.FINISHED;
  }
}
