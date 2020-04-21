package com.example.tksystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.tksystem.model.Customer;
import com.example.tksystem.model.CustomerRepository;

/**
 * 顧客画面のコントローラクラス。
 *
 */
@Controller
@RequestMapping("/customer/")
public class CustomerController {

  /** 顧客リポジトリ */
  @Autowired
  private CustomerRepository customerRepository;

  /**
   * 一覧画面
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("customer", customerRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    return "customer/list";
  }

  /**
   * 入力画面
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping(value = "/regist", method = RequestMethod.GET)
  public String regist(Model model) {
    model.addAttribute("customer", new Customer());
    return "customer/regist";
  }

  /**
   * 確認画面
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping(value = "/confirm", method = RequestMethod.POST)
  public String confirm(@Validated @ModelAttribute("customer") Customer customer,
      BindingResult result) {

    if (result.hasErrors()) {
      if (customer.getId() == null) {
        return "customer/regist";
      }
      return "customer/edit";
    }

    return "customer/confirm";
  }

  /**
   * 登録画面
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String save(Model model, @ModelAttribute("customer") Customer customer) {
    customerRepository.save(customer);
    return "redirect:/customer/list";
  }

  /**
   * 変更画面
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public String edit(@PathVariable("id") Long id, Model model) {
    model.addAttribute("customer", customerRepository.getOne(id));
    return "customer/edit";
  }

  /**
   * 削除
   *
   * @param model モデル
   * @return 遷移先
   */
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public String list(@PathVariable("id") Long id, Model model) {
    customerRepository.deleteById(id);
    return "redirect:/customer/list";
  }
}
