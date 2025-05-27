//ShowHomeController.java(27/28.03.2025)
package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ShowHomeController {
	   /*@RequestMapping("/home")
       public String showHomePage(Map<String,Object> map) {
		   System.out.println("ShowHomeController.showHomePage()::Shared Memory Object Class Name::"+map.getClass());
    	   //Add Attribute (Model Attributes) To Shared Memory
		   map.put("attr1","Val1");
		   map.put("attr2","Val2");
		   //Return LVN
		   return "welcome";
       }*/
	   
	   /*@RequestMapping("/")
       public String showHomePage() {
 	           //Return LVN
		       return "welcome";
        }*/
	
	   /*@RequestMapping("/home")
       public String showHomePage(Model model) {
		   System.out.println("ShowHomeController.showHomePage()::Shared Memory Object Class Name::"+model.getClass());
    	   //Add Attribute (Model Attributes) To Shared Memory
		   model.addAttribute("attr1","Val1");
		   model.addAttribute("attr2","Val2");
		   //Return LVN
		   return "welcome";
       }*/
	   
	/*@RequestMapping("/home")
    public String showHomePage(ModelMap map) {
		   System.out.println("ShowHomeController.showHomePage()::Shared Memory Object Class Name::"+map.getClass());
 	   //Add Attribute (Model Attributes) To Shared Memory
		   map.addAttribute("attr1","Val1");
		   map.put("age",new Random().nextInt(99));
		   //Return LVN
		   return "welcome";
    }*/
	
	/*@RequestMapping("/home")
    public String showHomePage(ExtendedModelMap map) {
		   System.out.println("ShowHomeController.showHomePage()::Shared Memory Object Class Name::"+map.getClass());
 	   //Add Attribute (Model Attributes) To Shared Memory
		   map.addAttribute("attr1","Val1");
		   map.put("age",new Random().nextInt(99));
		   //Return LVN
		   return "welcome";
    }*/
	
	/*@RequestMapping("/home")
    public String showHomePage(BindingAwareModelMap map) {
		   System.out.println("ShowHomeController.showHomePage()::Shared Memory Object Class Name::"+map.getClass());
 	   //Add Attribute (Model Attributes) To Shared Memory
		   map.addAttribute("attr1","Val1");
		   map.put("age",new Random().nextInt(99));
		   //Return LVN
		   return "welcome";
    }*/
	
	/*@RequestMapping("/home")
    public ModelAndView showHomePage(){
		//Create SharedMemory Explicitly
		ModelAndView mav=new ModelAndView();
		//Add Model Attributes
		mav.addObject("attr1","Val1");
		mav.addObject("age",new Random().nextInt(1000));
		//Add LVN
		mav.setViewName("welcome");
		return mav;
	}*/
	
	/*@RequestMapping("/home") //Since LVN Is Returned, The Requested Path Itself Becomes LVN
    public Model showHomePage(){
		//Create SharedMemory Explicitly
		Model model=new BindingAwareModelMap();
		//Add Model Attributes
		model.addAttribute("attr1","Val1");
		model.addAttribute("age",new Random().nextInt(1000));
		return model;
	}*/
	
	/*@RequestMapping("/home") 
    public Map<String,Object> showHomePage(){
		//Create SharedMemory Explicitly
		Map<String,Object> map=new HashMap();
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		return map;
	}*/
	
	/*@RequestMapping("/home") 
    public void showHomePage(Map<String,Object> map){
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
	}*/
	
	/*@RequestMapping("/home") 
    public String showHomePage(Map<String,Object> map,HttpSession ses){
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		ses.setAttribute("sysDate", new Date());
		return "welcome";
	}*/
	
	/*@Autowired
	private ServletConfig cg;
	@Autowired
	private ServletContext sc;
	
	@RequestMapping("/home") 
    public String showHomePage(Map<String,Object> map){
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		sc.setAttribute("email","raja@rani.com");
		System.out.println("ServletContext Object Class Name::"+sc.getClass());
		System.out.println("ServletConfig Object Class Name::"+cg.getClass());
		return "welcome";
	}*/
	
	/*@RequestMapping("/home") 
    public void showHomePage(HttpServletResponse res) throws IOException{
        //Get PrintWriter Object
		PrintWriter pw=res.getWriter();
		//Write Messages To Browser Directly
		pw.println("<b>Hello How Are U</b>");
	}*/
	
	@RequestMapping("/home") 
    public void showHomePage(HttpServletResponse res) throws IOException{
        //Get PrintWriter Object
		PrintWriter pw=res.getWriter();
		//Make The Response As The Downloadbale File
		res.setHeader("Content-Disposition", "attachment;fileName=abc.txt");
		//Write Messages To Browser Directly
		pw.println("<b>Hello How Are U</b>");
	}
	
	/*@RequestMapping("/home") 
    public String showHomePage(Map<String,Object> map){
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		return null;
	}*/
	
	/*@RequestMapping("/home") 
    public String showHomePage(Map<String,Object> map){
		System.out.println("ShowHomeController.showHomePage()");
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map) {
		System.out.println("ShowHomeController.showReport()");
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		return "show_report";
	}*/
	
	/*@RequestMapping("/home") 
    public String showHomePage(Map<String,Object> map,HttpServletRequest req){
		System.out.println("ShowHomeController.showHomePage()");
		//Request Attribute
		req.setAttribute("sysDate", new Date());
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map,HttpServletRequest req) {
		System.out.println("ShowHomeController.showReport()");
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		System.out.println("Request Attribute Value::"+req.getAttribute("sysDate"));
		return "show_report";
	}*/
	
	/*@RequestMapping("/home") 
    public String showHomePage(Map<String,Object> map){
		System.out.println("ShowHomeController.showHomePage()");
		return "redirect:report";
	}
	
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map) {
		System.out.println("ShowHomeController.showReport()");
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		return "show_report";
	}*/
	
	/*@RequestMapping("/home") 
    public String showHomePage(Map<String,Object> map,HttpServletRequest req){
		System.out.println("ShowHomeController.showHomePage()");
		//Set Request Attribute Value
		req.setAttribute("sysDate", new Date());
		return "redirect:report?sysDate="+new Date();
	}
	
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map,HttpServletRequest req) {
		System.out.println("ShowHomeController.showReport()");
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		//Read Request Attribute Value
		System.out.println("AdditionalReq Param Value::"+req.getParameter("sysDate"));
		return "show_report";
	}*/
	
	/*@RequestMapping("/report")
	public String showReport(Map<String,Object> map,HttpServletRequest req,HttpServletResponse res) {
		System.out.println("ShowHomeController.showReport()");
		//Add Model Attributes
		map.put("attr1","Val1");
		map.put("age",new Random().nextInt(1000));
		//Read Request Attribute Value
		System.out.println("AdditionalReq Param Value::"+req.getParameter("sysDate"));
		System.out.println("Request Object Class Name::"+req.getClass());
		System.out.println("Response Object Class Name::"+res.getClass());
		return "show_report";
	}*/
	
	
}
