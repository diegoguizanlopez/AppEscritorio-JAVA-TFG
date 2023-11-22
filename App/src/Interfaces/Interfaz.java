package Interfaces;

import Modelo.Empresas;
import Modelo.MyListModel;
import Modelo.VideoJuegos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author diego
 */
public interface Interfaz {

    MyListModel<Empresas> modelE = new MyListModel<>();
    MyListModel<Empresas> modelE_Insert = new MyListModel<>();
    MyListModel<VideoJuegos> modelV = new MyListModel<>();
    MyListModel<VideoJuegos> modelV_Insert = new MyListModel<>();
    ArrayList<Boolean> WindowChecker = new ArrayList<>(Arrays.asList(false,false,false));
}
