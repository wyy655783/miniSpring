package com.minis.beans;

import java.util.*;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-16 09:30
 **/
public class ArgumentValues {
    private final Map<Integer, ArgumentValue> indexedArgumentValues = new HashMap<>(0);
    private final List<ArgumentValue> genericArgumentValues = new LinkedList<>();
    public ArgumentValues() {

    }



    private void addGenericArgumentValue(ArgumentValue newValue){
        if (newValue.getName() != null){
            for (Iterator<ArgumentValue> it = this.genericArgumentValues.iterator(); it.hasNext();) {
                ArgumentValue currentValue = it.next();
                if (newValue.getName().equals(currentValue.getName())){
                    it.remove();
                }
            }

//            for (ArgumentValue currentValue:this.genericArgumentValues) {
//                if (newValue.getName().equals(currentValue.getName())){
//                    this.genericArgumentValues.remove(currentValue);
//                }
//            }

        }
    }

    public ArgumentValue getGenericArgumentValue(String requireName){
        for (ArgumentValue valueHolder : this.genericArgumentValues) {
            if (valueHolder.getValue()!=null && (requireName ==null || ! valueHolder.getName().equals(requireName))){
                continue;
            }
            return valueHolder;
        }
        return null;
    }

    public int getArgumentCount(){
        return this.genericArgumentValues.size();
    }

    public boolean isEmpty(){
        return this.genericArgumentValues.isEmpty();
    }
    
}
