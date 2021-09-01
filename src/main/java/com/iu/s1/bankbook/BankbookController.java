package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo(plain old java object)
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankbookList")
	public ModelAndView list(ModelAndView mv) {
		
		List<BankBookDTO> ar = bankBookService.getList();
		
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(BankBookDTO bankBookDTO, Model model) {
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		model.addAttribute("dtov", bankBookDTO);
		
	}
	
	@RequestMapping("bankbookInsert.do")
	public String insert(BankBookDTO bankBookDTO) {
		//public void insert(String bookName, Double bookRate, Integer bookSale)
		//파라미터를 get하고, DTO에 set하는 과정을 생략할 수 있게 되었다.
		System.out.println(bankBookDTO.getBookName());
		System.out.println("insert");
		return "redirect : ../";
		
	}
}
