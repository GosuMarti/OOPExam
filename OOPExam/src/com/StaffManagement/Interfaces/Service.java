package com.StaffManagement.Interfaces;

import com.StaffManagement.FileHandlers.Reader;
import com.StaffManagement.FileHandlers.Writer;

public interface Service {
    Reader reader = new Reader();
    Writer writer = new Writer();

}
