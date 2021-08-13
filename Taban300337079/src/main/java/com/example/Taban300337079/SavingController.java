package com.example.Taban300337079;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"id","name","deposit","years","savingType","errMsg","errorMessage"})
@RequestMapping
@Controller
public class SavingController {
    DatabaseService service1;

    @Autowired
    CustomerService service;

    @Autowired
    Connection123 connet;

//    @Autowired
//    Connection1 con;

    List<Customer> filteredTodos = new ArrayList<Customer>();

    //a mapping when someone enters file
    @RequestMapping(value = "/savingstable", method = RequestMethod.GET)
    public String showCategorypage(ModelMap model, @RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {

        service1 = new DatabaseService(connet.connect());

        model.addAttribute("todos", service1.display());

        List<Customer> filteredTodos = new ArrayList<Customer>();

        filteredTodos = (List) model.get("todos");

        model.put("id",filteredTodos.get(0).getCustno());
        model.put("name",filteredTodos.get(0).getCustname());
        model.put("deposit",filteredTodos.get(0).getCdep());
        model.put("years",filteredTodos.get(0).getNyears());
        model.put("savingType",filteredTodos.get(0).getSavtype());

        return "savingstable";

    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCategoryPage2(ModelMap model) throws ClassNotFoundException, SQLException{

        service1 = new DatabaseService(connet.connect());

        model.addAttribute("todos", service1.display());

        List<Customer> filteredTodos = new ArrayList<Customer>();

        filteredTodos = (List) model.get("todos");

        model.put("id",filteredTodos.get(0).getCustno());
        model.put("name",filteredTodos.get(0).getCustname());
        model.put("deposit",filteredTodos.get(0).getCdep());
        model.put("years",filteredTodos.get(0).getNyears());
        model.put("savingType",filteredTodos.get(0).getSavtype());

        return "savingstable";

    }

    //add method
    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "savingsadd";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String custno, @RequestParam String custname, @RequestParam String cdep,@RequestParam String nyears,@RequestParam String savetype) throws SQLException, ClassNotFoundException{

        if(!((service1.search(custno))== null)){

            model.put("errorMessage","Record Existing");
            return "redirect:/savingstable";

        }

        Customer cc = new Customer(custno,custname,cdep,nyears,savetype);

        service1.add(cc);

        model.clear();
        return "redirect:/savingstable";
    }


    //update method
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException{

        model.put("id", id);

        // model.addAttribute("category",service.retrieve(id));

        Customer cc = service1.search(id);

        model.put("id",filteredTodos.get(0).getCustno());
        model.put("name",filteredTodos.get(0).getCustname());
        model.put("deposit",filteredTodos.get(0).getCdep());
        model.put("years",filteredTodos.get(0).getNyears());
        model.put("savingType",filteredTodos.get(0).getSavtype());

        return "catedit";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String custno, @RequestParam String custname, @RequestParam String cdep,@RequestParam String nyears,@RequestParam String savetype) throws SQLException, ClassNotFoundException {

        //get the old catcode
        String iid = (String) model.get("id");

        Customer cc = new Customer(custno,custname,cdep,nyears,savetype);

        service1.edit(cc,iid);

        service.addTodo(custno,custname,cdep,nyears,savetype);

        return "redirect:/";

    }

    //Delete method
    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {

        service1.delete(id);

        model.clear();
        return "redirect:/";
    }

    //Map the method that will call your items jsp

//    @RequestMapping(value ="/see-todo", method = RequestMethod.GET)
//    public String seetodo(ModelMap model, @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException {
//
//        model.put("id", id);
//
//        service1 = new DatabaseService(connet.connect());
//
//        String iid = (String) model.get("id");
//
//        List<Items> Itemlist = new ArrayList<Items>();
//
//        Itemlist = service1.display2(iid);
//
//        if(Itemlist.size()==0){
//            model.put("errorMessage","There are not items for this category ");
//            return "redirect:/";
//        }
//
//        model.put("desc",iid);
//
//        System.out.println(iid);
//        model.addAttribute("todos1",service1.display2(iid));
//
//        return "item";
//
//    }

  /*  @RequestMapping(value = "/see-todo", method = RequestMethod.POST)
    public String seetodo2(ModelMap model) throws SQLException, ClassNotFoundException{
        return "redirect:/";
    }*/


}
