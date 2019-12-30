package com.hg.controller;

import com.hg.common.HtmlResponse;
import com.hg.common.PropertiesUtil;
import com.hg.model.Person;
import com.hg.tools.kafka.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class MvcController {

    private static final Logger logger = LoggerFactory.getLogger(MvcController.class);

    @RequestMapping("/")
    public String doIndex() throws Exception {
        return "index";
    }

    @RequestMapping("/restindex")
    public String doRestIndex() throws Exception {
        return "restindex";
    }

    @RequestMapping("/person")
    public String toPerson(String name,double age){
        System.out.println(name+" "+age);
        return "hello";
    }

    @RequestMapping(value="/person1", method = RequestMethod.POST)
    public String toPerson(Person p){
        System.out.println(p.getName()+" "+p.getAge());
        return "index";
    }

    @RequestMapping("/show")
    public String showPerson(Map<String,Object> map){
        Person p =new Person();
        map.put("p", p);
        p.setAge(20);
        p.setName("jayjay");
        return "show";
    }

    @RequestMapping("/getPerson")
    public void getPerson(String name,HttpServletResponse response) throws Exception {
        HtmlResponse.pageTextResponse(response, "hello,"+name);
    }

    @RequestMapping("/name")
    public String sayHello(){
        return "name";
    }

    @RequestMapping(value="/upload",method= RequestMethod.POST)
    public String upload(HttpServletRequest req) throws Exception{
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest)req;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/")+
                "/"+sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.')));
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
        return "index";
    }

    @RequestMapping("/testexception")
    public String error(){
        int i = 5/0;
        return "index";
    }

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        logger.info("in testExceptionHandler");
        return mv;
    }

    @RequestMapping("/produce")
    public String produce() throws Exception {
        PropertiesUtil util = new PropertiesUtil("resource/kafka.properties");
        Main main = new Main();
        main.produce(util.getProperties());
        return "index";
    }

    @RequestMapping("/consume")
    public String consume() throws Exception {
        PropertiesUtil util = new PropertiesUtil("resource/kafka.properties");
        Main main = new Main();
        main.consume(util.getProperties());
        return "index";
    }
}
