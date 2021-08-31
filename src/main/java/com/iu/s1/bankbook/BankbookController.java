package com.iu.s1.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.DBConnector;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo(plain old java object)
	
	private BankBookService bankbookService;
	
	@Autowired
	public BankbookController() {
	}
	
	@RequestMapping(value="bankbookList.do", method=RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) {
		ArrayList<BankBookDTO> ar = bankbookService.getList();
		
		System.out.println("bankbook list");
		
		//ModelAndView mv = new ModelAndView();
		mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList");
		
//		return "bankbook/bankbookList";
//		어차피 ModelAndView를 반환할 것을 여기서 직접 반환하는 방법도 있다.
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(@RequestParam(defaultValue = "1", value = "n") Integer num, String name, Model model) {
		//매개변수로 Integer을 넣은 이유?
		//주소창에 num을 null로 받았을 때 int로 변환하는 과정에 IllegalStateException 발생
		System.out.println("Value : " + num);
		System.out.println("Name : " + name);
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("BookName");
		model.addAttribute("test", "iu");
//		return "bankbook/bankbookSelect";
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
