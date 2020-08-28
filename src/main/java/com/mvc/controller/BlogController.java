package com.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.dao.Repository;
import com.mvc.model.Blog;
import com.mvc.model.User;

@Controller
public class BlogController {
	
	public static String getName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return currentPrincipalName;
	}
	
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("logoutSuccess")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping(value= {"/", "home"})
	public ModelAndView home() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView();
		String name = getName();
		List<Blog> blogs = Repository.getBlogs();
		String base64Image = null;
		
		for(int i = 0; i < blogs.size(); i++) {
			if(blogs.get(i).getImage().length != 0) {
				byte[] file = Base64.getEncoder().encode(blogs.get(i).getImage());
				base64Image = new String(file, "UTF-8");
				blogs.get(i).setBase64Image(base64Image);
			}
		}
		
		mv.addObject("name", name);
		mv.addObject("blogs", blogs);
		mv.setViewName("home");
		
		return mv;
	}
	
	@RequestMapping("blogs")
	public ModelAndView blogs() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView();
		int id = getCurrentUserID();
		List<Blog> blogs = Repository.getBlogsForCurrentUser(id);
		String base64Image = null;
		
		for(int i = 0; i < blogs.size(); i++) {
			if(blogs.get(i).getImage().length != 0) {
				byte[] file = Base64.getEncoder().encode(blogs.get(i).getImage());
				base64Image = new String(file, "UTF-8");
				blogs.get(i).setBase64Image(base64Image);
			}
		}
		
		mv.addObject("blogs", blogs);
		mv.setViewName("blogs");
		
		return mv;
	}
	
	@RequestMapping("blog")
	public String blog() {
		return "blog";
	}
	
	public static int getCurrentUserID() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = auth.getName();
		int id = Repository.getUserIDbyUsername(currentPrincipalName);
		
		return id;
	}
	
	@RequestMapping(value = "addBlog", method = RequestMethod.POST)
	public String addBlog(@RequestParam("title") String title, @RequestParam("image") CommonsMultipartFile image, @RequestParam("content") String content) {
		LocalDate date = LocalDate.now();
		String username = getName();
		User user = Repository.findByUsername(username);
		Blog blog = new Blog();
		
		blog.setDate(date);
		blog.setAuthor(username);
		blog.setTitle(title);
		blog.setImage(image.getBytes());
		blog.setContent(content);
		blog.setUser(user);
		
		Repository.saveBlog(blog);
		
		return "redirect:/home";
	}
	
	@RequestMapping("getBlog")
	public String displayBlog() {
		return "getBlog";
	}

	@RequestMapping("displayBlog")
	public ModelAndView getBlog(@RequestParam("search") String title) throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView();
		Blog b = Repository.getBlogByTitle(title);
		String base64Image = null;
		
		if(b == null) {
			mv.setViewName("blogNotFound");
		} else {
			if(b.getImage().length != 0) {
				byte[] file = Base64.getEncoder().encode(b.getImage());
				base64Image = new String(file, "UTF-8");
				b.setBase64Image(base64Image);
			}
			mv.setViewName("displayBlog");
		}
		
		mv.addObject("blog", b);
		
		return mv;
	}

	@RequestMapping("edit{bid}")
	public ModelAndView editBlog(@PathVariable(name="bid") int id) {
		ModelAndView mv = new ModelAndView();
		Blog blog = Repository.getBlog(id);
		
		mv.addObject("Blog", blog);
		mv.setViewName("editBlog");
		
		mv.addObject("blog", blog);
		
		return mv;
	}

	@RequestMapping(value = "updateBlog", method = RequestMethod.POST)
	public String updateBlog(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("bid") int id) {
		Blog blog = Repository.getBlog(id);
		
		blog.setTitle(title);
		blog.setContent(content);
		
		Repository.updateBlog(blog);
		
		return "redirect:/home";
	}

	@RequestMapping("delete{bid}")
	public String deleteBlog(@PathVariable(name="bid") int id) {
		Blog blog = Repository.getBlog(id);
		Repository.deleteBlog(blog);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(bCrypt.encode(password));
		
		Repository.saveUser(user);
		
		return "login";
	}
	
}
