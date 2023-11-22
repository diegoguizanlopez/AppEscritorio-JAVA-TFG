/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 * @param <T>
 */
public class MyListModel<T> extends DefaultListModel {

    List<GeneralClass> list = new ArrayList<>();

    public ArrayList<GeneralClass> getAll() {
        return (ArrayList<GeneralClass>) list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public GeneralClass getElementAt(int index) {
        return (GeneralClass) list.get(index);
    }

    public void addList(int index, GeneralClass item) {
        list.add(index, item);
        Collections.sort(list);
        fireIntervalAdded(this, index, index);
    }

    public boolean remove(GeneralClass i) {
        int index=0;
        List temp = list;
        boolean removed=false;
        for (int j = 0; j < list.size(); j++) {
            if(list.get(j).getId().equals(i.getId())){
                temp.remove(j);
                removed=!removed;
            }
        }
        list=temp;
        fireIntervalRemoved(this, index, index);
        return removed;
    }

    @Override
    public void removeAllElements() {
        int listLength = list.size();
        list = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            fireIntervalRemoved(this, i, i);
        }
    }

    public boolean removeList(int index) {
        var value = list.remove(index);
        fireIntervalRemoved(this, index, index);
        return value != null;
    }
    
    public boolean removeById(Integer id) {
        for (int i = 0; i < 10; i++) {
            if(list.get(i).getId().equals(id)){
                list.remove(i);
                fireIntervalRemoved(this, i, i);
                return true;
            }
        }
        return false;
    }
    

    @Override
    public boolean contains(Object elem) {
        return getAll().stream().anyMatch((t) -> Objects.equals(t.getId(), ((GeneralClass) elem).getId()));
    }

    public void update(GeneralClass obj) {
        getAll().stream().filter((t) -> Objects.equals(t.getId(), obj.getId())).forEach((t) -> {
            list.set(getAll().indexOf(t), obj);
        });
        fireContentsChanged(this, getAll().indexOf(obj), getAll().indexOf(obj));
    }

}
