package org.example.controllers;

public class Singleton {

    private static class SingletonHolder {

        private final static Singleton eINSTANCE = new Singleton();
    }

    public static Singleton getInstance() {

        return SingletonHolder.eINSTANCE;
    }

    public Singleton() {

        inicializarDatos();
    }

    private void inicializarDatos() {
    }
}
