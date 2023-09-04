package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.RegisterDao;
import com.org.dto.Register;

@Controller
public class RegisterController {

	@RequestMapping("/save")
	public ModelAndView saveRegister(@ModelAttribute Register e)
	{
		ModelAndView mav = new ModelAndView("home.jsp");
		boolean res=RegisterDao.saveReg(e);
		if(res)
		{
			mav.addObject("msg","Registered Successfully");
		}
		else {
			mav.addObject("msg","somthing went wrong");
		}
		return mav;
	}
	
	@RequestMapping("/get")
	public String getRegister(HttpSession hs)
	{
		List<Register> reg=RegisterDao.getAllReg();
		hs.setAttribute("reg", reg);
		return "display.jsp";
	}
	@RequestMapping("/delete")
	public ModelAndView deleteReg(@RequestParam int id)
	{
		ModelAndView mav = new ModelAndView("get");
		boolean res = RegisterDao.deleteReg(id);
		if(res)
		{
			mav.addObject("msg","delete risgister successfully");
		}
		return mav;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editReg(@RequestParam int id)
	{
		Register e = RegisterDao.findId(id);
		ModelAndView mav=new ModelAndView("update.jsp");
		mav.addObject("reg",e);
		return mav;
		
	}
	
	@RequestMapping("/update")
	public ModelAndView updateREG(@ModelAttribute Register r)
	{
		ModelAndView mav=new ModelAndView("get");
		RegisterDao.updateReg(r);
		mav.addObject("msg","Data Updated Successfully");
		return mav;
	}
}
