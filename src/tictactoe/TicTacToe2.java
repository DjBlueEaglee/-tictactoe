/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

public class TicTacToe2 {
    char[][] dataArr = new char[3][3];
    Result rs = new Result();
    Scanner scan = new Scanner(System.in);
    
    public TicTacToe2(){
        String data ="";
        boolean validation;
        boolean repeat = false;
        while(!repeat){
            System.out.println("Tic Tac Toe");
            data=scan.next(); 
            if (validateData(data)){
                if(validateLength(data)){
                    repeat = true;
                }else{
                    System.out.println("please input 9 characters");
                }
            }else{
                System.out.println("choose either X or O or -");
            }
        }
        if(gameValidation(data)){
            saveChar(data);
            scoreValidation(dataArr);
            if(rs.getTotal() > 1){
                System.out.println("Invalid Game Board");
            }else if (rs.getTotal() == 1){
                System.out.println(rs.getValue()+ " Wins");
            }else{
                System.out.println("Draw");
            }
        }else{
            System.out.println("Game Still In Progress");
        }
        scan.close();
    }
    
    public boolean validateData(String data){
        boolean result = true;
        for (int i = 0 ; i != data.length() ; i++)
        {
            char a = data.charAt(i);
            char c = Character.toUpperCase(a);
            if(c != 'X' && c != 'O' && c != '-')
            {
                result = false;
            }
        }return result;
    }
    
    public boolean validateLength (String data){
        String input = data;
        boolean result = false;
        if(input.length() == 9){
            result = true;
        }return result;
    }
    
    public void saveChar(String data){
        int offset = 0;
        for(int i=0; i < 3; i++){
            for(int j=0; j< 3; j++){
                char a = data.charAt(offset++);
                char c = Character.toUpperCase(a);
                dataArr[i][j] = c;
            }
        }
    }
    
    public boolean gameValidation(String data){
        boolean result = true;
        for (int i = 0 ; i != data.length() ; i++)
        {
            char a = data.charAt(i);
            char c = Character.toUpperCase(a);
            if(c != 'X' && c != 'O')
            {
                result = false;
            }
        }return result;
    }
    
    public void scoreValidation(char[][] array){
        v_Horizontal1(array);
        v_Horizontal2(array);
        v_Horizontal3(array);
        v_Vertical1(array);
        v_Vertical2(array);
        v_Vertical3(array);
        v_Diagonal1(array);
        v_Diagonal2(array);
    }
    
    public void v_Horizontal1(char[][] array){
        if (array[0][0] == array[0][1] && array[0][1] == array[0][2]) {
            rs.setTotal(rs.getTotal()+1);
            rs.setValue(String.valueOf(array[0][0]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
    
    public void v_Horizontal2(char[][] array){
        if (array[1][0] == array[1][1] && array[1][1] == array[1][2]) {
           rs.setTotal(rs.getTotal()+1);
           rs.setValue(String.valueOf(array[1][0]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
    
    public void v_Horizontal3(char[][] array){
        if (array[2][0] == array[2][1] && array[2][1] == array[2][2]) {
           rs.setTotal(rs.getTotal()+1);
           rs.setValue(String.valueOf(array[2][0]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
    
    public void v_Vertical1(char[][] array){
        if (array[0][0] == array[1][0] && array[1][0] == array[2][0]) {
           rs.setTotal(rs.getTotal()+1);
           rs.setValue(String.valueOf(array[0][0]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
    
    public void v_Vertical2(char[][] array){
        if (array[0][1] == array[1][1] && array[1][1] == array[2][1]) {
           rs.setTotal(rs.getTotal()+1);
           rs.setValue(String.valueOf(array[0][1]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
    
    public void v_Vertical3(char[][] array){
        if (array[0][2] == array[1][2] && array[1][2] == array[2][2]) {
           rs.setTotal(rs.getTotal()+1);
           rs.setValue(String.valueOf(array[0][2]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
    
    public void v_Diagonal1(char[][] array){
        if (array[0][0] == array[1][1] && array[1][1] == array[2][2]) {
           rs.setTotal(rs.getTotal()+1);
           rs.setValue(String.valueOf(array[0][0]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
    
    public void v_Diagonal2(char[][] array){
        if (array[0][2] == array[1][1] && array[1][1] == array[2][0]) {
           rs.setTotal(rs.getTotal()+1);
           rs.setValue(String.valueOf(array[0][2]));
        }else{
            rs.setTotal(rs.getTotal());
            rs.setValue(rs.getValue());
        }
    }
}
