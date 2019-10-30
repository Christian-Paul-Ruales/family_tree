/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Hashtable;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 *
 * @author RJ
 */
public class tree {
    

    private String person1;
    private String person2;
    private String finalMessage;
    ///               Part A
    private String personA;
    private String relation;

   
    
    public String getPerson1() {
        return person1;
    }

    public void setPerson1(String person1) {
       
        this.person1 = person1;
    }

    public String getPerson2() {
        return person2;
    }

    public void setPerson2(String person2) {
        
        
        this.person2 = person2;
    }

    public String getFinalMessage() {
        return finalMessage;
    }

    public void setFinalMessage(String finalMessage) {
        this.finalMessage = finalMessage;
    }
    
     public String getPersonA() {
        return personA;
    }

    public void setPersonA(String personA) {
        this.personA = personA;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    
    
    public Query connect_prolog(){
        Query conection=null;
        try {
            String  Query_base="consult('n.pl')";
            conection = new Query(Query_base);
            System.out.println(Query_base+"  -  "+(conection.hasMoreSolutions()?"Aceptado":"Fallido"));
        }catch(Exception e){
            System.out.println("------------------------------Error Conection prolog: "+e.getMessage());
        }
        return conection;
    }
    public void search_by_relation(){
         Query con=connect_prolog();
         this.personA=this.personA.replace(" ", "_");
         this.personA=this.personA.toLowerCase();
         if(con==null){
            System.out.println("-----------------------------------------------------Se ha devuelto una coneccion nula ");
        }else{
            this.finalMessage="Base del conocimiento agregada con exito:\n";
        }
         this.relation=this.relation.toLowerCase();
         if(this.relation=="cuñado"){
             this.relation="cunado";
         }
         String command=this.relation+"(X,"+this.personA+").";
         this.finalMessage=finalMessage+this.relation+"/s de "+this.personA+":\n"+ExecuteReturn(command);

    }
    
    public void relation(){
        String tmp_person1=this.person1;
            String tmp_person2=this.person2;
             this.person1 = this.person1.replace(" ", "_");
             this.person1= this.person1.toLowerCase();
             this.person2 = this.person2.replace(" ", "_");
             this.person2= this.person2.toLowerCase();
             
        String q_padre="padre("+this.person1+","+this.person2+").";
        String q_madre="madre("+this.person1+","+this.person2+").";
        String q_hijo="hijo("+this.person1+","+this.person2+").";
        String q_hija="hija("+this.person1+","+this.person2+").";
        String q_esposo="esposo("+this.person1+","+this.person2+").";
        String q_esposa="esposa("+this.person1+","+this.person2+").";
        String q_hermano="hermano("+this.person1+","+this.person2+").";
        String q_hermana="hermana("+this.person1+","+this.person2+").";
        String q_tio="tio("+this.person1+","+this.person2+").";
        String q_tia="tia("+this.person1+","+this.person2+").";
        String q_sobrino="sobrino("+this.person1+","+this.person2+").";
        String q_sobrina="sobrina("+this.person1+","+this.person2+").";
        String q_abuelo="abuelo("+this.person1+","+this.person2+").";
        String q_abuela="abuela("+this.person1+","+this.person2+").";
        String q_nieto="nieto("+this.person1+","+this.person2+").";
        String q_nieta="nieta("+this.person1+","+this.person2+").";
        String q_primo="primo("+this.person1+","+this.person2+").";
        String q_prima="prima("+this.person1+","+this.person2+").";
        String q_cunado="cunado("+this.person1+","+this.person2+").";
        String q_cunada="cunada("+this.person1+","+this.person2+").";
        String q_bisabuelo="bisabuelo("+this.person1+","+this.person2+").";
        String q_bisabuela="bisabuela("+this.person1+","+this.person2+").";

        Query con=connect_prolog();
        if(con==null){
            System.out.println("-----------------------------------------------------Se ha devuelto una coneccion nula ");
        }else{
                try {
                    if(this.finalMessage.equals("") || this.finalMessage==null){

                    this.finalMessage="Base del conocimiento agregada con exito:\n";
                }else{
                    this.finalMessage=this.finalMessage+"\n-------------------------------------------------\n";
                }
            } catch (Exception e) {
                    System.out.println("-----------------------------------------------------------Relation class tree["+e.getMessage());
            }
            
            
        }
        this.finalMessage=finalMessage+Execute(q_padre,"padre",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_madre,"madre",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_hijo,"hijo",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_hija,"hija",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_esposo,"esposo",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_esposa,"esposa",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_hermano,"hermano",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_hermana,"hermana",tmp_person1,tmp_person2);
         this.finalMessage=finalMessage+Execute(q_tio,"tio",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_tia,"tia",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_sobrino,"sobrino",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_sobrina,"sobrina",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_abuelo,"abuelo",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_abuela,"abuela",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_nieto,"nieto",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_nieta,"nieta",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_primo,"primo",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_prima,"prima",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_cunado,"cuñado",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_cunada,"cuñada",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_bisabuelo,"bisabuelo",tmp_person1,tmp_person2);
        this.finalMessage=finalMessage+Execute(q_bisabuela,"bisabuela",tmp_person1,tmp_person2);
    }
    
    public String ExecuteReturn(String consult){
        String solution="";
        Query execute_query=null;
        try{
            
            execute_query=new Query(consult);
            while ( execute_query.hasMoreSolutions() ){
                String AuxSolution=execute_query.nextSolution().get("X").toString();
                solution=solution+"\n"+AuxSolution;
                System.out.println( "X = " + solution);
            }
            
            
        }catch(Exception ex){
            System.out.println("-------------------Error Executing :"+consult+": "+ex.getMessage());
        }
        return solution;
    }
    public String Execute(String consult,String relation,String tmp_person1,String tmp_person2){
        String solution=null;
        Query execute_query=null;
        try{
            
            execute_query=new Query(consult);
            if(execute_query.hasSolution()){
                
                solution=tmp_person1+" es "+ relation + " de "+tmp_person2+" \n";
            }else{
               solution="";
            }
        }catch(Exception ex){
            System.out.println("-------------------Error Executing :"+consult+": "+ex.getMessage());
        }
        return solution;
    }
    

}
