package com.example.addnames.storage;

import java.util.ArrayList;

public class NameStorage {

    private NameStorage(){}

    private static NameStorage _nameStorage;

    public static NameStorage getInstance () {
        if(_nameStorage == null) {
            _nameStorage = new NameStorage();
            _nameStorage._names.add("Bhajan");
            _nameStorage._names.add("preet");
        }
        return _nameStorage;
    }

    private ArrayList<String> _names = new ArrayList<>();

    public void putName(String name) {
        _names.add(name);
    }

    public ArrayList<String> getNames() {
        return _names;
    }
}
