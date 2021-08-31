package com.iu.s1.bankbook;

import java.util.ArrayList;

public class BankBookService {
	
	private BankBookDAO bankBookDAO;
	
	public BankBookService() {
		bankBookDAO = new BankBookDAO();
	}
	
	public ArrayList<BankBookDTO> getList() {
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		return ar;
	}

}
