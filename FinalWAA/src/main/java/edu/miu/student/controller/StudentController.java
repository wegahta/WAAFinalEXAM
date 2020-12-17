package edu.miu.student.controller;

import edu.miu.student.domain.Address;
import edu.miu.student.domain.Exceptions.UserNotFoundException;
import edu.miu.student.domain.Phone;
import edu.miu.student.domain.Student;
import edu.miu.student.service.AddressService;
import edu.miu.student.service.PhoneService;
import edu.miu.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.*;

@Controller
public class StudentController {
    @Autowired
    AddressService addressService;
    @Autowired
    StudentService studentService;
    @Autowired
    PhoneService phoneService;

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @ModelAttribute("roles")
    private Map<String,String> getRole(){
        Map<String,String> rolesMap= new HashMap<>();
        rolesMap.put("ADM","ADM");
        rolesMap.put("User","User");
        return rolesMap;
    }

    @GetMapping("/addStudent")
    public String getStudenForm(@ModelAttribute("newStudent") Student student ,Model model){
        List<Address> adresses= addressService.findAllAddress();
        model.addAttribute("listaddress",adresses);
        return "started";
    }

    @PostMapping ("/addStudents")
    public String addStudenForm(@Valid @ModelAttribute("newStudent") Student student, BindingResult result, RedirectAttributes redirectAttributes){
        System.out.println("Dawit  was in add controller ");
        if(result.hasErrors()){
            return "started";
        }
        studentService.save(student);
        redirectAttributes.addFlashAttribute("onestudents",student);

        return "redirect:/oneStudent";
    }
    @GetMapping ("/oneStudent")
    public String successfulPage(){

        return "successPage";
    }

    @GetMapping ("/getAllStudent")
    public String addStudenForm(Model model){
        List<Student> allStudent= studentService.findAllStudents();
        model.addAttribute("student",allStudent);

        return "studentList";
    }
    @GetMapping ("/get/{id}")
    public String getStudentById(@PathVariable("id") Long id, Model model)  {
      Optional<Student> student=  studentService.findStudentById(id);
      if(student.isPresent()){
        model.addAttribute("student",student.get());
        return "oneStudentPage";
      }
      else throw new UserNotFoundException("Student with this id is not Found");



    }
    @GetMapping("edit/{userId}")
    public String editUStudent(@PathVariable long userId, Model model) {
        Optional<Student> user = studentService.findStudentById(userId);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "edit";
        }
        return "redirect:/getAllStudent";
    }
    @PostMapping  (value = { "/edit"})
    public String updateUser(@Valid @ModelAttribute("user") Student student,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
          return "edit";

        }
        studentService.save(student);
        return "redirect:/getAllStudent";
    }
    @GetMapping (value = {"/delete/{id}"})
    public String deleteStudentById(@PathVariable(value="id")Long id){
     studentService.deleteStudent(id);
        return "redirect:/getAllStudent";

    }


@PostMapping(value = "/student/addStudentForm", produces = "application/json")
public @ResponseBody Student saveStudent(@Valid @RequestBody Student student) {
    System.out.println("i am at the controller");
    System.out.println(student);
    studentService.save(student);
    return student;
}
    @GetMapping("/getAjax")
    public String getAjaxStudentForm(@ModelAttribute("newStudent") Student student){
        return "ajaxsStarter";
    }


}
