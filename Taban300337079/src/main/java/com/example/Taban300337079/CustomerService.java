package com.example.Taban300337079;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private static List<Customer> todos = new ArrayList<Customer>();
    private static int todoCount = 4;

    static {
        todos.add(new Customer("SS","School Supplies","Dept","4","Regular"));
        todos.add(new Customer("SSs","School Suppliess","Deptt","14","Regular"));

    }

    public void initialadd(){

        todos.add(new Customer("SS","School Supplies","Dept","4","Regular"));
        todos.add(new Customer("SSs","School Suppliess","Deptt","14","Regular"));

    }

    public List<Customer> retrieveTodos(){
        List<Customer> filteredTodos = new ArrayList<Customer>();
        for (Customer todo : todos){
            filteredTodos.add(todo);
        }
        return filteredTodos;
    }
    public void addTodo(String custno, String custname,String cdep, String nyears,String savtype) {
        todos.add(new Customer(custno, custname,cdep,nyears,savtype));
    }

    public void deleteTodo(String id) {

        for (int i = 0; i < todos.size(); i++) {
            if(id.equals(todos.get(i).getCustno())) {
                todos.remove(i);
                break;
            }
        }
    }

    public Customer retrieve(String id){

        for(Customer todo: todos){
            if(todo.getCustno().equals(id)){
                return todo;
            }
        }
        return null;

    }

    public void update(Customer todo){
        todos.remove(todo);
        todos.add(todo);
    }

}
