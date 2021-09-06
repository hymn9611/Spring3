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

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo(plain old java object)
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankbookList")
	public ModelAndView list(ModelAndView mv, Pager pager) {
		
		
		List<BankBookDTO> ar = bankBookService.getList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(BankBookDTO bankBookDTO, Model model) {
		System.out.println("select");
		System.out.println(bankBookDTO.getBookNumber());
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		System.out.println("Name : " + bankBookDTO.getBookName());
		model.addAttribute("dto", bankBookDTO);
		
	}
	
	@RequestMapping(value="bankbookInsert", method=RequestMethod.GET)
	public void insert() {}
	
	@RequestMapping(value="bankbookInsert", method=RequestMethod.POST)
	public String insert(BankBookDTO bankBookDTO) {
		int result = bankBookService.setInsert(bankBookDTO);
		
		return "redirect:./bankbookList";
		
	}
	
	@RequestMapping("bankbookDelete")
	public String delete(Long bookNumber) {
		int result = bankBookService.setDelete(bookNumber);
		
		return "redirect:./bankbookList";
	}
	
	@RequestMapping(value="bankbookUpdate", method=RequestMethod.GET)
	public ModelAndView update(BankBookDTO bankBookDTO) {
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankbook/bankbookUpdate");
		mv.addObject("dto", bankBookDTO);
		return mv;
	}
	
	@RequestMapping(value="bankbookUpdate", method= RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO, ModelAndView mv) {
		int result = bankBookService.setUpdate(bankBookDTO);
		mv.setViewName("redirect:./bankbookList");
		return mv;
	}
}
