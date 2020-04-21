package com.example.tksystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * トップ画面のコントローラクラス。
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

  /**
   * トップ画面
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping("index")
  public String index(Model model) {
    return "index";
  }

  /**
   * 気象画面
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping(value = "/weather", method = RequestMethod.GET)
  public String weather(Model model) {
    return "weather";
  }

  /**
   * 例外制御(カスタマイズ)の確認用
   *
   * @param model モデル
   * @return 遷移先
   * @throws 常にエラーを発生させる
   */
  @RequestMapping(value = "/errortest", method = RequestMethod.GET)
  public String error(Model model) throws Exception {
    throw new Exception("テスト");
  }
}
