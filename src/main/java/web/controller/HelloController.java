package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mainPage() {
		List<User> users = service.getAllUser();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("users");
		modelAndView.addObject("userList",users);

		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") Long id) {
		User user = service.getUserById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editPage");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		service.edit(user);
		return modelAndView;
	}

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editPage");
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		service.add(user);
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		User user = service.getUserById(id);
		service.delete(user);
		return modelAndView;
	}


	
}