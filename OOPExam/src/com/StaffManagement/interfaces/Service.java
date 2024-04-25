package com.StaffManagement.interfaces;

import com.StaffManagement.filehandler.Reader;
import com.StaffManagement.filehandler.Writer;

public interface Service {
    Reader reader = new Reader();
    Writer writer = new Writer();

}
