/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Assembler;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    Map<String, Type> TypeMap = new HashMap<String, Type>();
    Map<String, Integer> OffsetMap = new HashMap<String, Integer>();

    public void insert(String s, Type t, int address) {
        if (!TypeMap.containsKey(s)) {
            TypeMap.put(s, t);
        } else {
            throw new IllegalArgumentException("Variabile gia’ dichiarata.");
        }
        if (!OffsetMap.containsValue(address)) {
            OffsetMap.put(s, address);
        } else {
            throw new IllegalArgumentException("Riferimento ad una locazione di memoria gia’ occupata da un’altra variabile. ");
        }

    }

    public Type lookupType(String s) {
        if (TypeMap.containsKey(s)) {
            return TypeMap.get(s);
        }
        throw new IllegalArgumentException("Variabile sconosciuta ." + s);
    }

    public int lookupAddress(String s) {
        if (OffsetMap.containsKey(s)) {
            return OffsetMap.get(s);
        }
        throw new IllegalArgumentException("Variabile sconosciuta.");
    }
}
