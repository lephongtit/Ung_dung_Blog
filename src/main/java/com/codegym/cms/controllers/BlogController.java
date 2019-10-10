package com.codegym.cms.controllers;

import com.codegym.cms.model.Blog;
import com.codegym.cms.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.text.normalizer.NormalizerBase;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String showBlog(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "blog/list";
    }
    @GetMapping("/blog/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView=new ModelAndView("/blog/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/blog/create")
    public  ModelAndView createBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView =new ModelAndView("/blog/create");
        blogService.save(blog);
        modelAndView.addObject("message","Create Blog Success");
        return modelAndView;
    }

    @GetMapping("/blog/{id}/delete")
    public ModelAndView showFormDelete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @PostMapping("/blog/delete")
    public ModelAndView deleteBlog(@ModelAttribute Blog blog){
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        blogService.remove(blog);
        modelAndView.addObject("message", "Delete Success");
        return modelAndView;
    }
//    @GetMapping("/blog/{id}/edit")
//    public ModelAndView showEdit (@PathVariable Long id){
//        ModelAndView modelAndView=new ModelAndView("/blog/edit");
//        Blog blog=blogService.findById(id);
//        modelAndView.addObject("blog",blog);
//        return modelAndView;
//
//    }
//    @PostMapping("/blog/edit")
//    public ModelAndView editBlog(@ModelAttribute Blog blog){
//        ModelAndView modelAndView=new ModelAndView("/blog/edit");
//        blogService.save(blog);
//        modelAndView.addObject("message","Edit success");
//        return modelAndView;
//    }

}
