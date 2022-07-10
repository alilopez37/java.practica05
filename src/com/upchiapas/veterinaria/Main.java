package com.upchiapas.veterinaria;

import com.upchiapas.veterinaria.models.Cliente;
import com.upchiapas.veterinaria.models.Mascota;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public static void main(String[] args) {

        byte option=0;
        do {
            option = printMenu();
            switch (option){
                case 1: addClient(); break;
                case 2: addMascotas(); break;
                case 3: printClient(); break;
            }
        } while (option != 4);
        System.out.println("Gracias por utilizar la aplicación");
    }

    private static void addClient(){
        int id;
        String name;
        Cliente client;
        System.out.println("================================");
        System.out.println("Módulo - Agregar clientes");

        System.out.print("Nombre: ");
        name = keyboard.nextLine();
        client = new Cliente(name);
        if (listaClientes.add(client)){
            System.out.println("Registro exitoso!!!!");
            System.out.println("================================");
            System.out.print("¿Desea registrar alguna mascota? (S/N): ");
            while (Character.toUpperCase(keyboard.nextLine().charAt(0)) == 'S'){
                if (addPet(client)){
                    System.out.println("Registro exitoso!!!!");
                } else
                    System.out.println("Ocurrio un error en el registro!!! \n Intenta nuevamente");
                System.out.println("================================");
                System.out.print("¿Desea repetir el proceso de registro de mascota? (S/N): ");
            }

        } else
            System.err.println("No fue posible agregar al cliente");
    }

    private static boolean addPet(Cliente client){
        String name;
        int dia;
        int mes;
        int anio;

        System.out.print("Nombre de la mascota: ");
        name = keyboard.nextLine();
        System.out.println("Fecha de nacimiento");
        System.out.print("Día: "); dia = keyboard.nextInt();
        System.out.print("Mes: "); mes = keyboard.nextInt();
        System.out.print("Año: "); anio = keyboard.nextInt();
        keyboard.nextLine(); //Limpiar buffer
        return client.addMascota(new Mascota(name, LocalDate.of(anio,mes,dia)));
    }

    private static void addMascotas(){

        System.out.println("================================");
        System.out.print("Introduce el nombre del cliente: ");
        Cliente client = findClient(keyboard.nextLine());
        if (client != null){
            if (addPet(client)){
                System.out.println("Registro exitoso!!!!");
            } else
                System.out.println("Ocurrio un error en el registro!!! \n Intenta nuevamente");   
        }
        keyToPreset();
    }
    private static Cliente findClient(String name){
        Cliente client = null;
        boolean status = false;
        int index = 0;
        System.out.println("---------------------------------");
        System.out.println("Coindidencias encontradas...");
        while (index < listaClientes.size()){
            if (listaClientes.get(index).getNombre().matches(".*"+name+".*")){
                System.out.println(listaClientes.get(index).getId() +
                        ". "+ listaClientes.get(index).getNombre());
                status = true;
            }
            index++;
        }
        if (status){
            System.out.print("Ingresa el número del cliente: ");
            client = listaClientes.get(keyboard.nextInt()-1);
            keyboard.nextLine();
        } else
            System.out.println("No  se encontró ninguna coincidencia");
        
        return client;
    }
    
    private static void printClient(){
        
        if (listaClientes.isEmpty()){
            System.out.println("=================================");
            System.out.println("No se encontraron registros");
            System.out.println("=================================");
        } else {
            for (Cliente client : listaClientes){
                System.out.println("=================================");
                System.out.println("Id:     "+ client.getId());
                System.out.println("Nombre: "+ client.getNombre());
                System.out.println("---------------------------------");
                if (client.getPets().isEmpty())
                    System.out.println("No se han registro mascotas para este usuario.");
                else {
                    for (Mascota pet: client.getPets()) {
                        System.out.println("    "+ pet.getId() +". Nombre mascota:     "+ pet.getNombre());
                        System.out.println("    Nacimiento: "+ pet.getFechaNacimiento());
                    }
                }
            }
            keyboard.nextLine();
        }
        keyToPreset();
    }

    private static void keyToPreset(){
        System.out.print("\nPresione una tecla para continuar....");
        keyboard.nextLine();
    }
    private static byte printMenu() {

        byte option = 0;

        System.out.println("VETERINARIA LA GARRAPATA");
        System.out.println("\nMenú de opciones");
        System.out.println("    1. Agregar cliente y mascotas");
        System.out.println("    2. Agregar mascotas");
        System.out.println("    3. Imprimir clientes y mascotas");
        System.out.println("    4. Salir");
        System.out.print("Selecciona una opción: ");
        try {
            option = keyboard.nextByte();
            keyboard.nextLine();
        } catch (Exception e) {
            System.err.println(e);
        }
        return option;
    }
}
