package controllers;

import com.sun.tools.javac.Main;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import views.MenuView;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    MenuView mwp = new MenuView();

    public void accionPrincipal(){
        int opm = mwp.menuPrincipal();
        switch (opm){
            case 1:
                mwp.menuUsuario();
                break;
            case 2:
                mwp.menuPublicacion();
                break;
            case 3:
                mwp.menuGrupo();
                break;
        }
    }

    public void accionUsuaro(){
        int opu = mwp.menuUsuario();
        switch (opu){
            case 1:


                break;
            case 2:


                break;
            case 3:


                break;
            case 4:


                break;
        }
    }

    public  void accionPublicacion(){
        int opp = mwp.menuPublicacion();
        switch (opp){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    public  void accionGrupo(){
        int opg = mwp.menuGrupo();
        switch (opg){
            case 1:


                break;
            case 2:


                break;
            case 3:


                break;
            case 4:


                break;
        }
    }


}
