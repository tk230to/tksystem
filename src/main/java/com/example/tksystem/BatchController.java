package com.example.tksystem;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * バッチのコントローラクラス。
 *
 */
@RestController
@RequestMapping("/batch")
public class BatchController {

  @Autowired
  JobLauncher asyncJobLauncher;

  @Autowired
  Job importAmedasJob;

  LocalDate testDate = LocalDate.of(2020, 01, 15);
  Date date = Date.from(testDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

  /**
   * ジョブ実行。
   *
   * @throws Exception
   */
  @RequestMapping(value = "/amedas/import", method = RequestMethod.GET)
  public String importWeather() throws Exception {

    JobExecution jobExecution = asyncJobLauncher.run(importAmedasJob, createJobParameters());
    return String.valueOf(jobExecution.getJobInstance().getInstanceId());
  }

  /**
   * ジョブ引数作成。
   *
   * @return ジョブ引数
   */
  private JobParameters createJobParameters() {

    Map<String, JobParameter> param = new HashMap<>();
    param.put("time", new JobParameter(System.currentTimeMillis()));
    JobParameters jobParameters = new JobParameters(param);
    return jobParameters;
  }
}
