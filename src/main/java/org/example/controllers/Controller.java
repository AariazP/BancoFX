package org.example.controllers;


import lombok.Getter;
import lombok.Setter;
import org.example.application.Main;
import org.example.model.Banco;

@Getter
@Setter
public abstract class Controller {

    public Main main;
    Banco banco = Banco.getInstance();

    public static boolean isLogin;
    public static boolean isUpdate;
    public static boolean isEmp;


}
