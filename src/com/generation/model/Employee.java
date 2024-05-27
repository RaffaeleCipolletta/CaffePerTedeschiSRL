package com.generation.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Un employee è una persona che lavora per noi
 */
public class Employee extends Entity implements Comparable<Employee>
{
    @Override
    public int compareTo(Employee o) 
    {
        //deve restituire un numero POSITIVO se this>o
        //0 se sono uguali
        //NEGATIVO se this<0
        String myNominative = this.name+this.surname;
        String yourNominative = o.name+o.surname;

        return myNominative.compareTo(yourNominative);
    }


    private String name,surname;

    private List<Product> products = new ArrayList<>();


    public Employee(){}

    public Employee(String name, String surname)
    {
        super();
        this.name = name;
        this.surname = surname;
    }

    public Employee(Integer id, String name, String surname) 
    {
        super(id);
        this.name = name;
        this.surname = surname;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSurname() 
    {
        return surname;
    }

    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) 
    {
        if(products!=null)
            for(Product p : products)
                addProduct(p);
    }

    public void addProduct(Product p)
    {
        products.add(p);
        p.setEmployee(this);
    }
    
    public void removeProduct(Product p)
    {
        products.remove(p);
        p.setEmployee(null);
    }

    @Override
    public  List<String> getErrors()
    {
        ArrayList<String> res = new ArrayList<>();

        if(name==null || name.isBlank())
            res.add("Nome non valido");

        if(surname==null || surname.isBlank())
            res.add("Surname non valido");

        return res;
    }

    @Override
    public boolean equals(Object o)
    {
        return super.equals(o) && o instanceof Employee;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", surname=" + surname + "]";
    }

  

    
}
